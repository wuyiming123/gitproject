package com.iotek.service.impl;

import com.iotek.dao.TouristDao;
import com.iotek.model.Tourist;
import com.iotek.service.TouristService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        if(tourist==null){
            return null;
        }else {
            return touristDao.getTouristByNAMEAndPASS(tourist);
        }
    }

    public boolean addTourist(Tourist tourist) {
        if(tourist==null){
            return false;
        }else {
            return touristDao.addTourist(tourist);
        }

    }

    public Tourist getTouristByName(String t_name) {
        if(t_name==null){
            return null;
        }else {
            return touristDao.getTouristByName(t_name);
        }
    }

    public List<Tourist> queryAllT() {
        return touristDao.queryAllT();
    }
}
