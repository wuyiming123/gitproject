package com.iotek.model;

public class CheckWork {
    private Integer cw_id;
    private Integer cw_sdid;
    private String cw_time;
    private String cw_date;
    private Integer cw_smalltime;
    private Integer cw_state;

    public CheckWork() {
    }

    public Integer getCw_id() {
        return cw_id;
    }

    public void setCw_id(Integer cw_id) {
        this.cw_id = cw_id;
    }

    public Integer getCw_sdid() {
        return cw_sdid;
    }

    public void setCw_sdid(Integer cw_sdid) {
        this.cw_sdid = cw_sdid;
    }

    public String getCw_time() {
        return cw_time;
    }

    public void setCw_time(String cw_time) {
        this.cw_time = cw_time;
    }

    public String getCw_date() {
        return cw_date;
    }

    public void setCw_date(String cw_date) {
        this.cw_date = cw_date;
    }

    public Integer getCw_state() {
        return cw_state;
    }

    public void setCw_state(Integer cw_state) {
        this.cw_state = cw_state;
    }

    public Integer getCw_smalltime() {
        return cw_smalltime;
    }

    public void setCw_smalltime(Integer cw_smalltime) {
        this.cw_smalltime = cw_smalltime;
    }

    @Override
    public String toString() {
        return "CheckWork{" +
                "cw_id=" + cw_id +
                ", cw_sdid=" + cw_sdid +
                ", cw_time='" + cw_time + '\'' +
                ", cw_state='" + cw_state + '\'' +
                '}';
    }
}
