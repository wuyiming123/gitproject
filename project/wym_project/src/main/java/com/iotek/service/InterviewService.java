package com.iotek.service;

import com.iotek.model.InterView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewService {
    boolean addInterviewstate1(InterView interView);
    boolean addInterviewstate2(InterView interView);
    InterView queryIntByid(Integer i_did);
    InterView queryIntByi_id(Integer i_id);
    boolean updateState_666(InterView interView);
    List<InterView> queryAllInter();
    List<InterView> queryInter_state666();
}
