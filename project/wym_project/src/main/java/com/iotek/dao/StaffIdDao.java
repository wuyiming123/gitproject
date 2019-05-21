package com.iotek.dao;

import com.iotek.model.StaffId;
import com.iotek.model.Train;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffIdDao {
    List<StaffId> queryStaffIdBy_sid_taid(@Param("sid_taid") Integer sid_taid);
    boolean delBy_sid_id(@Param("sid_id") Integer sid_id);
    StaffId queryBy_sid_id(@Param("sid_id") Integer sid_id);
    boolean addStaffId(StaffId staffId);
    StaffId queryStaffId(StaffId staffId);
    boolean delStaffID(@Param("sid_taid") Integer sid_taid);
    List<StaffId> queryStaffIdBy(@Param("sid_sdid") Integer sid_sdid);

}
