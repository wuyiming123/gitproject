package com.iotek.dao;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitDao {
    List<Recruit> getAllRecruit();
    Recruit getRecruit(Integer ri_id);
}
