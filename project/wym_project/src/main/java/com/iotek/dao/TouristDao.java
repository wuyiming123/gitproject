package com.iotek.dao;

import com.iotek.model.Tourist;

public interface TouristDao {
    Tourist getTouristByNAMEAndPASS(Tourist tourist);
    boolean addTourist(Tourist tourist);
    Tourist getTouristByName(String t_name);
}
