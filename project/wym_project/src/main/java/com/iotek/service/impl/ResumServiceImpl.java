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
}
