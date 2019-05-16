package com.iotek.service.impl;

import com.iotek.dao.AdminDao;
import com.iotek.model.Admin;
import com.iotek.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Admin adminlog(Admin admin) {
        if(admin!=null){
            return adminDao.adminlog(admin);
        }else {
            return null;
        }
    }
}
