package com.iotek.controller;

import com.iotek.model.Resume;
import com.iotek.model.Tourist;
import com.iotek.service.ResumService;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    @RequestMapping("login")
    public String login(String name,String pass,HttpSession session,HttpServletResponse response)throws Exception{
        Tourist tourist = new Tourist();
        tourist.setT_name(name);
        tourist.setT_pass(pass);
        Tourist T = touristService.getTouristByNAMEAndPASS(tourist);
        if(T!=null){
            System.out.println(T);
            session.setAttribute("tourist",T);
            return "hello";
        }
        else {
            PrintWriter out = response.getWriter();
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
    public String myresume(Integer id,HttpSession session)throws Exception{
        List<Resume> resumes = resumService.allResumByTid(id);
        session.setAttribute("myresum",resumes);
        return "myresume";
    }

    @RequestMapping("addresume")
    public String addresumefirst(Resume resume,HttpSession session)throws Exception{
        System.out.println(resume);
        String r_birthday = resume.getR_birthday();

        return "hello";
    }
}
