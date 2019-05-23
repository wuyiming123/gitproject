package com.iotek.model;

import java.io.Serializable;

/*
员工详情信息
 */
public class StaffDetail implements Serializable {
    private Integer sd_id;
    private String sd_tname;
    private Integer sd_deid;//部门ID
    private Integer sd_poid;//职位id
    private Integer sd_tsalary;
    private String sd_taddress;
    private String sd_tphone;
    private String sd_tsex;
    private String sd_time;
    private String sd_card;
    private Integer sd_state;

    public StaffDetail() {
    }

    public Integer getSd_state() {
        return sd_state;
    }

    public void setSd_state(Integer sd_state) {
        this.sd_state = sd_state;
    }

    public String getSd_card() {
        return sd_card;
    }

    public void setSd_card(String sd_card) {
        this.sd_card = sd_card;
    }

    public Integer getSd_id() {
        return sd_id;
    }

    public void setSd_id(Integer sd_id) {
        this.sd_id = sd_id;
    }

    public String getSd_tname() {
        return sd_tname;
    }

    public void setSd_tname(String sd_tname) {
        this.sd_tname = sd_tname;
    }

    public Integer getSd_deid() {
        return sd_deid;
    }

    public void setSd_deid(Integer sd_deid) {
        this.sd_deid = sd_deid;
    }

    public Integer getSd_poid() {
        return sd_poid;
    }

    public void setSd_poid(Integer sd_poid) {
        this.sd_poid = sd_poid;
    }

    public Integer getSd_tsalary() {
        return sd_tsalary;
    }

    public void setSd_tsalary(Integer sd_tsalary) {
        this.sd_tsalary = sd_tsalary;
    }

    public String getSd_taddress() {
        return sd_taddress;
    }

    public void setSd_taddress(String sd_taddress) {
        this.sd_taddress = sd_taddress;
    }

    public String getSd_tphone() {
        return sd_tphone;
    }

    public void setSd_tphone(String sd_tphone) {
        this.sd_tphone = sd_tphone;
    }

    public String getSd_tsex() {
        return sd_tsex;
    }

    public void setSd_tsex(String sd_tsex) {
        this.sd_tsex = sd_tsex;
    }

    public String getSd_time() {
        return sd_time;
    }

    public void setSd_time(String sd_time) {
        this.sd_time = sd_time;
    }

    @Override
    public String toString() {
        return "StaffDetail{" +
                "sd_id=" + sd_id +
                ", sd_tname='" + sd_tname + '\'' +
                ", sd_deid=" + sd_deid +
                ", sd_poid=" + sd_poid +
                ", sd_tsalary=" + sd_tsalary +
                ", sd_taddress='" + sd_taddress + '\'' +
                ", sd_tphone='" + sd_tphone + '\'' +
                ", sd_tsex='" + sd_tsex + '\'' +
                ", sd_time='" + sd_time + '\'' +
                ", sd_card='" + sd_card + '\'' +
                '}';
    }
}
