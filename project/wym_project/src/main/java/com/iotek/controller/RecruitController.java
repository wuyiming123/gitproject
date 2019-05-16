package com.iotek.controller;

import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;

    @RequestMapping("/")
    public String first()throws Exception{
        return "forward:showRecruit";
    }

    @RequestMapping("showRecruit")
    public String showRecruit(HttpSession session)throws Exception{
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        session.setAttribute("recruit",allRecruit);
        return "../../index";
    }

    @RequestMapping("lookRecruit")
    public String lookRecruit(Integer ri_id,HttpSession session)throws Exception{
        Recruit recruit = recruitService.getRecruit(ri_id);
        if(recruit!=null){
            session.setAttribute("thisrecruit",recruit);
            return "thisrecruit";
        }else {
            return "../../index";
        }
    }

    @RequestMapping("lookRecruit1")
    public String lookRecruit1(Integer ri_id,HttpSession session)throws Exception{
        Recruit recruit = recruitService.getRecruit(ri_id);
        if(recruit!=null){
            session.setAttribute("thisrecruit",recruit);
            return "thisrecruit1";
        }else {
            return "hello";
        }
    }
}
