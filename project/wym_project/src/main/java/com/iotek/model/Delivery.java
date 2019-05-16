package com.iotek.model;

public class Delivery {
    private Integer d_id;
    private Integer d_tid;//游客ID
    private Integer d_riid;//招聘表ID
    private Integer d_rid;//简历ID
    private Integer d_state;

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getD_tid() {
        return d_tid;
    }

    public void setD_tid(Integer d_tid) {
        this.d_tid = d_tid;
    }

    public Integer getD_riid() {
        return d_riid;
    }

    public void setD_riid(Integer d_riid) {
        this.d_riid = d_riid;
    }

    public Integer getD_rid() {
        return d_rid;
    }

    public void setD_rid(Integer d_rid) {
        this.d_rid = d_rid;
    }

    public Integer getD_state() {
        return d_state;
    }

    public void setD_state(Integer d_state) {
        this.d_state = d_state;
    }

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivary{" +
                "d_id=" + d_id +
                ", d_tid=" + d_tid +
                ", d_riid=" + d_riid +
                ", d_rid=" + d_rid +
                '}';
    }
}
