package com.iotek.service;

import com.iotek.model.Delivery;

import java.util.List;

public interface DeliveryService {
    boolean addDelivery(Delivery delivery);
    List<Delivery> queryAllDe();
    List<Delivery> queryAllDeBystate2(Integer d_state);
    Delivery founddelivery(Integer d_tid,Integer d_riid);
    Delivery fountDeliByridAndriid(Integer d_riid,Integer d_rid);
    Delivery fountDeliByid(Integer d_id);
    boolean updateDeli(Delivery delivery);
    List<Delivery> queryDeBytid(Integer d_tid);
    List<Delivery> queryDeBytid_state(Integer d_tid,Integer d_state);
}
