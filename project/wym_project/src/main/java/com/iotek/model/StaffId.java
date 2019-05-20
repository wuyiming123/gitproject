package com.iotek.model;

import java.io.Serializable;

public class StaffId implements Serializable {
    private Integer sid_id;
    private Integer sid_sdid;
    private Integer sid_taid;

    public StaffId() {
    }

    public Integer getSid_id() {
        return sid_id;
    }

    public void setSid_id(Integer sid_id) {
        this.sid_id = sid_id;
    }

    public Integer getSid_sdid() {
        return sid_sdid;
    }

    public void setSid_sdid(Integer sid_sdid) {
        this.sid_sdid = sid_sdid;
    }

    public Integer getSid_taid() {
        return sid_taid;
    }

    public void setSid_taid(Integer sid_taid) {
        this.sid_taid = sid_taid;
    }

    @Override
    public String toString() {
        return "StaffId{" +
                "sid_id=" + sid_id +
                ", sid_sdid=" + sid_sdid +
                ", sid_taid=" + sid_taid +
                '}';
    }
}
