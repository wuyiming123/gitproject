package com.iotek.service.impl;

import com.iotek.dao.StaffDetailDao;
import com.iotek.model.StaffDetail;
import com.iotek.service.StaffDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffDetailServiceImpl implements StaffDetailService {
    @Resource
    private StaffDetailDao staffDetailDao;

    public StaffDetailDao getStaffDetailDao() {
        return staffDetailDao;
    }

    public void setStaffDetailDao(StaffDetailDao staffDetailDao) {
        this.staffDetailDao = staffDetailDao;
    }

    public boolean addStaffDetail(StaffDetail staffDetail) {
        if(staffDetail!=null){
            return staffDetailDao.addStaffDetail(staffDetail);
        }return false;
    }

    public StaffDetail foundNewDetail(StaffDetail staffDetail) {
        if(staffDetail!=null){
            return staffDetailDao.foundNewDetail(staffDetail);
        }return null;
    }

    public StaffDetail fountDetailByT_NAME(String sd_tname) {
        if(sd_tname!=null){
            return staffDetailDao.fountDetailByT_NAME(sd_tname);
        }return null;
    }

    public StaffDetail foundDetailBySD_ID(Integer sd_id) {
        if(sd_id!=null){
            return staffDetailDao.foundDetailBySD_ID(sd_id);
        }return null;
    }

    public List<StaffDetail> queryAllStaffDetail() {
        return staffDetailDao.queryAllStaffDetail();
    }

    public boolean updateStaffDetail(StaffDetail staffDetail) {
        if(staffDetail!=null){
            return staffDetailDao.updateStaffDetail(staffDetail);
        }return false;
    }

    public List<StaffDetail> queryAllStaffDetailBypo_id(Integer sd_poid) {
        if(sd_poid!=null){
            return staffDetailDao.queryAllStaffDetailBypo_id(sd_poid);
        }return null;
    }

    public boolean updateDE_PO(StaffDetail staffDetail) {
        if(staffDetail!=null){
            staffDetailDao.updateDE_PO(staffDetail);
        }return false;
    }

    public boolean updateState(StaffDetail staffDetail) {
        if (staffDetail!=null){
            return staffDetailDao.updateState(staffDetail);
        }return false;
    }

    public StaffDetail getthisshtaff(Integer sd_id) {
        if(sd_id!=null){
            return staffDetailDao.getthisshtaff(sd_id);
        }return null;
    }

    public boolean sayGoodBy(StaffDetail staffDetail) {
        if(staffDetail!=null){
            return staffDetailDao.sayGoodBy(staffDetail);
        }return false;
    }

    public boolean Staffresignation(StaffDetail staffDetail) {
        if(staffDetail!=null){
            return staffDetailDao.Staffresignation(staffDetail);
        }return false;
    }

}
