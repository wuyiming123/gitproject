package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import com.iotek.util.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminStaffController {
    @Resource
    private ChangeService changeService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private SalaryService salaryService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumService resumService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private StaffDetailService staffDetailService;
    @Resource
    private StaffService staffService;
    @Resource
    private TrainService trainService;
    @Resource
    private StaffIdService staffIdService;
    @Resource
    private CheckWorkService checkWorkService;

    public int getMaxDayByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year - 1);
        calendar.set(Calendar.MONTH, month-1);
        return calendar.getActualMaximum(Calendar.DATE);
    }


    @RequestMapping("Employment")
    public String Employment(Integer i_id, String isok, HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        if(isok.equals("no")){
            InterView aa =  interviewService.queryIntByi_id(i_id);
            Integer i_did = aa.getI_did();
            Delivery delivery = deliveryService.fountDeliByid(i_did);
            aa.setI_state(3);
            interviewService.updateState_666(aa);
            delivery.setD_state(3);
            deliveryService.updateDeli(delivery);
            List<Resume> resumes = resumService.queryAllResume();
            List<Recruit> allRecruit = recruitService.getAllRecruit();
            session.setAttribute("resumes",resumes);
            session.setAttribute("allRecruit",allRecruit);
            List<Delivery> deliveries = deliveryService.queryAllDe();
            session.setAttribute("alldeli",deliveries);
            List<InterView> interViews = interviewService.queryAllInter();
            session.setAttribute("interViews",interViews);
            out.flush();
            out.println("<script>");
            out.println("alert('拒绝了对方！');");
            out.println("</script>");
            return "allinterview";
        }else {
            InterView interView = interviewService.queryIntByi_id(i_id);
            Integer i_did = interView.getI_did();
            Delivery delivery = deliveryService.fountDeliByid(i_did);
            Integer d_rid = delivery.getD_rid();
            Integer d_riid = delivery.getD_riid();
            Integer d_tid = delivery.getD_tid();
            Staff sad = new Staff();
            sad.setS_state(d_tid);
            List<Staff> staff1 = staffService.queryAll(sad);
            if(staff1!=null){
                out.flush();
                out.println("<script>");
                out.println("alert('对方已经是员工了！');");
                out.println("</script>");
                return "allinterview";
            }
            Recruit recruit = recruitService.getRecruit(d_riid);//得到了招聘表信息
            Resume resumByID = resumService.getResumByID(d_rid);//得到了简历表信息
            StaffDetail staffDetail = new StaffDetail();

            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            staffDetail.setSd_time(formatter.format(currentTime));///员工入职时间

            List<Departement> departements = departmentService.queryAllDepartment();
            List<Position> positions = positionService.queryAllPosi();
            String ri_department = recruit.getRi_department();
            String ri_position = recruit.getRi_position();
            System.err.println(ri_department);
            System.err.println(ri_position);
            for (Departement d:departements){
                if(d.getDe_name().equals(ri_department)){
                    staffDetail.setSd_deid(d.getDe_id());////staffdetail的sd_deid
                }
            }
            for (Position p : positions){
                if(p.getPo_name().equals(ri_position)){
                    staffDetail.setSd_poid(p.getPo_deid());////staffdetail的sd_poid
                }
            }
            staffDetail.setSd_tsalary(recruit.getRi_salary());///得到了员工薪资
            staffDetail.setSd_tsex(resumByID.getR_sex());///sex
            String r_phone = resumByID.getR_phone();///phone
            String r_phone1 = String.valueOf(r_phone);
            staffDetail.setSd_tphone(r_phone1);
            staffDetail.setSd_taddress(resumByID.getR_address());///address
            staffDetail.setSd_tname(resumByID.getR_name());///name
            System.err.println(staffDetail);
            staffDetail.setSd_state(0);
            staffDetailService.addStaffDetail(staffDetail);
            StaffDetail staffDetail1 = staffDetailService.foundNewDetail(staffDetail);
            Integer sd_id = staffDetail1.getSd_id();///得到新的STAFFDETAIL的ID
            Integer a = staffDetail1.getSd_deid();
            Integer b = staffDetail1.getSd_poid();
            Integer c = delivery.getD_id();
            Integer d = resumByID.getR_id();
            Integer e = resumByID.getR_tid();
            Departement departement = departmentService.queryThisDepart(a);
            Position position = positionService.queryPositionBypoid(b);
            departement.setDe_stcount(departement.getDe_stcount()+1);
            position.setPo_stcount(position.getPo_stcount()+1);
            departmentService.updateDepartmentCOUNT(departement);
            positionService.updatePositionCOUNT(position);
            String num1 = String.valueOf(a);
            String num2 = String.valueOf(b);
            String num3 = String.valueOf(c);
            String num4 = String.valueOf(d);
            String num5 = String.valueOf(e);
            String s_sid=num1+num2+num3+num4+num5;
            String s_spass=num1+num2+num3+num4+num5;
            Staff staff = new Staff();
            staff.setS_sdid(sd_id);
            staff.setS_sid(s_sid);
            staff.setS_spass(s_spass);
            staff.setS_state(d_tid);


            staffService.addStaff(staff);
            InterView aa =  interviewService.queryIntByi_id(i_id);
            Integer i_did3 = aa.getI_did();
            Delivery delivery3 = deliveryService.fountDeliByid(i_did3);
            aa.setI_state(111);
            interviewService.updateState_666(aa);
            delivery3.setD_state(111);
            deliveryService.updateDeli(delivery3);
            List<Resume> resumes = resumService.queryAllResume();
            List<Recruit> allRecruit = recruitService.getAllRecruit();
            session.setAttribute("resumes",resumes);
            session.setAttribute("allRecruit",allRecruit);
            List<Delivery> deliveries = deliveryService.queryAllDe();
            session.setAttribute("alldeli",deliveries);
            List<InterView> interViews = interviewService.queryAllInter();
            session.setAttribute("interViews",interViews);
            out.flush();
            out.println("<script>");
            out.println("alert('面试通过，分配的账号为"+s_sid+",分配的账号密码是"+s_spass+"');");
            out.println("</script>");
            return "allinterview";
        }
    }

    @RequestMapping("alltrain")
    public String alltrain(HttpSession session)throws Exception{
        List<Train> trains = trainService.queryAllTrain();
        List<Train> currentPage = DoPage.getCurrentPage(trains, 1, 1);
        session.setAttribute("trains",currentPage);
        int size = trains.size();
        session.setAttribute("size",size);
        return "adminalltrain";
    }

    @RequestMapping("currentpage")
    public String currentpage(Integer size,HttpSession session)throws Exception{
        List<Train> trains = trainService.queryAllTrain();
        List<Train> currentPage = DoPage.getCurrentPage(trains, size, 1);
        session.setAttribute("trains",currentPage);
        int size1 = trains.size();
        session.setAttribute("size",size1);
        return "adminalltrain";
    }

    @RequestMapping("toadminalltrain")
    public String toadminalltrain()throws Exception{
        return "adminalltrain";
    }

    @RequestMapping("addtrainstaff")
    public String addtrainstaff(HttpSession session,Integer tr_id)throws Exception{
        List<Departement> departements = departmentService.queryAllDepartment();
        List<Position> positions = positionService.queryAllPosi();
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        Train train = trainService.queryThisTrain(tr_id);
        session.setAttribute("departments",departements);
        session.setAttribute("positions",positions);
        session.setAttribute("staffDetails",staffDetails);
        session.setAttribute("train",train);
        List<StaffId> staffIds = staffIdService.queryStaffIdBy_sid_taid(tr_id);
        session.setAttribute("staffIds",staffIds);
        return "admintrainstaff";
    }

    @RequestMapping("addStaffToTrain")
    public String addStaffToTrain(Integer sd_id,Integer tr_id,HttpSession session,HttpServletResponse response)throws Exception{
        StaffId staffId = new StaffId();
        staffId.setSid_taid(tr_id);
        staffId.setSid_sdid(sd_id);
        StaffId staffId1 = staffIdService.queryStaffId(staffId);
        if(staffId1==null){
            boolean b = staffIdService.addStaffId(staffId);
            if(b!=false){
                List<StaffId> staffIds = staffIdService.queryStaffIdBy_sid_taid(tr_id);
                session.setAttribute("staffIds",staffIds);
                return "admintrainstaff";
            }
        }else {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('不要添加重复人员');");
            out.println("</script>");
            return "admintrainstaff";
        }
        return "admintrainstaff";
    }

    @RequestMapping("delStaffToTrain")
    public String delStaffToTrain(Integer sid_id,HttpSession session)throws Exception{
        StaffId staffId = staffIdService.queryBy_sid_id(sid_id);
        Integer sid_taid = staffId.getSid_taid();
        if(staffIdService.delBy_sid_id(sid_id)){
            List<StaffId> staffIds = staffIdService.queryStaffIdBy_sid_taid(sid_taid);
            session.setAttribute("staffIds",staffIds);
            return "admintrainstaff";
        }
        return "admintrainstaff";
    }

    @RequestMapping("changeState")
    public String changeState(Integer tr_state,HttpSession session,Integer tr_id)throws Exception{
        Train train = new Train();
        train.setTr_state(tr_state);
        train.setTr_id(tr_id);
        boolean b = trainService.updateState(train);
        if(b!=false){
            List<Train> trains = trainService.queryAllTrain();
            List<Train> currentPage = DoPage.getCurrentPage(trains, 1, 1);
            session.setAttribute("trains",currentPage);
            int size = trains.size();
            session.setAttribute("size",size);
            return "adminalltrain";
        }
        return "adminalltrain";
    }

    @RequestMapping("updatetrain")
    public String updatetrain(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        String id = request.getParameter("sid");
        Integer tr_id = Integer.parseInt(id);
        String tr_title = request.getParameter("title");
        String tr_message = request.getParameter("message");
        String tr_time = request.getParameter("datetime");
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(tr_time);
        Date date1 = new Date();
        int ms = (int) ((date1.getTime()-date.getTime())/1000/24/60/60);
        if(ms>0){
            out.flush();
            out.println("<script>");
            out.println("alert('求求你！别秀了！');");
            out.println("</script>");
            return "adminalltrain";
        }

        Train train = new Train();
        train.setTr_id(tr_id);
        train.setTr_time(tr_time);
        train.setTr_message(tr_message);
        train.setTr_title(tr_title);
        System.err.println("asdasd"+train);
        trainService.updateTrain(train);
        List<Train> trains = trainService.queryAllTrain();
        session.setAttribute("trains",trains);
        return "adminalltrain";
    }

    @RequestMapping("delTrain")
    public String delTrain(Integer tr_id,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Train train = trainService.queryThisTrain(tr_id);
        String tr_time = train.getTr_time();
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(tr_time);
        Date date1 = new Date();
        Long ms = (Long) ((date1.getTime()-date.getTime())/1000/24/60);
        System.err.println("培训结束还有"+ms);
        if(ms>0){
            trainService.delTrain(tr_id);
            staffIdService.delStaffID(tr_id);
            out.flush();
            out.println("<script>");
            out.println("alert('培训结束,培训记录删除！');");
            out.println("</script>");
            return "admin";
        }else if(0>=ms){
            out.flush();
            out.println("<script>");
            out.println("alert('培训还没到时间，不能删除！');");
            out.println("</script>");
            return "adminalltrain";
        }
        return "adminalltrain";
    }

    @RequestMapping("NOWdelTrain")
    public String NOWdelTrain(Integer tr_id,HttpServletResponse response,HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        trainService.delTrain(tr_id);
        staffIdService.delStaffID(tr_id);
        List<Train> trains = trainService.queryAllTrain();
        session.setAttribute("trains",trains);
        out.flush();
        out.println("<script>");
        out.println("alert('培训记录删除！');");
        out.println("</script>");
        return "adminalltrain";
    }

    @RequestMapping("newtrain")
    public String newtrain(Train train,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        String tr_time = train.getTr_time();
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(tr_time);
        Date date1 = new Date();
        int ms = (int) ((date1.getTime()-date.getTime())/1000/24/60/60);
        if(ms>0){
            out.flush();
            out.println("<script>");
            out.println("alert('别预约过去的时间！');");
            out.println("</script>");
            return "adminalltrain";
        }

        boolean b = trainService.addTrain(train);
        List<Train> trains = trainService.queryAllTrain();
        List<Train> currentPage = DoPage.getCurrentPage(trains, 1, 1);
        session.setAttribute("trains",currentPage);
        int size = trains.size();
        session.setAttribute("size",size);
        return "adminalltrain";
    }

    @RequestMapping("toRelieveGuard")
    public String toRelieveGuard(HttpSession session)throws Exception{
        session.setAttribute("alldepartment",departmentService.queryAllDepartment());
        session.setAttribute("allposition",positionService.queryAllPosi());
        session.setAttribute("allstaffdetail",staffDetailService.queryAllStaffDetail());
        return "admintoRelieveGuard";
    }

    @RequestMapping("querystaffbypoid")
    @ResponseBody
    public List<StaffDetail> querystaffbypoid(Integer po_id)throws Exception{
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetailBypo_id(po_id);
        System.err.println("staffdetails===>"+staffDetails);
        return staffDetails;
    }

    @RequestMapping("update_de_po")
    public String update_de_po(HttpServletResponse response,HttpServletRequest request)throws Exception{
        PrintWriter out = response.getWriter();
        String staffName = request.getParameter("staffName");
        String newDePart = request.getParameter("newDePart");
        String newPoSi = request.getParameter("newPoSi");
        System.err.println("test==="+staffName);
        System.err.println("test==="+newDePart);
        System.err.println("test==="+newPoSi);
        if(staffName.equals("-----") || newDePart.equals("-----") || newPoSi.equals("-----")){
            out.flush();
            out.println("<script>");
            out.println("alert('空值输入！');");
            out.println("</script>");
            return "admintoRelieveGuard";
        }
        Integer sd_id = Integer.parseInt(staffName);
        Integer sd_deid = Integer.parseInt(newDePart);
        Integer sd_poid = Integer.parseInt(newPoSi);
        StaffDetail staffDetail1 = staffDetailService.foundDetailBySD_ID(sd_id);

        if(staffDetail1.getSd_poid()==sd_poid && staffDetail1.getSd_deid()==sd_deid){
            out.flush();
            out.println("<script>");
            out.println("alert('请别同岗位调换！');");
            out.println("</script>");
            return "admintoRelieveGuard";
        }
        String oldDePart = request.getParameter("oldDePart");
        String oldPoSi = request.getParameter("oldPoSi");
        Integer deid = Integer.parseInt(oldDePart);
        Integer poid = Integer.parseInt(oldPoSi);
        Departement departement1 = departmentService.queryThisDepart(deid);
        departement1.setDe_stcount(departement1.getDe_stcount()-1);
        departmentService.updateDepartmentCOUNT(departement1);
        Position position1 = positionService.queryPositionBypoid(poid);
        position1.setPo_stcount(position1.getPo_stcount()-1);
        positionService.updatePositionCOUNT(position1);
        StaffDetail staffDetail = new StaffDetail();
        staffDetail.setSd_id(sd_id);
        staffDetail.setSd_deid(sd_deid);
        staffDetail.setSd_poid(sd_poid);
        staffDetailService.updateDE_PO(staffDetail);
        Position position = positionService.queryPositionBypoid(sd_poid);
        Departement departement = departmentService.queryThisDepart(sd_deid);
        position.setPo_stcount(position.getPo_stcount()+1);
        departement.setDe_stcount(departement.getDe_stcount()+1);
        positionService.updatePositionCOUNT(position);
        departmentService.updateDepartmentCOUNT(departement);
        out.flush();
        out.println("<script>");
        out.println("alert('换岗完成！');");
        out.println("</script>");
        return "admintoRelieveGuard";
    }

    @RequestMapping("allStaff")
    public String allStaff(HttpSession session)throws Exception{
        List<Position> positions = positionService.queryAllPosi();
        List<Departement> departements = departmentService.queryAllDepartment();
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        session.setAttribute("positions",positions);
        session.setAttribute("departements",departements);
        session.setAttribute("staffDetails",staffDetails);
        return "adminAllStaffDetail";
    }

    @RequestMapping("become_Wegular_Worker")
    public String become_Wegular_Worker(Integer sd_id,HttpSession session)throws Exception{
        StaffDetail staffDetail = new StaffDetail();
        staffDetail.setSd_id(sd_id);
        staffDetail.setSd_state(1);
        staffDetailService.updateState(staffDetail);
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        session.setAttribute("staffDetails",staffDetails);
        return "adminAllStaffDetail";
    }

    @RequestMapping("querySalaryBy_sd_id")
    @ResponseBody
    public List<Salary> querySalaryBy_sd_id(Integer sd_id,HttpSession session)throws Exception{
        List<Salary> salaries = salaryService.queryAllSalary(sd_id);
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH)+1;//月
        int month1=cal.get(Calendar.MONTH);//月
        int year=cal.get(Calendar.YEAR);//年
        int day=cal.get(Calendar.DATE);//日
        String y = String.valueOf(year);
        String mon = String.valueOf(month);
        String mon1 = String.valueOf(month1);
        String d = String.valueOf(day);
        String ymd = y+"-"+mon;
        String ymd1 = y+"-"+mon1;
        List<Salary> queryall = salaryService.queryall(sd_id, "已发", month1);
        if(!queryall.isEmpty()){
            return queryall;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        if(salaries.isEmpty()){
            Salary salary = new Salary();
            salary.setSa_sdid(sd_id);
            salary.setSa_date(ymd1);
            salaryService.addShangYiGeMonth(salary);}
//        }else if(!salaries.isEmpty()){
//            boolean flag = true;
//            for (Salary salary:salaries){
//                String sa_date = salary.getSa_date();
//                Date date = formatter.parse(sa_date);
//                int recordMonth = date.getMonth()+1;
//                if(recordMonth==month){
//                    flag=false;
//                    break;
//                }else if(recordMonth!=month){
//                    flag=true;
//                }
//            }
//            if(flag==true){
//                Salary salary = new Salary();
//                salary.setSa_sdid(sd_id);
//                salary.setSa_date(ymd);
//                salaryService.addShangYiGeMonth(salary);
//            }
//        }
        ///////////////////////////////////////以上是自动生成工资单模板的代码//////////////////////////////////
        int maxDayByYearMonth = getMaxDayByYearMonth(year,month1);
        int count = 0;
        List<CheckWork> checkWorks = checkWorkService.queryMonth(sd_id,month1);
        int gongping=0;
        if(checkWorks.size()<10){
            System.err.println(101010);
            for (CheckWork ca:checkWorks){
                Integer cws = ca.getCw_state();
                if(cws==0){
                    gongping++;
                }
                if(cws==666){
                    gongping++;
                }
            }
            if(gongping<5){
                Salary salarynew = new Salary();
                salarynew.setSa_base(0);
                salarynew.setSa_change(0);
                salarynew.setSa_overtime(0);
                double sccial = 0;
                salarynew.setSa_social(sccial);
                double money = 0;
                salarynew.setSa_money(money);
                salarynew.setSa_state("上个月上班不足五天，不予发放工资");
                salarynew.setSa_sdid(sd_id);
                salarynew.setSa_date(ymd1);
                salaryService.updateShangYiGeMonth(salarynew);
                List<Salary> salaries333 = salaryService.queryAllSalaryBystate(sd_id,"上个月上班不足五天，不予发放工资");
                return salaries333;
            }
        }
        System.err.println(checkWorks);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tdate = null;
        String cw_date=null;
        int a= 1;
        int con = 0;
        double changeM= 0;
        double overM= 0;
        for (int i = 1; i <= maxDayByYearMonth ; i++) {
            for(CheckWork checkWork:checkWorks){
                if(i>22){
                    con=999;
                    break;
                }
                System.err.println("进来最大一个循环了");
                cw_date = checkWork.getCw_date();
                tdate=sdf.parse(cw_date);
                Integer cw_state = checkWork.getCw_state();
                if(cw_state==1){
                    Integer cw_smalltime1 = checkWork.getCw_smalltime();
                    overM = overM+(cw_smalltime1*0.5);
                }
                if(tdate.getDate()==i){
                    con++;
                }
            }
            if(con==0){
                Change change = new Change();
                change.setC_state(-1);
                change.setC_why("管理员记录："+month1+"月"+i+"日"+"当天没打卡记录！");
                change.setC_money(-300);
                change.setC_sid(sd_id);
                change.setC_time("2019-"+month1+"-"+i);
                Change change1 = changeService.queryTime_Change(change);
                System.err.println(change1+"==="+a);
                a++;
                if(change1==null){
                    changeM = changeM+(-300);
                    changeService.addNewChange(change);
                }if(change1!=null){
                    changeM = changeM+change1.getC_money();
                }
            }
            if(con==1){
                Change change = new Change();
                change.setC_state(-1);
                change.setC_why("管理员记录："+month1+"月"+i+"日"+"当天没打下班卡！");
                change.setC_money(-100);
                change.setC_sid(sd_id);
                change.setC_time("2019-"+month1+"-"+i);
                Change change1 = changeService.queryTime_Change(change);
                if(change1==null){
                    changeM = changeM+(-100);
                    changeService.addNewChange(change);
                }if(change1!=null){
                    changeM = changeM+change1.getC_money();
                }
            }
            con=0;

        }
        if(changeM==0){
            changeM=1000;
        }
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        Integer BASE = getthisshtaff.getSd_tsalary();
        Salary salarynew = new Salary();
        salarynew.setSa_base(BASE);
        salarynew.setSa_change(changeM);
        salarynew.setSa_overtime(overM);
        double sccial = (BASE+changeM+overM)*0.1;
        salarynew.setSa_social(sccial);
        double money = (BASE+changeM+overM)-sccial;
        salarynew.setSa_money(money);
        salarynew.setSa_state("待发");
        salarynew.setSa_sdid(sd_id);
        salarynew.setSa_date(ymd1);
        salaryService.updateShangYiGeMonth(salarynew);
        List<Salary> salaries1 = salaryService.queryAllSalaryBystate(sd_id,"待发");
        return salaries1;
    }


    @RequestMapping("toadminallstaffdetail")
    public String toadminallstaffdetail()throws Exception{
        return "adminAllStaffDetail";
    }


    @RequestMapping("thisManSalary")
    public String thisManSalary(Integer sd_id,HttpSession session)throws Exception{
        List<Salary> salaries = salaryService.queryAllSalary(sd_id);
        session.setAttribute("salarys",salaries);
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        session.setAttribute("staffDetails",staffDetails);
        List<Departement> departements = departmentService.queryAllDepartment();
        List<Position> positions = positionService.queryAllPosi();
        session.setAttribute("departements",departements);
        session.setAttribute("positions",positions);
        return "allSalarys";
    }


    @RequestMapping("opt")
    public String opt(Integer id,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Salary salary1 = salaryService.queryById(id);
        if(salary1.getSa_state().equals("已发")){
            out.flush();
            out.println("<script>");
            out.println("alert('请勿重复操作！');");
            out.println("</script>");
            return "adminAllStaffDetail";
        }
        System.err.println("id:"+id);
        Salary salary = new Salary();
        salary.setSa_id(id);
        salary.setSa_state("已发");
        boolean updatestate = salaryService.updatestate(salary);
        System.err.println("update:"+updatestate);
        out.flush();
        out.println("<script>");
        out.println("alert('工资已发送！');");
        out.println("</script>");
        return "adminAllStaffDetail";
    }


    @RequestMapping("queryThisSalaryBy_sd_id")
    @ResponseBody
    public List<Salary> queryThisSalaryBy_sd_id(Integer sd_id,HttpSession session)throws Exception{
        List<Salary> salaries = salaryService.queryAllSalary(sd_id);
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH)+1;//月
        int month1=cal.get(Calendar.MONTH);//月
        int year=cal.get(Calendar.YEAR);//年
        int day=cal.get(Calendar.DATE);//日
        String y = String.valueOf(year);
        String mon = String.valueOf(month);
        String ymd = y+"-"+mon;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        if(!salaries.isEmpty()){
            boolean flag = true;
            for (Salary salary:salaries){
                String sa_date = salary.getSa_date();
                Date date = formatter.parse(sa_date);
                int recordMonth = date.getMonth()+1;
                if(recordMonth==month){
                    flag=false;
                    break;
                }else if(recordMonth!=month){
                    flag=true;
                }
            }
            if(flag==true){
                Salary salary = new Salary();
                salary.setSa_sdid(sd_id);
                salary.setSa_date(ymd);
                salaryService.addShangYiGeMonth(salary);
            }
        }
        Date aa = new Date();
        int today = aa.getDate();
        List<CheckWork> checkWorks = checkWorkService.queryMonth(sd_id,month);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tdate = null;
        String cw_date=null;
        int a= 1;
        int con = 0;
        double changeM= 0;
        double overM= 0;
        for (int i = 1; i < today ; i++) {
            for(CheckWork checkWork:checkWorks){
                if(i>22){
                    con=999;
                    break;
                }
                System.err.println("进来最大一个循环了");
                cw_date = checkWork.getCw_date();
                tdate=sdf.parse(cw_date);
                Integer cw_state = checkWork.getCw_state();
                if(cw_state==1){
                    Integer cw_smalltime1 = checkWork.getCw_smalltime();
                    overM = overM+(cw_smalltime1*0.5);
                }
                if(tdate.getDate()==i){
                    con++;
                }
            }
            if(con==0){
                Change change = new Change();
                change.setC_state(-1);
                change.setC_why("管理员记录："+month1+"月"+i+"日"+"当天没打卡记录！");
                change.setC_money(-300);
                change.setC_sid(sd_id);
                change.setC_time("2019-"+month+"-"+i);
                Change change1 = changeService.queryTime_Change(change);
                System.err.println(change1+"==="+a);
                a++;
                if(change1==null){
                    changeM = changeM+(-300);
                    changeService.addNewChange(change);
                }if(change1!=null){
                    changeM = changeM+change1.getC_money();
                }
            }
            if(con==1){
                Change change = new Change();
                change.setC_state(-1);
                change.setC_why("管理员记录："+month1+"月"+i+"日"+"当天没打下班卡！");
                change.setC_money(-100);
                change.setC_sid(sd_id);
                change.setC_time("2019-"+month+"-"+i);
                Change change1 = changeService.queryTime_Change(change);
                if(change1==null){
                    changeM = changeM+(-100);
                    changeService.addNewChange(change);
                }if(change1!=null){
                    changeM = changeM+change1.getC_money();
                }
            }
            con=0;
        }
        if(changeM==0){
            changeM=1000;
        }
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        Integer BASE = getthisshtaff.getSd_tsalary();
        Salary salarynew = new Salary();
        salarynew.setSa_base(BASE);
        salarynew.setSa_change(changeM);
        salarynew.setSa_overtime(overM);
        double sccial = (BASE+changeM+overM)*0.1;
        salarynew.setSa_social(sccial);
        double money = (BASE+changeM+overM)-sccial;
        salarynew.setSa_money(money);
        salarynew.setSa_state("已核算");
        salarynew.setSa_sdid(sd_id);
        salarynew.setSa_date(ymd);
        salaryService.updateShangYiGeMonth(salarynew);
        List<Salary> salaries12 = salaryService.queryAllSalaryBystate(sd_id,"已核算");
        return salaries12;
    }

    @RequestMapping("foundRecord")
    public String jiangcheng(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws Exception{
        String onth = request.getParameter("month");
        String staffName = request.getParameter("staffName");
        PrintWriter out = response.getWriter();
        if(onth=="" || staffName==""){
            out.flush();
            out.println("<script>");
            out.println("alert('请选择月份');");
            out.println("</script>");
            return "adminAllStaffDetail";
        }
        Integer month = Integer.parseInt(onth);
        if(month>12 || month<=0){
            out.flush();
            out.println("<script>");
            out.println("alert('请输入正确月份');");
            out.println("</script>");
            return "adminAllStaffDetail";
        }
        Integer sd_id = Integer.parseInt(staffName);
        List<CheckWork> checkWorks = checkWorkService.queryMonth(sd_id, month);
        request.setAttribute("MONTH",month);
        request.setAttribute("checkWorks",checkWorks);
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        String sd_tname = getthisshtaff.getSd_tname();
        request.setAttribute("staffname",sd_tname);
        request.setAttribute("ooo","打卡记录");
        request.setAttribute("sdid",sd_id);
        List<Change> changes = changeService.queryByMonth(sd_id, month);
        request.setAttribute("changs",changes);
        request.setAttribute("sss","奖惩记录");
        return "adminStaffcheck";
    }

    @RequestMapping("delThisChange")
    public String delThisChange(Integer c_id,Integer c_sid,Integer month,HttpServletRequest request)throws Exception{
        changeService.delchangeBy_id(c_id);
        Integer sd_id = c_sid;
        System.err.println(month);
        List<CheckWork> checkWorks = checkWorkService.queryMonth(sd_id, month);
        request.setAttribute("MONTH",month);
        request.setAttribute("checkWorks",checkWorks);
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        String sd_tname = getthisshtaff.getSd_tname();
        request.setAttribute("staffname",sd_tname);
        request.setAttribute("ooo","打卡记录");
        request.setAttribute("sdid",sd_id);
        List<Change> changes = changeService.queryByMonth(sd_id, month);
        request.setAttribute("changs",changes);
        request.setAttribute("sss","奖惩记录");
        return "adminStaffcheck";
    }

    @RequestMapping("updThisChange")
    public String updThisChange(Change change,HttpSession session,Integer month1,HttpServletRequest request)throws Exception{
        Integer sd_id = change.getC_sid();
        Integer c_money = change.getC_money();
        if(c_money<0){
            change.setC_state(-1);
        }else {
            change.setC_state(1);
        }
        changeService.updateChange(change);
        List<CheckWork> checkWorks = checkWorkService.queryMonth(sd_id, month1);
        request.setAttribute("MONTH",month1);
        request.setAttribute("checkWorks",checkWorks);
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        String sd_tname = getthisshtaff.getSd_tname();
        request.setAttribute("staffname",sd_tname);
        request.setAttribute("ooo","打卡记录");
        request.setAttribute("sdid",sd_id);
        List<Change> changes = changeService.queryByMonth(sd_id, month1);
        request.setAttribute("changs",changes);
        request.setAttribute("sss","奖惩记录");
        return "adminStaffcheck";
    }

    @RequestMapping("addNewChange")
    public String addNewChange(Change change,HttpSession session,Integer month,HttpServletRequest request,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        String day = request.getParameter("day");
        Integer dd = Integer.parseInt(day);
        Calendar cal = Calendar.getInstance();
        if(dd<=0 || dd>=32){
            out.flush();
            out.println("<script>");
            out.println("alert('日期不规范！');");
            out.println("</script>");
            return "adminStaffcheck";
        }
        int year1=cal.get(Calendar.YEAR);//年
        String month1 = String.valueOf(month);
        String year = String.valueOf(year1);
        String ymd = year+"-"+month1+"-"+day;
        change.setC_time(ymd);
        changeService.addNewChange(change);
        Integer sd_id = change.getC_sid();
        List<CheckWork> checkWorks = checkWorkService.queryMonth(sd_id, month);
        request.setAttribute("MONTH",month);
        request.setAttribute("checkWorks",checkWorks);
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        String sd_tname = getthisshtaff.getSd_tname();
        request.setAttribute("staffname",sd_tname);
        request.setAttribute("ooo","打卡记录");
        request.setAttribute("sdid",sd_id);
        List<Change> changes = changeService.queryByMonth(sd_id, month);
        request.setAttribute("changs",changes);
        request.setAttribute("sss","奖惩记录");
        return "adminStaffcheck";
    }

    @RequestMapping("query_AllSalary")
    @ResponseBody
    public List<Salary> query_AllSalary(Integer sd_id,HttpSession session)throws Exception{
        List<Salary> salaries = salaryService.queryAllSalary(sd_id);
        return salaries;
    }

    @RequestMapping("queryThisStaff_Why_To_SayGoodBy")
    @ResponseBody
    public StaffDetail queryThisStaff_Why_To_SayGoodBy(Integer sd_id)throws Exception{
        StaffDetail getthisshtaff = staffDetailService.getthisshtaff(sd_id);
        return getthisshtaff;
    }


    @RequestMapping("iagree")
    public String iagree(Integer sd_id, HttpServletResponse response,HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        Date date = new Date();
        int month = date.getMonth()+1;
        Salary salary = salaryService.querySalary_By_Month(sd_id, month);
        if(salary==null){
            out.flush();
            out.println("<script>");
            out.println("alert('请手动核算这月工资！');");
            out.println("</script>");
            return "adminAllStaffDetail";
        }
        StaffDetail staffDetail = staffDetailService.getthisshtaff(sd_id);
        Integer sd_deid = staffDetail.getSd_deid();
        Integer sd_poid = staffDetail.getSd_poid();
        Departement departement = departmentService.queryThisDepart(sd_deid);
        Position position = positionService.queryPositionBypoid(sd_poid);
        departement.setDe_stcount(departement.getDe_stcount()-1);
        position.setPo_stcount(position.getPo_stcount()-1);
        departmentService.updateDepartmentCOUNT(departement);
        positionService.updatePositionCOUNT(position);
        staffDetail.setSd_state(2);
        staffDetail.setSd_poid(staffDetail.getSd_deid());
        staffDetail.setSd_deid(staffDetail.getSd_poid());
        staffDetailService.Staffresignation(staffDetail);
        Staff staff = staffService.foundStaffByS_SDID(sd_id);
        System.err.println(staff);
        staff.setS_overtime(1);
        staffService.updateovertime(staff);
        salary.setSa_state("已发");
        salaryService.updatestate(salary);
        out.flush();
        out.println("<script>");
        out.println("alert('已同意员工离职，消息已通知，相关讯息已经自动删除，账号将于今晚的00.00分删除，该月薪资已发放！！');");
        out.println("</script>");
        staffIdService.del_By_sid_sdid(sd_id);
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        List<Departement> departements = departmentService.queryAllDepartment();
        List<Position> positions = positionService.queryAllPosi();
        session.setAttribute("staffDetails",staffDetails);
        session.setAttribute("departements",departements);
        session.setAttribute("positions",positions);
        return "adminAllStaffDetail";
    }
}
