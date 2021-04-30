package com.zr.coursemanage.service;

import java.util.List;

import com.zr.coursemanage.dao.StuScoreDao;
import com.zr.coursemanage.entity.StuScore;

public class StuScoreServiceImp implements StuScoreService{

	StuScoreDao sd=new StuScoreDao();
	
	@Override
	public List<StuScore> getAllStuScore() {
		return sd.getAllStuScore();
	}

	@Override
	public List<StuScore> getStuScore(StuScore stuscore) {
		return sd.getStuScore(stuscore);
	}

	@Override
	public int addStuScore(StuScore stuscore) {
		return sd.addStuScore(stuscore);
	}

	@Override
	public int delStuScore(StuScore stuscore) {
		return sd.delStuScore(stuscore);
	}

	@Override
	public int upStuScore(StuScore stuscore) {
		return sd.upStuScore(stuscore);
	}

}
