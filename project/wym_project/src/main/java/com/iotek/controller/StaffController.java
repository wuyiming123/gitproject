package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Resource
    private StaffDetailService staffDetailService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private CheckWorkService checkWorkService;
    @Resource
    private StaffIdService staffIdService;
    @Resource
    private TrainService trainService;
    @Resource
    private ChangeService changeService;
    @Resource
    private SalaryService salaryService;

    @RequestMapping("staffdetail")
    public String staffdetail(HttpSession session)throws Exception{
        List<Departement> departements = departmentService.queryAllDepartment();
        List<Position> positions = positionService.queryAllPosi();
        session.setAttribute("alldepartment",departements);
        session.setAttribute("allposition",positions);
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        session.setAttribute("allstaffdetail",staffDetails);
        return "staffdetail";
    }

    @RequestMapping("querystaffbysd_id")
    @ResponseBody
    public StaffDetail querystaffbysd_id(Integer sd_id)throws Exception{
        StaffDetail staffDetail = staffDetailService.foundDetailBySD_ID(sd_id);
        System.err.println(staffDetail);
        return staffDetail;
    }

    @RequestMapping("helloCheckWork")
    public String helloCheckWork(Integer sdid, HttpServletResponse response,HttpSession session)throws Exception{
        CheckWork checkWork = new CheckWork();
        checkWork.setCw_sdid(sdid);
        checkWork.setCw_state(0);
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
        int minute=cal.get(Calendar.MINUTE);//分
        int second=cal.get(Calendar.SECOND);//秒
        String h = String.valueOf(hour);
        String m = String.valueOf(minute);
        String s = String.valueOf(second);
        String hms = h+":"+m+":"+s;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date hellodate = formatter.parse(hms);
        String date0 = "09:00:00";
        Date date1 = formatter.parse(date0);
        int ms = (int) (date1.getTime()-hellodate.getTime())/1000/60;
        checkWork.setCw_smalltime(ms);
        checkWork.setCw_time(hms);
        int year=cal.get(Calendar.YEAR);//年
        int month=cal.get(Calendar.MONTH)+1;//月
        int day=cal.get(Calendar.DATE);//日
        String y = String.valueOf(year);
        String mon = String.valueOf(month);
        String d = String.valueOf(day);
        String ymd = y+"-"+mon+"-"+d;
        checkWork.setCw_date(ymd);
        System.err.println(ymd);
//        session.setAttribute("ready_to_work",0);
        if(hour<18){
            session.setAttribute("time",2);
        }
        if(hour>18){
            session.setAttribute("time",1);
        }
        checkWorkService.hellocheckwork(checkWork);
        return "staff";
    }
    @RequestMapping("bybyCheckWork")
    public String bybyCheckWork(Integer sdid, HttpServletResponse response,HttpSession session)throws Exception{
        CheckWork checkWork = new CheckWork();
        checkWork.setCw_sdid(sdid);
        checkWork.setCw_state(1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
        int minute=cal.get(Calendar.MINUTE);//分
        int second=cal.get(Calendar.SECOND);//秒
        String h = String.valueOf(hour);
        String m = String.valueOf(minute);
        String s = String.valueOf(second);
        String hms = h+":"+m+":"+s;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date bybydate = formatter.parse(hms);
        String date0 = "18:00:00";
        Date date1 = formatter.parse(date0);
        int ms = (int)(bybydate.getTime()-date1.getTime())/1000/60;
        checkWork.setCw_smalltime(ms);
        if(ms<0){
            checkWork.setCw_smalltime(0);
        }
        checkWork.setCw_time(hms);
        int year=cal.get(Calendar.YEAR);//年
        int month=cal.get(Calendar.MONTH)+1;//月
        int day=cal.get(Calendar.DATE);//日
        String y = String.valueOf(year);
        String mon = String.valueOf(month);
        String d = String.valueOf(day);
        String ymd = y+"-"+mon+"-"+d;
        checkWork.setCw_date(ymd);
        CheckWork ck = new CheckWork();
        if(hour<15){
            Change change = new Change();
            change.setC_sid(sdid);
            change.setC_money(-300);
            change.setC_time(ymd);
            change.setC_why("晚上早退:"+ms+"分钟,旷工处理");
            change.setC_state(-1);
            Change change1 = changeService.foundChangeBydate_id(change);
            ck.setCw_sdid(sdid);
            ck.setCw_date(ymd);
            CheckWork checkWork1 = checkWorkService.foundCheckWorkBydate_id(ck);
            if(checkWork1!=null){
                changeService.delchange(change);

            }
            changeService.addNewChange(change);
        }
        if(hour<18 && hour>=15){
            Change change = new Change();
            change.setC_sid(sdid);
            change.setC_money(-50);
            change.setC_time(ymd);
            change.setC_why("晚上早退:"+ms+"分钟");
            change.setC_state(-1);
            Change change1 = changeService.foundChangeBydate_id(change);
            ck.setCw_sdid(sdid);
            ck.setCw_date(ymd);
            CheckWork checkWork1 = checkWorkService.foundCheckWorkBydate_id(ck);
            if(checkWork1!=null){
                Integer cw_smalltime =Math.abs(checkWork1.getCw_smalltime());
                if(cw_smalltime>=180){
                    changeService.delchange(change);
                    change.setC_why("迟到早退总计超过3小时，按旷工处理");
                    change.setC_money(-300);
                    changeService.addNewChange(change);
                }
                if(cw_smalltime<180){
                    changeService.delchange(change);
                    changeService.addNewChange(change);
                }
            }if(checkWork1==null){
                changeService.addNewChange(change);
            }
        }

        session.setAttribute("ready_to_home",1);
        checkWorkService.hellocheckwork(checkWork);
        return "staff";
    }
    @RequestMapping("fuckCheckWork")
    public String fuckCheckWork(Integer sdid, HttpServletResponse response,HttpSession session)throws Exception{
        CheckWork checkWork = new CheckWork();
        checkWork.setCw_sdid(sdid);
        checkWork.setCw_state(666);
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
        int minute=cal.get(Calendar.MINUTE);//分
        int second=cal.get(Calendar.SECOND);//秒
        String h = String.valueOf(hour);
        String m = String.valueOf(minute);
        String s = String.valueOf(second);
        String hms = h+":"+m+":"+s;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date hellodate = formatter.parse(hms);
        String date0 = "09:00:00";
        Date date1 = formatter.parse(date0);
        int ms = (int) Math.abs(date1.getTime()-hellodate.getTime())/1000/60;
        checkWork.setCw_smalltime(ms);
        checkWork.setCw_time(hms);
        int year=cal.get(Calendar.YEAR);//年
        int month=cal.get(Calendar.MONTH)+1;//月
        int day=cal.get(Calendar.DATE);//日
        String y = String.valueOf(year);
        String mon = String.valueOf(month);
        String d = String.valueOf(day);
        String ymd = y+"-"+mon+"-"+d;
        checkWork.setCw_date(ymd);
//        session.setAttribute("WTF",666);
        if(hour<18){
            session.setAttribute("time",2);
        }
        if(hour>18){
            session.setAttribute("time",1);
        }
        Change change = new Change();
        change.setC_sid(sdid);
        change.setC_money(-50);
        change.setC_time(ymd);
        change.setC_why("早上迟到:"+ms+"分钟");
        change.setC_state(-1);
        changeService.addNewChange(change);
        checkWorkService.hellocheckwork(checkWork);
        return "staff";
    }
    @RequestMapping("tostaff")
    public String tostaff()throws Exception{
        return "staff";
    }

    @RequestMapping("myDetail")
    public String myDetail(Integer sdid,HttpSession session)throws Exception{
        Staff staff = staffService.foundStaffByS_SDID(sdid);
        List<StaffId> staffIds = staffIdService.queryStaffIdBy(sdid);
        List<Train> trains = trainService.queryAllTrain();
        StaffDetail staffDetail = staffDetailService.foundDetailBySD_ID(sdid);
        session.setAttribute("mystaffdetail",staffDetail);
        session.setAttribute("mystaff",staff);
        session.setAttribute("trains",trains);
        session.setAttribute("staffIds",staffIds);
        return "staffinformation";
    }

    @RequestMapping("updateMyDetail")
    public String updateMyDetail(Integer sd_id,HttpSession session,HttpServletRequest request)throws Exception{
        StaffDetail staffDetail = staffDetailService.foundDetailBySD_ID(sd_id);
        request.setAttribute("mystaffdetail",staffDetail);
        List<Departement> departements = departmentService.queryAllDepartment();
        List<Position> positions = positionService.queryAllPosi();
        session.setAttribute("departements",departements);
        session.setAttribute("positions",positions);
        return "staffupdatedetail";
    }

    @RequestMapping("upStaffDetail")
    public String upStaffDetail(StaffDetail staffDetail,HttpSession session)throws Exception{
        Integer sd_id = staffDetail.getSd_id();
        staffDetailService.updateStaffDetail(staffDetail);
        StaffDetail staffDetail1 = staffDetailService.foundDetailBySD_ID(sd_id);
        session.setAttribute("mystaffdetail",staffDetail1);
        return "staffupdatedetail";
    }

    @RequestMapping("tostaffinformation")
    public String tostaffinformation(){
        return "staffinformation";
    }

    @RequestMapping("myTrain")
    public String myTrain(Integer sd_id,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        List<StaffId> staffIds = staffIdService.queryStaffIdBy(sd_id);
        if(staffIds.isEmpty()){
            out.flush();
            out.println("<script>");
            out.println("alert('暂时没有培训通知！');");
            out.println("</script>");
            return "staffinformation";
        }else {
            session.setAttribute("staffids",staffIds);
            return "staffMyTrain";
        }
    }

    @RequestMapping("checkWorkRecord")
    public String checkWorkRecord(Integer sd_id, Integer month, HttpServletRequest request,HttpServletResponse response, HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        if(month<0){
            out.flush();
            out.println("<script>");
            out.println("alert('别负数！');");
            out.println("</script>");
            return "staffinformation";
        }if(month>12){
            out.flush();
            out.println("<script>");
            out.println("alert('请正常月份！');");
            out.println("</script>");
            return "staffinformation";
        }
        List<CheckWork> checkWorks = checkWorkService.foundTodayCheckWorkBySD_ID(sd_id);
        List<CheckWork> ck = new ArrayList<CheckWork>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (CheckWork CK:checkWorks){
            Date date = formatter.parse(CK.getCw_date());
            int month1 = date.getMonth()+1;
            if(month1==month){
                ck.add(CK);
            }
        }
        if(ck.isEmpty()){
            out.flush();
            out.println("<script>");
            out.println("alert('该月暂无打卡记录！');");
            out.println("</script>");
            return "staffinformation";
        }
        System.err.println(ck.size());
        request.setAttribute("CK",ck);
        String number = month+"月";
        request.setAttribute("Number",number);
        return "staffMyCK";
    }

    @RequestMapping("changeRecord")
    public String changeRecord(Integer sd_id,HttpServletRequest request,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        StaffDetail staffDetail = staffDetailService.foundDetailBySD_ID(sd_id);
        request.setAttribute("name", staffDetail.getSd_tname());
        Change change = new Change();
        change.setC_sid(sd_id);
        List<Change> changes = changeService.queryAllChangeBy_sid(change);
        if(changes.isEmpty()){
            out.flush();
            out.println("<script>");
            out.println("alert('该月暂无奖惩记录！');");
            out.println("</script>");
            return "staffinformation";
        }else {
            request.setAttribute("changs",changes);
            return "staffChange";
        }
    }

    @RequestMapping("Mysalary")
    public String Mysalary(Integer sd_id,HttpServletRequest request)throws Exception{
        List<Salary> salaries = salaryService.queryAllSalary(sd_id);
        ArrayList<Salary> salary = new ArrayList<Salary>();
        Date date1 = new Date();
        int month1 = date1.getMonth();
        for(Salary s:salaries){
            String sa_date = s.getSa_date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            Date date = formatter.parse(sa_date);
            int month = date.getMonth();
            if(month1!=month){
                salary.add(s);
            }
        }
        request.setAttribute("salaries",salary);
        return "staffmysalary";
    }

    @RequestMapping("hahahaGoodBy")
    public String hahahaGoodBy(String sd_why,Integer sdid,HttpSession session)throws Exception{
        StaffDetail staffDetail = new StaffDetail();
        staffDetail.setSd_id(sdid);
        staffDetail.setSd_why(sd_why);
        staffDetailService.sayGoodBy(staffDetail);
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sdid);
        session.setAttribute("mystaffdetail",getthisshtaff);
        return "staffinformation";
    }
}
