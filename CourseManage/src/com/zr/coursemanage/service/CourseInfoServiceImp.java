package com.zr.coursemanage.service;

import java.util.List;

import com.zr.coursemanage.dao.CourseInfoDao;
import com.zr.coursemanage.entity.CourseInfo;

public class CourseInfoServiceImp implements CourseInfoService{

	CourseInfoDao cd=new CourseInfoDao();
	@Override
	public List<CourseInfo> getAllCourseInfo() {
		return cd.getAllCourseInfo();
	}

	@Override
	public List<CourseInfo> getCourseInfo(CourseInfo courseinfo) {
		return cd.getCourseInfo(courseinfo);
	}

	@Override
	public int addCourseInfo(CourseInfo courseinfo) {
		return cd.addCourseInfo(courseinfo);
	}

	@Override
	public int delCourseInfo(String cno) {
		return cd.delCourseInfo(cno);
	}

	@Override
	public int upCourseInfo(CourseInfo courseinfo) {
		return cd.upCourseInfo(courseinfo);
	}
	
	
}
