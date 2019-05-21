package com.iotek.service;

import com.iotek.model.Change;

import java.util.List;

public interface ChangeService {
    boolean addNewChange(Change change);
    Change foundChangeBydate_id(Change change);
    List<Change> queryAllChangeBy_sid(Change change);
}
