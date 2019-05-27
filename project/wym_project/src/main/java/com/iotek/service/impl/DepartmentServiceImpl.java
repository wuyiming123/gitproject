package com.iotek.service.impl;

import com.iotek.dao.DepartmentDao;
import com.iotek.model.Departement;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    public List<Departement> queryAllDepartment() {
        return departmentDao.queryAllDepartment();
    }

    public boolean addDepartment(Departement departement) {
        if(departement!=null){
            return departmentDao.addDepartment(departement);
        }else {
            return false;
        }
    }

    public Departement queryThisDepart(Integer de_id) {
        if(de_id==null){
            return null;
        }else {
            return departmentDao.queryThisDepart(de_id);
        }
    }

    public boolean delDepartmentBydeid(Integer de_id) {
        if(de_id!=null){
            return departmentDao.delDepartmentBydeid(de_id);
        }
        return false;
    }

    public boolean updateDepartmentCOUNT(Departement departement) {
        if(departement!=null) {
            return departmentDao.updateDepartmentCOUNT(departement);
        }return false;
    }

    public Departement queryforname(Departement departement) {
        if(departement!=null){
            return departmentDao.queryforname(departement);
        }return null;
    }

    public boolean updatedename(Departement departement) {
        if(departement!=null){
            return departmentDao.updatedename(departement);
        }return false;
    }
}
