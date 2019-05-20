package com.iotek.service;

import com.iotek.model.StaffDetail;

import java.util.List;

public interface StaffDetailService {
    boolean addStaffDetail(StaffDetail staffDetail);
    StaffDetail foundNewDetail(StaffDetail staffDetail);
    StaffDetail fountDetailByT_NAME( String sd_tname);
    StaffDetail foundDetailBySD_ID(Integer sd_id);
    List<StaffDetail> queryAllStaffDetail();
}
