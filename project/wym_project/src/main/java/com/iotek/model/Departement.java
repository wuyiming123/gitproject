package com.iotek.model;

import java.io.Serializable;

public class Departement implements Serializable {
    private Integer de_id;
    private Integer de_poid;
    private String de_time;

    public Departement() {
    }

    public Integer getDe_id() {
        return de_id;
    }

    public void setDe_id(Integer de_id) {
        this.de_id = de_id;
    }

    public Integer getDe_poid() {
        return de_poid;
    }

    public void setDe_poid(Integer de_poid) {
        this.de_poid = de_poid;
    }

    public String getDe_time() {
        return de_time;
    }

    public void setDe_time(String de_time) {
        this.de_time = de_time;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "de_id=" + de_id +
                ", de_poid=" + de_poid +
                ", de_time='" + de_time + '\'' +
                '}';
    }
}
