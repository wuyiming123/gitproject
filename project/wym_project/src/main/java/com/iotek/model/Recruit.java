package com.iotek.model;

import java.io.Serializable;

/**
招聘信息
 */
public class Recruit implements Serializable {
    private Integer ri_id;
    private String ri_department;//部门
    private String ri_position;//招聘位置
    private Integer ri_salary;//薪资
    private String ri_requirement;//招聘要求
    private String ri_information;//详细描述
    private String ri_ison;//发布状态

    public Recruit() {
    }

    public Integer getRi_id() {
        return ri_id;
    }

    public void setRi_id(Integer ri_id) {
        this.ri_id = ri_id;
    }

    public String getRi_department() {
        return ri_department;
    }

    public void setRi_department(String ri_department) {
        this.ri_department = ri_department;
    }

    public String getRi_position() {
        return ri_position;
    }

    public void setRi_position(String ri_position) {
        this.ri_position = ri_position;
    }

    public Integer getRi_salary() {
        return ri_salary;
    }

    public void setRi_salary(Integer ri_salary) {
        this.ri_salary = ri_salary;
    }

    public String getRi_requirement() {
        return ri_requirement;
    }

    public void setRi_requirement(String ri_requirement) {
        this.ri_requirement = ri_requirement;
    }

    public String getRi_information() {
        return ri_information;
    }

    public void setRi_information(String ri_information) {
        this.ri_information = ri_information;
    }

    public String getRi_ison() {
        return ri_ison;
    }

    public void setRi_ison(String ri_ison) {
        this.ri_ison = ri_ison;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "ri_id=" + ri_id +
                ", ri_department='" + ri_department + '\'' +
                ", ri_position='" + ri_position + '\'' +
                ", ri_salary=" + ri_salary +
                ", ri_requirement='" + ri_requirement + '\'' +
                ", ri_information='" + ri_information + '\'' +
                ", ri_ison='" + ri_ison + '\'' +
                '}';
    }
}
