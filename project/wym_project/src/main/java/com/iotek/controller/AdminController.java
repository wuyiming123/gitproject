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


    @RequestMapping("returnadmindeliverydetail")
    public String admindeliverydetail()throws Exception{
        return "admindeliverydetail";
    }

    @RequestMapping("admin")
    public String admin(HttpSession session)throws Exception{
        List<Delivery> deliveries = deliveryService.queryAllDe();
        session.setAttribute("alldeli",deliveries);
        List<Delivery> deliveries1 = deliveryService.queryAllDeBystate2(1);
        session.setAttribute("state2deli",deliveries1);
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

}
