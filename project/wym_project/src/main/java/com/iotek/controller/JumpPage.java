package com.iotek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpPage {

    @RequestMapping("toadmindelivery")
    public String toadmindelivery()throws Exception{
        return "adminalldelivery";
    }

    @RequestMapping("toadminreview")
    public String toadminreview(){
        return "adminreview";
    }
}
