package com.iotek.service;

import com.iotek.model.Tourist;

public interface TouristService {
    Tourist getTouristByNAMEAndPASS(Tourist tourist);
    boolean addTourist(Tourist tourist);
    Tourist getTouristByName(String t_name);
}
