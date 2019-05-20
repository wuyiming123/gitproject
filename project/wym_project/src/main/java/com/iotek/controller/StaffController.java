package com.iotek.controller;

import com.iotek.model.Departement;
import com.iotek.model.Position;
import com.iotek.model.StaffDetail;
import com.iotek.service.DepartmentService;
import com.iotek.service.PositionService;
import com.iotek.service.StaffDetailService;
import com.iotek.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Resource
    private StaffDetailService staffDetailService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping("staffdetail")
    public String staffdetail(HttpSession session)throws Exception{
        List<Departement> departements = departmentService.queryAllDepartment();
        List<Position> positions = positionService.queryAllPosi();
        session.setAttribute("alldepartment",departements);
        session.setAttribute("allposition",positions);
        List<StaffDetail> staffDetails = staffDetailService.queryAllStaffDetail();
        session.setAttribute("allstaffdetail",staffDetails);
        return "staffdetail";
    }

    @RequestMapping("querystaffbysd_id")
    @ResponseBody
    public StaffDetail querystaffbysd_id(Integer sd_id)throws Exception{
        StaffDetail staffDetail = staffDetailService.foundDetailBySD_ID(sd_id);
        System.err.println(staffDetail);
        return staffDetail;
    }
}
