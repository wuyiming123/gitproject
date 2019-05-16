package com.iotek.service.impl;

import com.iotek.dao.RecruitDao;
import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    public RecruitDao getRecruitDao() {
        return recruitDao;
    }

    public void setRecruitDao(RecruitDao recruitDao) {
        this.recruitDao = recruitDao;
    }

    public List<Recruit> getAllRecruit() {
        List<Recruit> allRecruit = recruitDao.getAllRecruit();
        return allRecruit;
    }

    public Recruit getRecruit(Integer ri_id) {
        if(ri_id!=null){
            Recruit recruit = recruitDao.getRecruit(ri_id);
            return recruit;
        }else {
            return null;
        }
    }


}
