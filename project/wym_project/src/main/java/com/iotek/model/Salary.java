package com.iotek.model;

import java.io.Serializable;

public class Salary implements Serializable {
    private Integer sa_id;
    private Integer sa_sdid;
    private String sa_date;///月年日
    private  double sa_base;//基础工资
    private  double sa_overtime;//加班工资
    private  double sa_change;//奖惩工资
    private double sa_social;//社保
    private String sa_state;
    private double sa_money;

    public Salary() {
    }

    public Integer getSa_id() {
        return sa_id;
    }

    public void setSa_id(Integer sa_id) {
        this.sa_id = sa_id;
    }

    public Integer getSa_sdid() {
        return sa_sdid;
    }

    public void setSa_sdid(Integer sa_sdid) {
        this.sa_sdid = sa_sdid;
    }

    public String getSa_date() {
        return sa_date;
    }

    public void setSa_date(String sa_date) {
        this.sa_date = sa_date;
    }

    public double getSa_base() {
        return sa_base;
    }

    public void setSa_base(double sa_base) {
        this.sa_base = sa_base;
    }

    public double getSa_overtime() {
        return sa_overtime;
    }

    public void setSa_overtime(double sa_overtime) {
        this.sa_overtime = sa_overtime;
    }

    public double getSa_change() {
        return sa_change;
    }

    public void setSa_change(double sa_change) {
        this.sa_change = sa_change;
    }

    public double getSa_social() {
        return sa_social;
    }

    public void setSa_social(double sa_social) {
        this.sa_social = sa_social;
    }

    public String getSa_state() {
        return sa_state;
    }

    public void setSa_state(String sa_state) {
        this.sa_state = sa_state;
    }

    public double getSa_money() {
        return sa_money;
    }

    public void setSa_money(double sa_money) {
        this.sa_money = sa_money;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sa_id=" + sa_id +
                ", sa_sid=" + sa_sdid +
                ", sa_date='" + sa_date + '\'' +
                ", sa_base=" + sa_base +
                ", sa_overtime=" + sa_overtime +
                ", sa_change=" + sa_change +
                ", sa_social=" + sa_social +
                ", sa_state='" + sa_state + '\'' +
                ", sa_money=" + sa_money +
                '}';
    }
}
