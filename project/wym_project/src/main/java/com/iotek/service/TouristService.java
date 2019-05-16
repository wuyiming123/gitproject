package com.iotek.service;

import com.iotek.model.Tourist;

import java.util.List;

public interface TouristService {
    Tourist getTouristByNAMEAndPASS(Tourist tourist);
    boolean addTourist(Tourist tourist);
    Tourist getTouristByName(String t_name);
    List<Tourist> queryAllT();
}
