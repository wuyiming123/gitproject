package com.iotek.dao;

import com.iotek.model.Train;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainDao {
    List<Train> queryAllTrain();
    Train queryThisTrain(@Param("tr_id") Integer tr_id);
    boolean updateState(Train train);
    boolean updateTrain(Train train);
    boolean delTrain(@Param("tr_id") Integer tr_id);
    boolean addTrain(Train train);
}
