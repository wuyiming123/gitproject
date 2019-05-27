package com.iotek.controller;

import com.iotek.model.Staff;
import com.iotek.model.StaffDetail;
import com.iotek.service.StaffDetailService;
import com.iotek.service.StaffService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

@Component
@EnableScheduling
public class Scheduleds {
    @Resource
    private StaffService staffService;
    @Resource
    private StaffDetailService staffDetailService;

    @Scheduled(cron = "0 0 1 * * *")
    public void aaa(){
        System.err.println(1);
        List<Staff> staff = staffService.queryAllStaff();
        for (Staff s:staff){
            Integer a= s.getS_overtime();
            if(a==1){
                Integer s_sdid = s.getS_sdid();
                StaffDetail sd = staffDetailService.getthisshtaff(s_sdid);
                sd.setSd_poid(0);
                sd.setSd_deid(0);
                sd.setSd_state(2);
                staffDetailService.Staffresignation(sd);
                s.getS_id();
                staffService.delStaff(s);

            }
        }
    }
}
