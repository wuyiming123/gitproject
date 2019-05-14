package com.iotek.service.impl;

import com.iotek.dao.TouristDao;
import com.iotek.model.Tourist;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TouristServiceImpl implements TouristService {
    @Resource
    private TouristDao touristDao;

    public TouristDao getTouristDao() {
        return touristDao;
    }

    public void setTouristDao(TouristDao touristDao) {
        this.touristDao = touristDao;
    }

    public Tourist getTouristByNAMEAndPASS(Tourist tourist) {
        return touristDao.getTouristByNAMEAndPASS(tourist);
    }

    public boolean addTourist(Tourist tourist) {
        return touristDao.addTourist(tourist);
    }

    public Tourist getTouristByName(String t_name) {
        return touristDao.getTouristByName(t_name);
    }
}
