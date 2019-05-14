package com.iotek.model;

import java.io.Serializable;

public class Position implements Serializable {
    private Integer po_id;
    private String po_name;
    private String po_time;
    private Integer po_num;

    public Position() {
    }

    public Integer getPo_id() {
        return po_id;
    }

    public void setPo_id(Integer po_id) {
        this.po_id = po_id;
    }

    public String getPo_name() {
        return po_name;
    }

    public void setPo_name(String po_name) {
        this.po_name = po_name;
    }

    public String getPo_time() {
        return po_time;
    }

    public void setPo_time(String po_time) {
        this.po_time = po_time;
    }

    public Integer getPo_num() {
        return po_num;
    }

    public void setPo_num(Integer po_num) {
        this.po_num = po_num;
    }

    @Override
    public String toString() {
        return "Position{" +
                "po_id=" + po_id +
                ", po_name='" + po_name + '\'' +
                ", po_time='" + po_time + '\'' +
                ", po_num=" + po_num +
                '}';
    }
}
