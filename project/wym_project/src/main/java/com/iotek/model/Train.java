package com.iotek.model;

import java.io.Serializable;

public class Train implements Serializable {
    private Integer tr_id;
    private Integer tr_sid;
    private String tr_title;
    private String tr_message;
    private String tr_time;
    private Integer tr_state;

    public Train() {
    }

    public String getTr_title() {
        return tr_title;
    }

    public void setTr_title(String tr_title) {
        this.tr_title = tr_title;
    }

    public Integer getTr_id() {
        return tr_id;
    }

    public void setTr_id(Integer tr_id) {
        this.tr_id = tr_id;
    }

    public Integer getTr_sid() {
        return tr_sid;
    }

    public void setTr_sid(Integer tr_sid) {
        this.tr_sid = tr_sid;
    }

    public String getTr_message() {
        return tr_message;
    }

    public void setTr_message(String tr_message) {
        this.tr_message = tr_message;
    }

    public String getTr_time() {
        return tr_time;
    }

    public void setTr_time(String tr_time) {
        this.tr_time = tr_time;
    }

    public Integer getTr_state() {
        return tr_state;
    }

    public void setTr_state(Integer tr_state) {
        this.tr_state = tr_state;
    }

    @Override
    public String toString() {
        return "Train{" +
                "tr_id=" + tr_id +
                ", tr_sid=" + tr_sid +
                ", tr_message='" + tr_message + '\'' +
                ", tr_time='" + tr_time + '\'' +
                ", tr_state=" + tr_state +
                '}';
    }
}
