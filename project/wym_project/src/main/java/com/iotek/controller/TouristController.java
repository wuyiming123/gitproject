package com.iotek.controller;

import com.iotek.model.Tourist;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class TouristController {
    @Resource
    private TouristService touristService;

    @RequestMapping("login")
    public String login(String name,String pass,HttpSession session)throws Exception{
        Tourist tourist = new Tourist();
        tourist.setT_name(name);
        tourist.setT_pass(pass);
        Tourist T = touristService.getTouristByNAMEAndPASS(tourist);
        if(T!=null){
            session.setAttribute("tourist",T);
            return "hello";
        }
        else {
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
}
