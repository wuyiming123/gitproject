package com.iotek.dao;

import com.iotek.model.StaffDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffDetailDao {
    boolean addStaffDetail(StaffDetail staffDetail);
    StaffDetail foundNewDetail(StaffDetail staffDetail);
    StaffDetail fountDetailByT_NAME(@Param("sd_tname") String sd_tname);
    StaffDetail foundDetailBySD_ID(@Param("sd_id") Integer sd_id);
    List<StaffDetail> queryAllStaffDetail();
    List<StaffDetail> queryAllStaffDetailBypo_id(@Param("sd_poid") Integer sd_poid);
    boolean updateStaffDetail(StaffDetail staffDetail);
    boolean updateDE_PO(StaffDetail staffDetail);
    boolean updateState(StaffDetail staffDetail);
    StaffDetail getthisshtaff(@Param("sd_id") Integer sd_id);
}
