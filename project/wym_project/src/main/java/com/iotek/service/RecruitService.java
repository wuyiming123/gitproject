package com.iotek.service;

import com.iotek.model.Recruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitService {
    List<Recruit> getAllRecruit();
    List<Recruit> AllrecruitByOn();
    Recruit getRecruit(Integer ri_id);
    boolean updateRecruiton(Integer ri_id);
    boolean updateRecruitoff(Integer ri_id);
    boolean addRecruito(Recruit recruit);
    boolean updateThisRecruit(Recruit recruit);
    boolean become_NoBodySee(Integer ri_id);
}
