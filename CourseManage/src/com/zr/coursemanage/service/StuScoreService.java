package com.zr.coursemanage.service;

import java.util.List;

import com.zr.coursemanage.entity.StuScore;

public interface StuScoreService {
	//获取全部学生成绩信息
	List<StuScore> getAllStuScore();
	
	//查询
	List<StuScore> getStuScore(StuScore stuscore);
	
	//添加
	int addStuScore(StuScore stuscore);
	
	//删除
	int delStuScore(StuScore stuscore);
		
	//修改
	int upStuScore(StuScore stuscore);
	
}
