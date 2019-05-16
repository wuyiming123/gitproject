package com.iotek.dao;

import com.iotek.model.Resume;

import java.util.List;

public interface ResumDao {
    List<Resume> allResumByTid(Integer r_tid);
    boolean addResum(Resume resume);
    Resume getResumByID(Integer r_id);
    boolean updateResume(Resume resume);
    boolean delThisResume(Integer r_id);
    List<Resume> queryAllResume();
}
