package com.iotek.dao;

import com.iotek.model.Departement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    List<Departement> queryAllDepartment();
    boolean addDepartment(Departement departement);
    Departement queryThisDepart(@Param("de_id") Integer de_id);
    boolean delDepartmentBydeid(Integer de_id);
    boolean updateDepartmentCOUNT(Departement departement);
    Departement queryforname(Departement departement);
    boolean updatedename(Departement departement);
}
