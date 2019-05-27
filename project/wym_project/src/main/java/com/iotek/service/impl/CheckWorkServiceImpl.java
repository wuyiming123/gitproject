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

    public List<CheckWork> foundTodayCheckWorkBySD_ID(Integer cw_sdid) {
        if(cw_sdid!=null){
            return checkWorkDao.foundTodayCheckWorkBySD_ID(cw_sdid);
        }return null;
    }

    public List<CheckWork> queryMonth(Integer cw_sdid, Integer month) {
        return checkWorkDao.queryMonth(cw_sdid,month);
    }

    public CheckWork foundCheckWorkBydate_id(CheckWork checkWork) {
        if(checkWork!=null){
            return checkWorkDao.foundCheckWorkBydate_id(checkWork);
        }return null;
    }


}
