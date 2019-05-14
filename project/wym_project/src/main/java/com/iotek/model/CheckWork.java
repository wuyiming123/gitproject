package com.iotek.model;

public class CheckWork {
    private Integer cw_id;
    private Integer cw_sid;
    private String cw_time;
    private String cw_state;

    public CheckWork() {
    }

    public Integer getCw_id() {
        return cw_id;
    }

    public void setCw_id(Integer cw_id) {
        this.cw_id = cw_id;
    }

    public Integer getCw_sid() {
        return cw_sid;
    }

    public void setCw_sid(Integer cw_sid) {
        this.cw_sid = cw_sid;
    }

    public String getCw_time() {
        return cw_time;
    }

    public void setCw_time(String cw_time) {
        this.cw_time = cw_time;
    }

    public String getCw_state() {
        return cw_state;
    }

    public void setCw_state(String cw_state) {
        this.cw_state = cw_state;
    }

    @Override
    public String toString() {
        return "CheckWork{" +
                "cw_id=" + cw_id +
                ", cw_sid=" + cw_sid +
                ", cw_time='" + cw_time + '\'' +
                ", cw_state='" + cw_state + '\'' +
                '}';
    }
}
