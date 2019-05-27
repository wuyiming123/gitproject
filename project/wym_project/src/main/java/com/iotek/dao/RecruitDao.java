package com.iotek.dao;

import com.iotek.model.Recruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitDao {
    List<Recruit> getAllRecruit();
    List<Recruit> AllrecruitByOn(@Param("ri_ison") String ri_ison);
    Recruit getRecruit(@Param("ri_id") Integer ri_id);
    boolean updateRecruiton(@Param("ri_id")Integer ri_id,@Param("ri_ison")String ri_ison);
    boolean updateRecruitoff(@Param("ri_id")Integer ri_id,@Param("ri_ison")String ri_ison);
    boolean addRecruito(Recruit recruit);
    boolean updateThisRecruit(Recruit recruit);
    boolean become_NoBodySee(@Param("ri_id") Integer ri_id,@Param("ri_ison")String ri_ison);
}
