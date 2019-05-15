package com.iotek.service;

import com.iotek.model.Resume;

import java.util.List;

public interface ResumService {
    List<Resume> allResumByTid(Integer r_tid);

}
