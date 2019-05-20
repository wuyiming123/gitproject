package com.iotek.controller;

import com.iotek.model.CheckWork;
import com.iotek.model.Departement;
import com.iotek.model.Position;
import com.iotek.model.StaffDetail;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
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
        int hour=cal.get(Calendar.HOUR);//小时
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
        session.setAttribute("ready_to_work",0);
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
        int hour=cal.get(Calendar.HOUR);//小时
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
        int ms = (int) (bybydate.getTime()-date1.getTime())/1000/60;
        checkWork.setCw_smalltime(ms);
        checkWork.setCw_time(hms);
        int year=cal.get(Calendar.YEAR);//年
        int month=cal.get(Calendar.MONTH)+1;//月
        int day=cal.get(Calendar.DATE);//日
        System.err.println(year+"aa");
        System.err.println(Calendar.MONTH);
        System.err.println(day+"aa");

        String y = String.valueOf(year);
        String mon = String.valueOf(month);
        String d = String.valueOf(day);
        String ymd = y+"-"+mon+"-"+d;
        checkWork.setCw_date(ymd);
        System.err.println(ymd);
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
        int hour=cal.get(Calendar.HOUR);//小时
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
        session.setAttribute("WTF",666);
        checkWorkService.hellocheckwork(checkWork);
        return "staff";
    }
}
