package com.iotek.dao;

import com.iotek.model.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumDao {
    List<Resume> allResumByTid(Integer r_tid);
    boolean addResum(Resume resume);
    Resume getResumByID(Integer r_id);
    boolean updateResume(Resume resume);
    boolean delThisResume(Integer r_id);
    List<Resume> queryAllResume();
    boolean updateStateResume(@Param("r_id") Integer r_id,@Param("r_state")String r_state);
}
