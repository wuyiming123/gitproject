package com.iotek.service;

import com.iotek.model.StaffDetail;

import java.util.List;

public interface StaffDetailService {
    boolean addStaffDetail(StaffDetail staffDetail);
    StaffDetail foundNewDetail(StaffDetail staffDetail);
    StaffDetail fountDetailByT_NAME( String sd_tname);
    StaffDetail foundDetailBySD_ID(Integer sd_id);
    List<StaffDetail> queryAllStaffDetail();
    boolean updateStaffDetail(StaffDetail staffDetail);
    List<StaffDetail> queryAllStaffDetailBypo_id(Integer sd_poid);
    boolean updateDE_PO(StaffDetail staffDetail);
    boolean updateState(StaffDetail staffDetail);
    StaffDetail getthisshtaff(Integer sd_id);
    boolean sayGoodBy(StaffDetail staffDetail);
    boolean Staffresignation(StaffDetail staffDetail);
}
