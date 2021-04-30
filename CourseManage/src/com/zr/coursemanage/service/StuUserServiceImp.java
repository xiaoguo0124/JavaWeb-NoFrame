package com.zr.coursemanage.service;

import com.zr.coursemanage.dao.StuUserDao;
import com.zr.coursemanage.entity.StuUser;

public class StuUserServiceImp implements StuUserService {
	StuUserDao su=new StuUserDao();
	
	@Override
	public boolean getStuUser(StuUser stuuser){
		return su.getStuUser(stuuser);
	}

	@Override
	public int addStuUser(StuUser stuuser) {
		return su.addStuUser(stuuser);
	}
	
}
