package com.iotek.dao;

import com.iotek.model.InterView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewDao {
    boolean addInterviewstate1(InterView interView);
    boolean addInterviewstate2(InterView interView);
    InterView queryIntByid(@Param("i_did") Integer i_did);
    InterView queryIntByi_id(@Param("i_id") Integer i_id);
    boolean updateState_666(InterView interView);
    List<InterView> queryAllInter();
    List<InterView> queryInter_state666(@Param("i_state") Integer i_state);
}
