package com.zr.coursemanage.service;

import java.util.List;

import com.zr.coursemanage.entity.StuInfo;

public interface StuInfoService {
	//获取全部信息
	List<StuInfo> getStuInfoAll();
	
	//查询
	List<StuInfo> getStuInfo(StuInfo stuinfo);
	
	//添加
	int addStuInfo(StuInfo stuinfo);
	
	//删除
	int delStuInfo(String stuno);
	
	//修改
	int upStuInfo(StuInfo stuinfo);
	
	
}
