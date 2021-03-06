package com.iotek.service;

import com.iotek.model.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryService {
    List<Salary> queryAllSalary(Integer sd_id);
    boolean addShangYiGeMonth(Salary salary);
    boolean updateShangYiGeMonth(Salary salary);
    boolean updatestate(Salary salary);
    Salary querybystate(Salary salary);
    Salary queryById(Integer sa_id);
    List<Salary> queryAllSalaryBystate(Integer sd_id,String sd_state);
    Salary querySalary_By_Month(Integer sa_sdid,Integer month);
    List<Salary> queryall(Integer sa_sdid,String sa_state,Integer month);
}
