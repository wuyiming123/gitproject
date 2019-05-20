package com.iotek.service.impl;

import com.iotek.dao.CheckWorkDao;
import com.iotek.model.CheckWork;
import com.iotek.service.CheckWorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckWorkServiceImpl implements CheckWorkService {
    @Resource
    private CheckWorkDao checkWorkDao;

    public boolean hellocheckwork(CheckWork checkWork) {
        if(checkWork!=null){
            return checkWorkDao.hellocheckwork(checkWork);
        }return false;
    }

    public List<CheckWork> foundTodayCheckWork(CheckWork checkWork) {
        if(checkWork!=null){
            List<CheckWork> checkWorks = checkWorkDao.foundTodayCheckWork(checkWork);
            return checkWorks;
        }
        return null;
    }


}
