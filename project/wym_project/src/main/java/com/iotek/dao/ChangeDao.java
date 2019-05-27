package com.iotek.dao;

import com.iotek.model.Change;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChangeDao {
    boolean addNewChange(Change change);
    Change foundChangeBydate_id(Change change);
    List<Change> queryAllChangeBy_sid(Change change);
    Change queryTime_Change(Change change);
    List<Change> queryByMonth(Integer c_sid,Integer month);
    boolean delchange(Change change);
    boolean delchangeBy_id(@Param("c_id") Integer c_id);
    boolean updateChange(Change change);
}
