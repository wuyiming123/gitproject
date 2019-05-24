package com.iotek.dao;

import com.iotek.model.Delivery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryDao {
    boolean addDelivery(Delivery delivery);
    List<Delivery> queryAllDe();
    List<Delivery> queryAllDeBystate2(@Param("d_state") Integer d_state);
    Delivery founddelivery(@Param("d_tid") Integer d_tid,@Param("d_riid") Integer d_riid,@Param("d_state") Integer d_state);
    Delivery founddeliverynostate(@Param("d_tid") Integer d_tid,@Param("d_riid") Integer d_riid);
    Delivery fountDeliByridAndriid(@Param("d_riid") Integer d_riid,@Param("d_rid") Integer d_rid);
    Delivery fountDeliByid(@Param("d_id") Integer d_id);
    boolean updateDeli(Delivery delivery);
    List<Delivery> queryDeBytid(@Param("d_tid") Integer d_tid);
    List<Delivery> queryDeBytid_state(@Param("d_tid") Integer d_tid,@Param("d_state") Integer d_state);
}
