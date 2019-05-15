package com.iotek.dao;

import com.iotek.model.Resume;

import java.util.List;

public interface ResumDao {
    List<Resume> allResumByTid(Integer r_tid);
}
