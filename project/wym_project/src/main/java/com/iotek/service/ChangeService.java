package com.iotek.service;

import com.iotek.model.Change;

public interface ChangeService {
    boolean addNewChange(Change change);
    Change foundChangeBydate_id(Change change);
}
