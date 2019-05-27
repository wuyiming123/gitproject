package com.iotek.service;

import com.iotek.model.Change;

import java.util.List;

public interface ChangeService {
    boolean addNewChange(Change change);
    Change foundChangeBydate_id(Change change);
    List<Change> queryAllChangeBy_sid(Change change);
    Change queryTime_Change(Change change);
    List<Change> queryByMonth(Integer c_sid,Integer month);
    boolean delchange(Change change);
    boolean delchangeBy_id(Integer c_id);
    boolean updateChange(Change change);
}
