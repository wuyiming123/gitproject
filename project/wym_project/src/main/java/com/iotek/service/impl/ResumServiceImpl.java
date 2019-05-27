package com.iotek.service.impl;

import com.iotek.dao.ResumDao;
import com.iotek.model.Resume;
import com.iotek.service.ResumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ResumServiceImpl implements ResumService {
    @Resource
    private ResumDao resumDao;

    public ResumDao getResumDao() {
        return resumDao;
    }

    public void setResumDao(ResumDao resumDao) {
        this.resumDao = resumDao;
    }

    public List<Resume> allResumByTid(Integer r_tid) {
        if(r_tid!=null){
            return resumDao.allResumByTid(r_tid);
        }
        return null;
    }

    public boolean addResume(Resume resume) {
        if(resume!=null){
            return resumDao.addResum(resume);
        }else {
            return false;
        }
    }

    public Resume getResumByID(Integer r_id) {
        if(r_id!=null){
            return resumDao.getResumByID(r_id);
        }else {
            return null;
        }
    }

    public boolean updateResume(Resume resume) {
        if(resume!=null){
            return resumDao.updateResume(resume);
        }else {
            return false;
        }
    }

    public boolean delThisResume(Integer r_id) {
        if(r_id!=null){
            return resumDao.delThisResume(r_id);
        }else {
            return false;
        }
    }

    public List<Resume> queryAllResume() {
        return resumDao.queryAllResume();
    }

    public boolean updateStateResume(Integer r_id, String r_state) {
        if(r_id!=null && r_state!=null){
            return resumDao.updateStateResume(r_id,r_state);
        }return false;
    }
}
