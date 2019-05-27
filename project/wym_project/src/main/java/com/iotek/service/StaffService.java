package com.iotek.service;

import com.iotek.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {
    boolean addStaff(Staff staff);
    Staff foundStaffByS_SDID(Integer s_sdid);
    Staff Stafflogin(Staff staff);
    List<Staff> queryAll(Staff staff);
    boolean delStaff(Staff staff);
    boolean updateovertime(Staff staff);
    List<Staff> queryAllStaff();
}
