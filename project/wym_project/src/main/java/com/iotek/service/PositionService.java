package com.iotek.service;

import com.iotek.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService {
    List<Position> queryAllPositionBydeid(Integer po_deid);
    boolean addPosition(Position position);
    boolean delPosition(Integer po_deid);
    Position queryPositionBypoid(Integer po_id);
    boolean delPositionBypoid(Integer po_id);
    List<Position> queryAllPosi();
    boolean updatePositionCOUNT(Position position);
}
