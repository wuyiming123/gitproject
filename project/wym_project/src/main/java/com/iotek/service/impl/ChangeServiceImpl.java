package com.iotek.service.impl;

import com.iotek.dao.ChangeDao;
import com.iotek.model.Change;
import com.iotek.service.ChangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChangeServiceImpl implements ChangeService {
    @Resource
    private ChangeDao changeDao;

    public ChangeDao getChangeDao() {
        return changeDao;
    }

    public void setChangeDao(ChangeDao changeDao) {
        this.changeDao = changeDao;
    }

    public boolean addNewChange(Change change) {
        if(change!=null){
            changeDao.addNewChange(change);
        }return false;
    }

    public Change foundChangeBydate_id(Change change) {
        if(change!=null){
            return changeDao.foundChangeBydate_id(change);
        }return null;
    }
}
