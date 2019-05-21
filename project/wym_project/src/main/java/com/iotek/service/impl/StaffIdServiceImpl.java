package com.iotek.service.impl;

import com.iotek.dao.StaffIdDao;
import com.iotek.model.StaffId;
import com.iotek.service.StaffIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StaffIdServiceImpl implements StaffIdService {
    @Resource
    private StaffIdDao staffIdDao;

    public StaffIdDao getStaffIdDao() {
        return staffIdDao;
    }

    public void setStaffIdDao(StaffIdDao staffIdDao) {
        this.staffIdDao = staffIdDao;
    }

    public List<StaffId> queryStaffIdBy_sid_taid(Integer sid_taid) {
        if(sid_taid!=null){
            return staffIdDao.queryStaffIdBy_sid_taid(sid_taid);
        }return null;
    }

    public boolean delBy_sid_id(Integer sid_id) {
        if(sid_id!=null){
            return staffIdDao.delBy_sid_id(sid_id);
        }return false;
    }

    public StaffId queryBy_sid_id(Integer sid_id) {
        if(sid_id!=null){
            return staffIdDao.queryBy_sid_id(sid_id);
        }return null;
    }

    public boolean addStaffId(StaffId staffId) {
        if(staffId!=null){
            return staffIdDao.addStaffId(staffId);
        }
        return false;
    }

    public StaffId queryStaffId(StaffId staffId) {
        if(staffId!=null){
            return staffIdDao.queryStaffId(staffId);
        }
        return null;
    }

    public boolean delStaffID(Integer sid_taid) {
        if(sid_taid!=null){
            return staffIdDao.delStaffID(sid_taid);
        }return false;
    }

    public List<StaffId> queryStaffIdBy(Integer sid_sdid) {
        if(sid_sdid!=null){
            return staffIdDao.queryStaffIdBy(sid_sdid);
        }return null;
    }
}
