package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class TouristController {
    @Resource
    private TouristService touristService;
    @Resource
    private ResumService resumService;
    @Resource
    private AdminService adminService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private InterviewService interviewService;

    @RequestMapping("toindex")
    public String toindex(){
        return "../../index";
    }

    @RequestMapping("tohello")
    public String tohello(){
        return "hello";
    }

    @RequestMapping("login")
    public String login(String name, String pass, HttpSession session, HttpServletResponse response, HttpServletRequest request)throws Exception{
//        System.err.println("admin?:"+request.getParameter("admin"));
        PrintWriter out = response.getWriter();
//        if(request.getParameter("admin").equals("on")){
//            Admin admin = new Admin();
//            admin.setA_name(name);
//            admin.setA_pass(pass);
//            Admin adminlog = adminService.adminlog(admin);
//            if(adminlog!=null){
//                return "admin";
//            }else {
//                out.flush();
//                out.println("<script>");
//                out.println("alert('管理员账号密码有误，请重新确认');");
//                out.println("history.back();");
//                out.println("</script>");
//                return "../../index";
//            }
//        }else{

            Tourist tourist = new Tourist();
            tourist.setT_name(name);
            tourist.setT_pass(pass);
            Tourist T = touristService.getTouristByNAMEAndPASS(tourist);
            if(T!=null){
                Integer t_id = T.getT_id();
                List<Delivery> deliveries = deliveryService.queryDeBytid(t_id);
                session.setAttribute("deliveries",deliveries);
                List<Delivery> deliveries1 = deliveryService.queryDeBytid_state(t_id, 2);
                session.setAttribute("deliveries1",deliveries1);
                System.out.println(T);
                session.setAttribute("tourist",T);
                return "hello";
            }
            else {
                out.flush();
                out.println("<script>");
                out.println("alert('账号或者密码错误');");
                out.println("history.back();");
                out.println("</script>");
                return "../../index";
            }

    }

    @RequestMapping("regiest")
    public String regiest(String name, String pass, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Tourist tourist = new Tourist();
        tourist.setT_name(name);
        tourist.setT_pass(pass);
        if(touristService.getTouristByName(name)!=null){
            out.flush();
            out.println("<script>");
            out.println("alert('该账号已有人注册');");
            out.println("history.back();");
            out.println("</script>");
            return "../../index";
        }if(touristService.getTouristByName(name)==null){
            touristService.addTourist(tourist);
            return "hello";
        }return "../../index";
    }

    @RequestMapping("myresume")
    public String myresume(Integer tid,HttpSession session)throws Exception{
        System.out.println(tid);
        List<Resume> resumes = resumService.allResumByTid(tid);
        session.setAttribute("myresum",resumes);
        System.out.println(resumes);
        return "myresume";
    }

    @RequestMapping("addresume")
    public String addresumefirst(Resume resume,HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        System.out.println(resume);
        String r_birthday = resume.getR_birthday();
        resume.setR_birthday(r_birthday);

        boolean b = resumService.addResume(resume);
        if(b!=false){
            out.flush();
            out.println("<script>");
            out.println("alert('简历创建成功');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
        else {
            out.flush();
            out.println("<script>");
            out.println("alert('简历创建失败');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
    }

    @RequestMapping("sumdetail")
    public String sumdetail(Integer rid,HttpSession session, HttpServletResponse response)throws Exception{
        Resume resumByID = resumService.getResumByID(rid);
        session.setAttribute("thisresume",resumByID);
        return "thisresume";
    }

    @RequestMapping("updateresume")
    public String updateresume(Resume resume,HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        boolean b = resumService.updateResume(resume);
        Integer r_id = resume.getR_id();
        if(b){
            Resume resumByID = resumService.getResumByID(r_id);
            session.setAttribute("thisresume",resumByID);
            out.flush();
            out.println("<script>");
            out.println("alert('简历修改成功');");
            out.println("history.back();");
            out.println("</script>");
            return "thisresume";
        }else {
            out.flush();
            out.println("<script>");
            out.println("alert('简历修改失败');");
            out.println("history.back();");
            out.println("</script>");
            return "thisresume";
        }
    }

    @RequestMapping("delthisresume")
    public String delthisresume(Integer rid,HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        if(rid!=null){
            boolean b = resumService.delThisResume(rid);
            if(b!=false){
                Resume resumByID = resumService.getResumByID(rid);
                Integer r_tid = resumByID.getR_tid();
                List<Resume> resumes = resumService.allResumByTid(r_tid);
                session.setAttribute("myresum",resumes);
                out.flush();
                out.println("<script>");
                out.println("alert('删除成功');");
                out.println("history.back();");
                out.println("</script>");
                return "myresume";
            }else {
                out.flush();
                out.println("<script>");
                out.println("alert('删除失败');");
                out.println("history.back();");
                out.println("</script>");
                return "myresume";
            }
        }else {
            out.flush();
            out.println("<script>");
            out.println("alert('错误编码：XD1810');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
    }

    @RequestMapping("delivery")
    public String delivery(HttpSession session,Integer ri_id,Integer t_id,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        List<Resume> resumes = resumService.allResumByTid(t_id);
        Recruit recruit = recruitService.getRecruit(ri_id);
        if(deliveryService.founddelivery(t_id,ri_id)!=null){
            out.flush();
            out.println("<script>");
            out.println("alert('莫要重复投递简历');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
        session.setAttribute("resums",resumes);
        session.setAttribute("thisrecruit",recruit);
        return "deliver";
    }

    @RequestMapping("myinterview")
    public String myinterview(HttpSession session)throws Exception{
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        List<Resume> resumes = resumService.queryAllResume();
        session.setAttribute("allrecruit",allRecruit);
        session.setAttribute("resumes",resumes);
        return "myinterview";
    }

    @RequestMapping("thisinterview")
    public String thisinterview(Integer id,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Delivery delivery = deliveryService.fountDeliByid(id);
        session.setAttribute("thisdeli",delivery);
        Integer d_rid = delivery.getD_rid();
        Integer d_riid = delivery.getD_riid();
        Integer d_id = delivery.getD_id();
        InterView interView = interviewService.queryIntByid(d_id);
        Recruit recruit = recruitService.getRecruit(d_riid);
        Resume resumByID = resumService.getResumByID(d_rid);
        session.setAttribute("thisrecruit",recruit);
        session.setAttribute("thisresume",resumByID);
        session.setAttribute("thisinterview",interView);
        if(interView.getI_state()==1){
            out.flush();
            out.println("<script>");
            out.println("alert('对方还没回复您的简历呢，请再耐心等一等吧！');");
            out.println("history.back();");
            out.println("</script>");
            return "myinterview";
        }

        return "thisinterview";
    }
}




































