package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    @RequestMapping("admin")
    public String admin(HttpSession session)throws Exception{
        List<Delivery> deliveries = deliveryService.queryAllDe();
        session.setAttribute("alldeli",deliveries);
        List<Delivery> deliveries1 = deliveryService.queryAllDeBystate2(1);
        session.setAttribute("state2deli",deliveries1);
        System.err.println(deliveries);
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
        interView.setI_state(1);////1代表了拒绝
        if(interviewService.addInterviewstate1(interView)==true){
            delivery.setD_state(2);///2代表着已经看过并且拒绝的请求
            deliveryService.updateDeli(delivery);
            List<Delivery> deliveries = deliveryService.queryAllDe();
            session.setAttribute("alldeli",deliveries);
            List<Delivery> deliveries1 = deliveryService.queryAllDeBystate2(1);
            session.setAttribute("state2deli",deliveries1);
            out.flush();
            out.println("<script>");
            out.println("alert('已经拒绝了这份简历,通知消息会发送到对方账号上');");
            out.println("history.back();");
            out.println("</script>");
            return "admin";
        }else {
            return "admin";
        }
    }
}
