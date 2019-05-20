package com.iotek.service.impl;

import com.iotek.dao.InterviewDao;
import com.iotek.model.InterView;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public boolean addInterviewstate2(InterView interView) {
        if(interView!=null){
            return interviewDao.addInterviewstate2(interView);
        }else{
            return false;
        }
    }

    public InterView queryIntByid(Integer i_did) {
        if(i_did!=null){
            return interviewDao.queryIntByid(i_did);
        }else {
            return null;
        }
    }

    public InterView queryIntByi_id(Integer i_id) {
        if(i_id!=null){
            return interviewDao.queryIntByi_id(i_id);
        }return null;
    }

    public boolean updateState_666(InterView interView) {
        if(interView!=null){
            return interviewDao.updateState_666(interView);
        }return false;
    }

    public List<InterView> queryAllInter() {
        return interviewDao.queryAllInter();
    }

    public List<InterView> queryInter_state666() {
        Integer i_state=666;
        return interviewDao.queryInter_state666(i_state);
    }
}
