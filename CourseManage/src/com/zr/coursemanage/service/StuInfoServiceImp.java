package com.zr.coursemanage.service;

import java.util.List;

import com.zr.coursemanage.dao.StuInfoDao;
import com.zr.coursemanage.entity.StuInfo;

public class StuInfoServiceImp implements StuInfoService {
	StuInfoDao sd=new StuInfoDao();
	
	@Override
	public List<StuInfo> getStuInfoAll() {
		return sd.getStuInfoAll();
	}

	@Override
	public List<StuInfo> getStuInfo(StuInfo stuinfo) {
		return sd.getStuInfo(stuinfo);
	}
	
	@Override
	public int addStuInfo(StuInfo stuinfo) {
		return sd.addStuInfo(stuinfo);
	}

	@Override
	public int delStuInfo(String stuno) {
		return sd.delStuInfo(stuno);
	}

	@Override
	public int upStuInfo(StuInfo stuinfo) {
		return sd.upStuInfo(stuinfo);
	}

}
