package com.iotek.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private String a_name;
    private Integer a_id;
    private String a_pass;

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_pass() {
        return a_pass;
    }

    public void setA_pass(String a_pass) {
        this.a_pass = a_pass;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_name='" + a_name + '\'' +
                ", a_id=" + a_id +
                ", a_pass='" + a_pass + '\'' +
                '}';
    }
}
