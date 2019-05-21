package com.iotek.service;

import com.iotek.model.Staff;

public interface StaffService {
    boolean addStaff(Staff staff);
    Staff foundStaffByS_SDID(Integer s_sdid);
    Staff Stafflogin(Staff staff);

}
