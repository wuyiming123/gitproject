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

    public boolean updateRecruiton(Integer ri_id) {
        return recruitDao.updateRecruiton(ri_id,"on");
    }

    public boolean updateRecruitoff(Integer ri_id) {
        return recruitDao.updateRecruitoff(ri_id,"off");
    }

    public boolean addRecruito(Recruit recruit) {
        if(recruit!=null){
            return recruitDao.addRecruito(recruit);
        }
        return false;
    }

    public boolean updateThisRecruit(Recruit recruit) {
        if(recruit!=null){
            return recruitDao.updateThisRecruit(recruit);
        }
        return false;
    }

    public boolean become_NoBodySee(Integer ri_id) {
        String ri_ison="nobodysee";
        if(ri_id!=null){
            return recruitDao.become_NoBodySee(ri_id,ri_ison);
        }
        return false;
    }


}
