package com.iotek.service.impl;

import com.iotek.dao.DeliveryDao;
import com.iotek.model.Delivery;
import com.iotek.service.DeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Resource
    private DeliveryDao deliveryDao;

    public boolean addDelivery(Delivery delivery) {
        if(delivery!=null){
            return deliveryDao.addDelivery(delivery);
        }
        return false;
    }

    public List<Delivery> queryAllDe() {
        return deliveryDao.queryAllDe();
    }

    public List<Delivery> queryAllDeBystate2(Integer d_state) {
        return deliveryDao.queryAllDeBystate2(d_state);
    }

    public Delivery founddelivery(Integer d_tid, Integer d_riid) {
        if(d_riid==null | d_tid==null){
            return null;
        }else{
            return deliveryDao.founddelivery(d_tid,d_riid);
        }
    }

    public Delivery fountDeliByridAndriid(Integer d_riid, Integer d_rid) {
        if(d_riid==null | d_rid==null){
            return null;
        }else {
            return deliveryDao.fountDeliByridAndriid(d_riid,d_rid);
        }
    }

    public Delivery fountDeliByid(Integer d_id) {
        if(d_id==null){
            return null;
        }else {
            return deliveryDao.fountDeliByid(d_id);
        }
    }

    public boolean updateDeli(Delivery delivery) {
       if(delivery!=null){
           deliveryDao.updateDeli(delivery);
       }else {
           return false;
       }
       return false;
    }

    public List<Delivery> queryDeBytid(Integer d_tid) {
        if(d_tid!=null){
            return deliveryDao.queryDeBytid(d_tid);
        }else {
            return null;
        }
    }

    public List<Delivery> queryDeBytid_state(Integer d_tid, Integer d_state) {
        if(d_tid!=null | d_state!=null){
            return deliveryDao.queryDeBytid_state(d_tid,d_state);
        }else {
            return null;
        }
    }
}
