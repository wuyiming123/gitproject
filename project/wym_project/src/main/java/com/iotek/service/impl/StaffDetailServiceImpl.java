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

}
