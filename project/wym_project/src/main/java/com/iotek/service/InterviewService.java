package com.iotek.service;

import com.iotek.model.InterView;

public interface InterviewService {
    boolean addInterviewstate1(InterView interView);
    boolean addInterviewstate2(InterView interView);
    InterView queryIntByid(Integer i_did);
}
