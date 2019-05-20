package com.iotek.service.impl;

import com.iotek.dao.PositionDao;
import com.iotek.model.Position;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    public PositionDao getPositionDao() {
        return positionDao;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    public List<Position> queryAllPositionBydeid(Integer po_deid) {
        if(po_deid!=null){
            return positionDao.queryAllPositionBydeid(po_deid);
        }else {
            return null;
        }
    }

    public boolean addPosition(Position position) {
        position.setPo_stcount(0);
        if(position!=null){
            return positionDao.addPosition(position);
        }return false;
    }

    public boolean delPosition(Integer po_deid) {
        if(po_deid!=null){
            return positionDao.delPosition(po_deid);
        }else {
            return false;
        }
    }

    public Position queryPositionBypoid(Integer po_id) {
        if(po_id!=null){
            return positionDao.queryPositionBypoid(po_id);
        }
        return null;
    }

    public boolean delPositionBypoid(Integer po_id) {
        if(po_id!=null){
            return positionDao.delPositionBypoid(po_id);
        }else {
            return false;
        }
    }

    public List<Position> queryAllPosi() {
        return positionDao.queryAllPosi();
    }

    public boolean updatePositionCOUNT(Position position) {
        if(position!=null){
            return positionDao.updatePositionCOUNT(position);
        }return false;
    }
}
