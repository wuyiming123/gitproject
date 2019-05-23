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
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
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



    @RequestMapping("returnadmindeliverydetail")
    public String admindeliverydetail()throws Exception{
        return "admindeliverydetail";
    }

    @RequestMapping("review")
    public String review(HttpSession session)throws Exception{
        List<Departement> departements = departmentService.queryAllDepartment();
        session.setAttribute("alldepartment",departements);
        return "adminreview";
    }

    @RequestMapping("admin")
    public String admin(HttpSession session)throws Exception{
        List<Delivery> deliveries = deliveryService.queryAllDe();
        session.setAttribute("alldeli",deliveries);
        List<Delivery> deliveries1 = deliveryService.queryAllDeBystate2(1);
        session.setAttribute("state2deli",deliveries1);
        List<InterView> interViews = interviewService.queryAllInter();
        session.setAttribute("interViews",interViews);
//        List<InterView> interViews666 = interviewService.queryInter_state666();
//        session.setAttribute("interViews666",interViews666);
        return "admin";
    }
    @RequestMapping("lookdeli")
    public String lookdeli(HttpSession session)throws Exception{
        List<Tourist> a = touristService.queryAllT();
        List<Recruit> b = recruitService.getAllRecruit();
        List<Resume> c = resumService.queryAllResume();
        session.setAttribute("allt",a);
        session.setAttribute("allrecruit",b);
        session.setAttribute("allresume",c);

        return "adminalldelivery";
    }

    @RequestMapping("delidetail")
    public String delidetail(Integer d_riid,Integer d_rid,HttpSession session)throws Exception{
        Recruit recruit = recruitService.getRecruit(d_riid);
        Resume resumByID = resumService.getResumByID(d_rid);
        session.setAttribute("thisrecruit",recruit);
        session.setAttribute("thisresume",resumByID);
        return "admindeliverydetail";
    }

    @RequestMapping("refuse")
    public String refuse(Integer r_id, Integer ri_id, HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Delivery delivery = deliveryService.fountDeliByridAndriid(ri_id, r_id);
        Integer d_id = delivery.getD_id();
        InterView interView = new InterView();
        interView.setI_did(d_id);
        interView.setI_state(3);////3代表了拒绝
        if(interviewService.addInterviewstate1(interView)==true){
            delivery.setD_state(3);///3代表拒绝，1是看过没回复，2是发送面试邀请
            deliveryService.updateDeli(delivery);
            List<Delivery> deliveries = deliveryService.queryAllDe();
            session.setAttribute("alldeli",deliveries);
            List<Delivery> deliveries1 = deliveryService.queryAllDeBystate2(1);
            session.setAttribute("state2deli",deliveries1);
            out.flush();
            out.println("<script>");
            out.println("alert('已经拒绝了这份简历,通知消息会发送到对方账号上');");
            out.println("</script>");
            return "admin";
        }else {
            return "admin";
        }
    }

    @RequestMapping("invitation")
    public String invitation(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        String r_id = request.getParameter("r_id");
        Integer d_rid=Integer.parseInt(r_id);
        String ri_id = request.getParameter("ri_id");
        Integer d_riid = Integer.parseInt(ri_id);
        String i_address = request.getParameter("i_address");
        String i_phone = request.getParameter("i_phone");
        String i_time = request.getParameter("i_time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        Date date1 = sdf.parse(i_time);
        Date date2 = new Date();
        if((date1.getTime()-date2.getTime())<0){
            out.flush();
            out.println("<script>");
            out.println("alert('请输入未来时间！');");
            out.println("</script>");
            return "admindeliverydetail";
        }
        Delivery delivery = deliveryService.fountDeliByridAndriid(d_riid, d_rid);
        Integer d_id = delivery.getD_id();

        InterView interView = new InterView();
        interView.setI_address(i_address);
        interView.setI_phone(i_phone);
        interView.setI_time(i_time);
        interView.setI_state(2);//3代表拒绝，1是看过没回复，2是发送面试邀请
        interView.setI_did(d_id);
        boolean b = interviewService.addInterviewstate2(interView);
        if(b!=false){
            delivery.setD_state(2);///3代表拒绝，1是看过没回复，2是发送面试邀请
            deliveryService.updateDeli(delivery);
            List<Delivery> deliveries1 = deliveryService.queryAllDeBystate2(1);
            session.setAttribute("state2deli",deliveries1);
            out.flush();
            out.println("<script>");
            out.println("alert('成功发送面试邀请，对方将会受到一份面试邀请通知书');");
            out.println("</script>");
            return "admin";
        }else {
            return "admin";
        }
    }

    @RequestMapping("adddepart")
    public String adddepart(String de_name,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Departement departement = new Departement();
        departement.setDe_name(de_name);
        departement.setDe_stcount(0);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        departement.setDe_time(dateString);
        System.out.println(departement);
        boolean b = departmentService.addDepartment(departement);
        if(b!=false){
            List<Departement> departements = departmentService.queryAllDepartment();
            session.setAttribute("alldepartment",departements);
            out.flush();
            out.println("<script>");
            out.println("alert('部门创建成功');");
            out.println("</script>");
            return "adminreview";
        }else {
            return "adminreview";
        }
    }

    @RequestMapping("thisdepart")
    public String thisdepart(Integer id,HttpSession session)throws Exception{
        System.err.println(id);
        Departement departement = departmentService.queryThisDepart(id);
        session.setAttribute("thisdepartment",departement);
        System.err.println(departement);
        List<Position> positions = positionService.queryAllPositionBydeid(id);
        session.setAttribute("positions",positions);
        System.err.println(positions);
        return "thisdepartment";
    }

    @RequestMapping("addPosition")
    public String addPosition(Integer po_deid,String po_name,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Position position = new Position();
        position.setPo_deid(po_deid);
        position.setPo_name(po_name);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        position.setPo_time(dateString);
        System.err.println(position);
        boolean b = positionService.addPosition(position);
        if(b!=false){
            List<Position> positions = positionService.queryAllPositionBydeid(po_deid);
            session.setAttribute("positions",positions);
            out.flush();
            out.println("<script>");
            out.println("alert('职位创建成功');");
            out.println("</script>");
            return "thisdepartment";
        }else {
            return "thisdepartment";
        }
    }

    @RequestMapping("allrecruit")
    public String allrecruit(HttpSession session)throws Exception{
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        session.setAttribute("recruits",allRecruit);
        return "adminallrecruit";
    }

    @RequestMapping("ison")
    public String ison(Integer id,HttpSession session)throws Exception{
        recruitService.updateRecruiton(id);
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        session.setAttribute("recruits",allRecruit);
        return "adminallrecruit";
    }

    @RequestMapping("isoff")
    public String isoff(Integer id,HttpSession session)throws Exception{
        recruitService.updateRecruitoff(id);
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        session.setAttribute("recruits",allRecruit);
        return "adminallrecruit";
    }

    @RequestMapping("deldepart")
    public String deldepart(Integer id,HttpServletResponse response,HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        Departement departement = departmentService.queryThisDepart(id);
        if(departement.getDe_stcount()==0){
            departmentService.delDepartmentBydeid(id);
            List<Departement> departements = departmentService.queryAllDepartment();
            session.setAttribute("alldepartment",departements);
            positionService.delPosition(id);
            out.flush();
            out.println("<script>");
            out.println("alert('部门以及底下职位删除成功！');");
            out.println("</script>");
            return "adminreview";
        }else if(departement.getDe_stcount()!=0){
            out.flush();
            out.println("<script>");
            out.println("alert('还有员工正在工作！不能删除！');");
            out.println("</script>");
            return "adminreview";
        }
        return "adminreview";
    }

    @RequestMapping("delpositi")
    public String delpositi(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
        PrintWriter out = response.getWriter();
        String a = request.getParameter("po_id");
        Integer po_id=Integer.parseInt(a);
        Position position = positionService.queryPositionBypoid(po_id);
        Integer po_deid = position.getPo_deid();
        Integer po_stcount = position.getPo_stcount();
        if(po_stcount==0){
            positionService.delPositionBypoid(po_id);
            List<Position> positions = positionService.queryAllPositionBydeid(po_deid);
            session.setAttribute("positions",positions);
            out.flush();
            out.println("<script>");
            out.println("alert('职位删除成功！');");
            out.println("</script>");
            return "thisdepartment";
        }else if(po_stcount!=0){

            out.flush();
            out.println("<script>");
            out.println("alert('还有员工正在工作！不能删除！');");
            out.println("</script>");
            return "thisdepartment";
        }
        return "thisdepartment";
    }

    @RequestMapping("addnewrecruit")
    public String addnewrecruit(HttpSession session)throws Exception{
        List<Departement> departements = departmentService.queryAllDepartment();
        session.setAttribute("alldepartment",departements);
        return "adminnewrecruit";
    }

    @RequestMapping("querydepartmentbydeid")
    @ResponseBody
    public List<Position> querydepartmentdeid(Integer de_id)throws Exception{
        List<Position> positions = positionService.queryAllPositionBydeid(de_id);
        return positions;
    }

    @RequestMapping("addthisrecruit")
    public String addthisrecruit(HttpServletResponse response,HttpServletRequest request,HttpSession session,Recruit recruit)throws Exception{
        System.err.println(recruit);
        String selec1 = request.getParameter("select");
        Integer select1 = Integer.parseInt(selec1);
        String selec2 = request.getParameter("select2");
        Integer select2 = Integer.parseInt(selec2);

        Departement departement = departmentService.queryThisDepart(select1);
        Position position = positionService.queryPositionBypoid(select2);
        recruit.setRi_department(departement.getDe_name());
        recruit.setRi_position(position.getPo_name());
        recruit.setRi_ison("off");
        boolean b = recruitService.addRecruito(recruit);
        if(b!=false){
            List<Recruit> allRecruit = recruitService.getAllRecruit();
            session.setAttribute("recruits",allRecruit);
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('招聘草稿已经保存，但是任需要您去发布！');");
            out.println("</script>");
            return "adminallrecruit";
        }
        return "adminallrecruit";
    }

    @RequestMapping("update_this_recrits")
    public String update_this_recrits(Recruit recruit,HttpServletResponse response,HttpSession session)throws Exception{
        boolean b = recruitService.updateThisRecruit(recruit);
        if(b!=false){
            List<Recruit> allRecruit = recruitService.getAllRecruit();
            session.setAttribute("recruits",allRecruit);
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('招聘信息修改成功！');");
            out.println("</script>");
            return "adminallrecruit";
        }
        return "adminallrecruit";
    }

    @RequestMapping("delthisrecrits")
    public String delthisrecrits(Integer riid,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Recruit recruit = recruitService.getRecruit(riid);
        if(recruit.getRi_ison().equals("on")){
            out.flush();
            out.println("<script>");
            out.println("alert('发布中是无法删除的！');");
            out.println("</script>");
            return "adminallrecruit";
        }else {
            recruitService.become_NoBodySee(riid);
            List<Recruit> allRecruit = recruitService.getAllRecruit();
            session.setAttribute("recruits",allRecruit);
            return "adminallrecruit";
        }
    }

    @RequestMapping("lookInter")
    public String lookInter(HttpSession session)throws Exception{
        List<Resume> resumes = resumService.queryAllResume();
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        session.setAttribute("resumes",resumes);
        session.setAttribute("allRecruit",allRecruit);
        List<Delivery> deliveries = deliveryService.queryAllDe();
        session.setAttribute("alldeli",deliveries);
        List<InterView> interViews = interviewService.queryAllInter();
        session.setAttribute("interViews",interViews);
        return "allinterview";
    }
}
