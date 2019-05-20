package com.iotek.dao;

import com.iotek.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionDao {
    List<Position> queryAllPositionBydeid(@Param("po_deid") Integer po_deid);
    boolean addPosition(Position position);
    boolean delPosition(Integer po_deid);
    Position queryPositionBypoid(@Param("po_id") Integer po_id);
    boolean delPositionBypoid(@Param("po_id") Integer po_id);
    List<Position> queryAllPosi();
    boolean updatePositionCOUNT(Position position);
}
