package com.iotek.controller;

import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import com.iotek.util.DoPage;
import com.iotek.util.GetTotalPage;
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
        List<Recruit> recruits = recruitService.AllrecruitByOn();
        List<Recruit> currentPage = DoPage.getCurrentPage(recruits, 1, 3);
        session.setAttribute("recruit",currentPage);
        int size = recruits.size();
        int tp = GetTotalPage.getTp(size);
        session.setAttribute("sizeindex",tp);
        return "../../index";
    }

    @RequestMapping("indexdopage")
    public String indexdopage(Integer size,HttpSession session)throws Exception{
        List<Recruit> recruits = recruitService.AllrecruitByOn();
        List<Recruit> currentPage = DoPage.getCurrentPage(recruits, size, 3);
        session.setAttribute("recruit",currentPage);
        return "../../index";
    }
    @RequestMapping("indexdopage1")
    public String indexdopage1(Integer size,HttpSession session)throws Exception{
        List<Recruit> recruits = recruitService.AllrecruitByOn();
        List<Recruit> currentPage = DoPage.getCurrentPage(recruits, size, 3);
        session.setAttribute("recruit",currentPage);
        return "hello";
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
