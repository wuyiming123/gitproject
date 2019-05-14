package com.iotek.controller;

import com.iotek.model.Tourist;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class isok {
    @Resource
    private TouristService touristService;

    @RequestMapping("login")
    public String login(String name,String pass)throws Exception{

        return "hello";
    }

    @RequestMapping("regiest")
    public String regiest(String name,String pass){

        System.out.println(name);
        System.out.println(pass);

        Tourist tourist = new Tourist();
        tourist.setT_name(name);
        tourist.setT_pass(pass);
        System.err.println(touristService.addTourist(tourist));
        System.err.println(touristService.getTouristByName(name));

        return "hello";
    }
}
