package com.iotek.model;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer r_id;
    private String r_name;
    private String r_sex;
    private String r_birthday;
    private String r_nation;
    private String r_nativeplace;
    private String r_graduteschool;
    private String r_politics;
    private String r_major;
    private String r_education;
    private Integer r_zipcode;
    private Integer r_phone;
    private String r_email;
    private String r_address;
    private String r_evaluation;
    private Integer r_tid;

    public Resume() {
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_birthday() {
        return r_birthday;
    }

    public void setR_birthday(String r_birthday) {
        this.r_birthday = r_birthday;
    }

    public String getR_nation() {
        return r_nation;
    }

    public void setR_nation(String r_nation) {
        this.r_nation = r_nation;
    }

    public String getR_nativeplace() {
        return r_nativeplace;
    }

    public void setR_nativeplace(String r_nativeplace) {
        this.r_nativeplace = r_nativeplace;
    }

    public String getR_graduteschool() {
        return r_graduteschool;
    }

    public void setR_graduteschool(String r_graduteschool) {
        this.r_graduteschool = r_graduteschool;
    }

    public String getR_politics() {
        return r_politics;
    }

    public void setR_politics(String r_politics) {
        this.r_politics = r_politics;
    }

    public String getR_major() {
        return r_major;
    }

    public void setR_major(String r_major) {
        this.r_major = r_major;
    }

    public String getR_education() {
        return r_education;
    }

    public void setR_education(String r_education) {
        this.r_education = r_education;
    }

    public Integer getR_zipcode() {
        return r_zipcode;
    }

    public void setR_zipcode(Integer r_zipcode) {
        this.r_zipcode = r_zipcode;
    }

    public Integer getR_phone() {
        return r_phone;
    }

    public void setR_phone(Integer r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public String getR_address() {
        return r_address;
    }

    public void setR_address(String r_address) {
        this.r_address = r_address;
    }

    public String getR_evaluation() {
        return r_evaluation;
    }

    public void setR_evaluation(String r_evaluation) {
        this.r_evaluation = r_evaluation;
    }

    public Integer getR_tid() {
        return r_tid;
    }

    public void setR_tid(Integer r_tid) {
        this.r_tid = r_tid;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_sex='" + r_sex + '\'' +
                ", r_birthday='" + r_birthday + '\'' +
                ", r_nation='" + r_nation + '\'' +
                ", r_nativeplace='" + r_nativeplace + '\'' +
                ", r_graduteschool='" + r_graduteschool + '\'' +
                ", r_politics='" + r_politics + '\'' +
                ", r_major='" + r_major + '\'' +
                ", r_education='" + r_education + '\'' +
                ", r_zipcode=" + r_zipcode +
                ", r_phone=" + r_phone +
                ", r_email='" + r_email + '\'' +
                ", r_address='" + r_address + '\'' +
                ", r_evaluation='" + r_evaluation + '\'' +
                ", r_tid=" + r_tid +
                '}';
    }
}
