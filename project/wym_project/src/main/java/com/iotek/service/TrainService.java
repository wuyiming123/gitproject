package com.iotek.service;

import com.iotek.model.Train;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainService {
    List<Train> queryAllTrain();
    Train queryThisTrain(Integer tr_id);
    boolean updateState(Train train);
    boolean updateTrain(Train train);
    boolean delTrain(Integer tr_id);
    boolean addTrain(Train train);
}
