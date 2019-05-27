package com.iotek.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private Integer s_id;
    private Integer s_sdid;
    private String s_sid;//工号
    private String s_spass;//密码
    private Integer s_state;
    private Integer s_overtime;

    public Staff() {
    }

    public Integer getS_overtime() {
        return s_overtime;
    }

    public void setS_overtime(Integer s_overtime) {
        this.s_overtime = s_overtime;
    }

    public Integer getS_state() {
        return s_state;
    }

    public void setS_state(Integer s_state) {
        this.s_state = s_state;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getS_sdid() {
        return s_sdid;
    }

    public void setS_sdid(Integer s_sdid) {
        this.s_sdid = s_sdid;
    }

    public String getS_sid() {
        return s_sid;
    }

    public void setS_sid(String s_sid) {
        this.s_sid = s_sid;
    }

    public String getS_spass() {
        return s_spass;
    }

    public void setS_spass(String s_spass) {
        this.s_spass = s_spass;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "s_id=" + s_id +
                ", s_sdid=" + s_sdid +
                ", s_sid='" + s_sid + '\'' +
                ", s_spass='" + s_spass + '\'' +
                '}';
    }
}
