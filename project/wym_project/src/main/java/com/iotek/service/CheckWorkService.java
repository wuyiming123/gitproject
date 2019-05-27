package com.iotek.service;

import com.iotek.model.CheckWork;

import java.util.List;

public interface CheckWorkService {
    boolean hellocheckwork(CheckWork checkWork);
    List<CheckWork> foundTodayCheckWork(CheckWork checkWork);
    List<CheckWork> foundTodayCheckWorkBySD_ID(Integer cw_sdid);
    List<CheckWork> queryMonth(Integer cw_sdid,Integer month);
    CheckWork foundCheckWorkBydate_id(CheckWork checkWork);
}
