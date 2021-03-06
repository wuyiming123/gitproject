package com.iotek.service.impl;

import com.iotek.dao.StaffDao;
import com.iotek.model.Staff;
import com.iotek.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public boolean addStaff(Staff staff) {
        if(staff!=null){
            staffDao.addStaff(staff);
        }return false;
    }

    public Staff foundStaffByS_SDID(Integer s_sdid) {
        if(s_sdid!=null){
            return staffDao.foundStaffByS_SDID(s_sdid);
        }return null;
    }

    public Staff Stafflogin(Staff staff) {
        if(staff!=null){
            return staffDao.Stafflogin(staff);
        }return null;
    }

    public List<Staff> queryAll(Staff staff) {
        if(staff!=null){
            return staffDao.queryAll(staff);
        }return null;
    }

    public boolean delStaff(Staff staff) {
        if(staff!=null){
            return staffDao.delStaff(staff);
        }return false;
    }

    public boolean updateovertime(Staff staff) {
        if(staff!=null){
            return staffDao.updateovertime(staff);
        }return false;
    }

    public List<Staff> queryAllStaff() {
        return staffDao.queryAllStaff();
    }
}
