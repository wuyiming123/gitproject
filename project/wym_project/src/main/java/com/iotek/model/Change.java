package com.iotek.model;

import java.io.Serializable;

public class Change implements Serializable {
    private Integer c_id;
    private Integer c_sid;
    private Integer c_money;
    private String c_time;
    private String c_why;
    private Integer c_state;

    public Change() {
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_sid() {
        return c_sid;
    }

    public void setC_sid(Integer c_sid) {
        this.c_sid = c_sid;
    }

    public Integer getC_money() {
        return c_money;
    }

    public void setC_money(Integer c_money) {
        this.c_money = c_money;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getC_why() {
        return c_why;
    }

    public void setC_why(String c_why) {
        this.c_why = c_why;
    }

    public Integer getC_state() {
        return c_state;
    }

    public void setC_state(Integer c_state) {
        this.c_state = c_state;
    }

    @Override
    public String toString() {
        return "Change{" +
                "c_id=" + c_id +
                ", c_sid=" + c_sid +
                ", c_money=" + c_money +
                ", c_time='" + c_time + '\'' +
                ", c_why='" + c_why + '\'' +
                ", c_state=" + c_state +
                '}';
    }
}
