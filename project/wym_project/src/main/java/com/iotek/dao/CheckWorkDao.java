package com.iotek.dao;

import com.iotek.model.CheckWork;

import java.util.List;

public interface CheckWorkDao {
    boolean hellocheckwork(CheckWork checkWork);
    List<CheckWork> foundTodayCheckWork(CheckWork checkWork);
}
