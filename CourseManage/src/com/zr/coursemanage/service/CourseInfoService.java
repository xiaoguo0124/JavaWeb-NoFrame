package com.zr.coursemanage.service;

import java.util.List;

import com.zr.coursemanage.entity.CourseInfo;

public interface CourseInfoService {
	//获取全部信息
	List<CourseInfo> getAllCourseInfo();
	
	//查询
	List<CourseInfo> getCourseInfo(CourseInfo courseinfo);
	
	//添加
	int addCourseInfo(CourseInfo courseinfo);
	
	//删除
	int delCourseInfo(String cno);
	
	//修改
	int upCourseInfo(CourseInfo courseinfo);
}
