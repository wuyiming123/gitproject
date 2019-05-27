package com.iotek.service.impl;

import com.iotek.dao.SalaryDao;
import com.iotek.model.Salary;
import com.iotek.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private SalaryDao salaryDao;

    public SalaryDao getSalaryDao() {
        return salaryDao;
    }

    public void setSalaryDao(SalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }


    public List<Salary> queryAllSalary(Integer sd_id) {
        if(sd_id!=null){
            return salaryDao.queryAllSalary(sd_id);
        }return null;
    }

    public boolean addShangYiGeMonth(Salary salary) {
        if(salary!=null){
            return salaryDao.addShangYiGeMonth(salary);
        }return false;
    }

    public boolean updateShangYiGeMonth(Salary salary) {
        if(salary!=null){
            return salaryDao.updateShangYiGeMonth(salary);
        }return false;
    }

    public boolean updatestate(Salary salary) {
        if(salary!=null){
            return salaryDao.updatestate(salary);
        }return false;
    }

    public Salary querybystate(Salary salary) {
        if(salary!=null){
            return salaryDao.querybystate(salary);
        }return null;
    }

    public Salary queryById(Integer sa_id) {
        if(sa_id!=null){
            return salaryDao.queryById(sa_id);
        }
        return null;
    }

    public List<Salary> queryAllSalaryBystate(Integer sd_id, String sd_state) {
        return salaryDao.queryAllSalaryBystate(sd_id,sd_state);
    }

    public Salary querySalary_By_Month(Integer sa_sdid, Integer month) {
        if(sa_sdid!=null){
            return salaryDao.querySalary_By_Month(sa_sdid,month);
        }
        return null;
    }

    public List<Salary> queryall(Integer sa_sdid, String sa_state, Integer month) {
        return salaryDao.queryall(sa_sdid,sa_state,month);
    }
}
