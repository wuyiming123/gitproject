package com.iotek.service;

import com.iotek.model.Resume;

import java.util.List;

public interface ResumService {
    List<Resume> allResumByTid(Integer r_tid);
    boolean addResume(Resume resume);
    Resume getResumByID(Integer r_id);
    boolean updateResume(Resume resume);
    boolean delThisResume(Integer r_id);
    List<Resume> queryAllResume();
}
