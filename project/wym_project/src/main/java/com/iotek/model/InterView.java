package com.iotek.model;

import java.io.Serializable;
/**
面试
 */
public class InterView implements Serializable {
    private Integer i_id;
    private Integer i_phone;
    private String i_address;
    private Integer i_tid;
    private String i_time;

    public InterView() {
    }

    public Integer getI_id() {
        return i_id;
    }

    public void setI_id(Integer i_id) {
        this.i_id = i_id;
    }

    public Integer getI_phone() {
        return i_phone;
    }

    public void setI_phone(Integer i_phone) {
        this.i_phone = i_phone;
    }

    public String getI_address() {
        return i_address;
    }

    public void setI_address(String i_address) {
        this.i_address = i_address;
    }

    public Integer getI_tid() {
        return i_tid;
    }

    public void setI_tid(Integer i_tid) {
        this.i_tid = i_tid;
    }

    public String getI_time() {
        return i_time;
    }

    public void setI_time(String i_time) {
        this.i_time = i_time;
    }

    @Override
    public String toString() {
        return "InterView{" +
                "i_id=" + i_id +
                ", i_phone=" + i_phone +
                ", i_address='" + i_address + '\'' +
                ", i_tid=" + i_tid +
                ", i_time='" + i_time + '\'' +
                '}';
    }
}
