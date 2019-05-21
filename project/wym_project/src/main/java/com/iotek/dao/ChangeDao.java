package com.iotek.dao;

import com.iotek.model.Change;

public interface ChangeDao {
    boolean addNewChange(Change change);
    Change foundChangeBydate_id(Change change);
}
