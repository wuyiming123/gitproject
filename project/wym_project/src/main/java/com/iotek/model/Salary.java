package com.iotek.model;

import java.io.Serializable;

public class Salary implements Serializable {
    private Integer sa_id;
    private Double sa_salary;
    private Integer sa_sid;
    private String sa_myd;///月年日

    public Salary() {
    }

    public Integer getSa_id() {
        return sa_id;
    }

    public void setSa_id(Integer sa_id) {
        this.sa_id = sa_id;
    }

    public Double getSa_salary() {
        return sa_salary;
    }

    public void setSa_salary(Double sa_salary) {
        this.sa_salary = sa_salary;
    }

    public Integer getSa_sid() {
        return sa_sid;
    }

    public void setSa_sid(Integer sa_sid) {
        this.sa_sid = sa_sid;
    }

    public String getSa_myd() {
        return sa_myd;
    }

    public void setSa_myd(String sa_myd) {
        this.sa_myd = sa_myd;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sa_id=" + sa_id +
                ", sa_salary=" + sa_salary +
                ", sa_sid=" + sa_sid +
                ", sa_myd='" + sa_myd + '\'' +
                '}';
    }
}
