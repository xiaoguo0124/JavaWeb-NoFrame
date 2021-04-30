package com.zr.coursemanage.service;

import com.zr.coursemanage.dao.AdminDao;
import com.zr.coursemanage.entity.Admin;

public class AdminServiceImp implements AdminService{
	AdminDao ad=new AdminDao();
	
	@Override
	public boolean getAdmin(Admin admin) {
		return ad.getAdmin(admin);
	}

	@Override
	public int addAdmin(Admin admin) {
		return ad.addAdmin(admin);
	}

}
