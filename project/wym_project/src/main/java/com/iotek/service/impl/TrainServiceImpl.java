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

    public Train queryThisTrain(Integer tr_id) {
        if(tr_id!=null){
            return trainDao.queryThisTrain(tr_id);
        }
        return null;
    }

    public boolean updateState(Train train) {
        if(train!=null){
            return trainDao.updateState(train);
        }return false;
    }

    public boolean updateTrain(Train train) {
        if(train!=null){
            return trainDao.updateTrain(train);
        }return false;
    }

    public boolean delTrain(Integer tr_id) {
        if(tr_id!=null){
            return trainDao.delTrain(tr_id);
        }return false;
    }

    public boolean addTrain(Train train) {
        if(train!=null){
            return trainDao.addTrain(train);
        }
        return false;
    }
}
