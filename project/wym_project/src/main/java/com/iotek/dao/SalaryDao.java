package com.iotek.dao;

import com.iotek.model.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryDao {
    List<Salary> queryAllSalary(@Param("sd_id") Integer sd_id);
    List<Salary> queryAllSalaryBystate(@Param("sd_id") Integer sd_id,@Param("sd_state") String sd_state);
    boolean addShangYiGeMonth(Salary salary);
    boolean updateShangYiGeMonth(Salary salary);
    boolean updatestate(Salary salary);
    Salary querybystate(Salary salary);
    Salary queryById(@Param("sa_id") Integer sa_id);
}
