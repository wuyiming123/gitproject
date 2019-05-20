package com.iotek.service;

import com.iotek.model.CheckWork;

import java.util.List;

public interface CheckWorkService {
    boolean hellocheckwork(CheckWork checkWork);
    List<CheckWork> foundTodayCheckWork(CheckWork checkWork);
}
