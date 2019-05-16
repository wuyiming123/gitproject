package com.iotek.service;

import com.iotek.model.Delivery;

import java.util.List;

public interface DeliveryService {
    boolean addDelivery(Delivery delivery);
    List<Delivery> queryAllDe();
    List<Delivery> queryAllDeBystate2(Integer d_state);
    Delivery founddelivery(Integer d_tid,Integer d_riid);
    Delivery fountDeliByridAndriid(Integer d_riid,Integer d_rid);
    boolean updateDeli(Delivery delivery);
}
