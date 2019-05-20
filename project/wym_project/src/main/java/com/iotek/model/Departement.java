package com.iotek.model;

import java.io.Serializable;

public class Departement implements Serializable {
    private Integer de_id;
    private String de_time;
    private String de_name;
    private Integer de_stcount;

    public Departement() {
    }

    public Integer getDe_id() {
        return de_id;
    }

    public void setDe_id(Integer de_id) {
        this.de_id = de_id;
    }

    public String getDe_name() {
        return de_name;
    }

    public void setDe_name(String de_name) {
        this.de_name = de_name;
    }

    public String getDe_time() {
        return de_time;
    }

    public void setDe_time(String de_time) {
        this.de_time = de_time;
    }

    public Integer getDe_stcount() {
        return de_stcount;
    }

    public void setDe_stcount(Integer de_stcount) {
        this.de_stcount = de_stcount;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "de_id=" + de_id +
                ", de_time='" + de_time + '\'' +
                ", de_name='" + de_name + '\'' +
                '}';
    }
}
