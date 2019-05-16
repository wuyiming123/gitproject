package com.iotek.service.impl;

import com.iotek.dao.InterviewDao;
import com.iotek.model.InterView;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    public boolean addInterviewstate1(InterView interView) {
        if(interView!=null){
            return interviewDao.addInterviewstate1(interView);
        }else{
            return false;
        }
    }
}
