package com.iotek.dao;

import com.iotek.model.InterView;
import org.apache.ibatis.annotations.Param;

public interface InterviewDao {
    boolean addInterviewstate1(InterView interView);
    boolean addInterviewstate2(InterView interView);
    InterView queryIntByid(@Param("i_did") Integer i_did);
}
