package com.iotek.service;

import com.iotek.model.StaffId;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffIdService {
    List<StaffId> queryStaffIdBy_sid_taid(Integer sid_taid);
    boolean delBy_sid_id(Integer sid_id);
    StaffId queryBy_sid_id( Integer sid_id);
    boolean addStaffId(StaffId staffId);
    StaffId queryStaffId(StaffId staffId);
    boolean delStaffID(Integer sid_taid);
    List<StaffId> queryStaffIdBy(Integer sid_sdid);
    boolean del_By_sid_sdid(Integer sid_sdid);
}
