package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AdminStaffController {
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private TouristService touristService;
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
            Integer r_phone = resumByID.getR_phone();///phone
            String r_phone1 = String.valueOf(r_phone);
            staffDetail.setSd_tphone(r_phone1);
            staffDetail.setSd_taddress(resumByID.getR_address());///address
            staffDetail.setSd_tname(resumByID.getR_name());///name
            System.err.println(staffDetail);
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
        session.setAttribute("trains",trains);
        System.err.println(trains);
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
            out.println("alert('成功发送面试邀请，对方将会受到一份面试邀请通知书');");
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
            session.setAttribute("trains",trains);
            return "adminalltrain";
        }
        return "adminalltrain";
    }

    @RequestMapping("updatetrain")
    public String updatetrain(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
        String id = request.getParameter("sid");
        Integer tr_id = Integer.parseInt(id);
        String tr_title = request.getParameter("title");
        String tr_message = request.getParameter("message");
        String tr_time = request.getParameter("datetime");
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
}
