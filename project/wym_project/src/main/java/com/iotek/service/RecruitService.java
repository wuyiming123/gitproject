package com.iotek.service;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitService {
    List<Recruit> getAllRecruit();
    Recruit getRecruit(Integer ri_id);

}
