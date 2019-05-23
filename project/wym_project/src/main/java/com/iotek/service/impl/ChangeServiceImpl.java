package com.iotek.service.impl;

import com.iotek.dao.ChangeDao;
import com.iotek.model.Change;
import com.iotek.service.ChangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<Change> queryAllChangeBy_sid(Change change) {
        if(change!=null){
            return changeDao.queryAllChangeBy_sid(change);
        }return null;
    }

    public Change queryTime_Change(Change change) {
        if(change!=null){
            return changeDao.queryTime_Change(change);
        }return null;
    }

    public List<Change> queryByMonth(Integer c_sid, Integer month) {
        if(c_sid!=null || month!=null){
            return changeDao.queryByMonth(c_sid,month);
        }
        return null;
    }
}
