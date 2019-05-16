package com.iotek.controller;

import com.iotek.model.Delivery;
import com.iotek.service.DeliveryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class DeliveryController {
    @Resource
    private DeliveryService deliveryService;

    @RequestMapping("deliverynow")
    public String deliverynow(Delivery delivery, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        delivery.setD_state(1);///1代表的是未被查阅过的
        System.out.println(delivery);
        boolean b = deliveryService.addDelivery(delivery);
        if(b!=false){
            out.flush();
            out.println("<script>");
            out.println("alert('投递成功');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }else {
            out.flush();
            out.println("<script>");
            out.println("alert('投递失败');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
    }
}
