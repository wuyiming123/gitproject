package com.iotek.dao;

import com.iotek.model.CheckWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckWorkDao {
    boolean hellocheckwork(CheckWork checkWork);
    List<CheckWork> foundTodayCheckWork(CheckWork checkWork);
    List<CheckWork> foundTodayCheckWorkBySD_ID(@Param("cw_sdid") Integer cw_sdid);
    List<CheckWork> queryMonth(Integer cw_sdid,Integer month);
}
