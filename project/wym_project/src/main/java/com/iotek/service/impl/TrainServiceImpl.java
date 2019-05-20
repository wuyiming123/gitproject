package com.iotek.service.impl;

import com.iotek.dao.TrainDao;
import com.iotek.model.Train;
import com.iotek.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainDao trainDao;

    public List<Train> queryAllTrain() {
        return trainDao.queryAllTrain();
    }
}
