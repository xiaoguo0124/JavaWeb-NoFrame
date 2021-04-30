package com.zr.coursemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.coursemanage.entity.StuScore;


public class StuScoreDao {
	BaseDao db=new BaseDao();
	
	public List<StuScore> getAllStuScore(){
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		
		String sql="select stuno, cname,stuscore from stuscore";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			List<StuScore> list=new ArrayList<StuScore>();
			while(rs.next()){
				StuScore s=new StuScore();
				s.setStuno(rs.getString(1));
				s.setCname(rs.getString(2));
				s.setStuscore(rs.getInt(3));
				
				list.add(s);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询
	public List<StuScore> getStuScore(StuScore stuscore){
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		ArrayList arr=new ArrayList();
		
		String sql="select * from stuscore where 1=1";
		if(!stuscore.getStuno().equals("")) {
			sql=sql+" and stuno=? ";
			arr.add(stuscore.getStuno());
		}
		if(!stuscore.getCname().equals("")) {
			sql=sql+" and cname like '%"+stuscore.getCname()+"%'";
		}
		if(stuscore.getStuscore()>0) {
			sql=sql+" and stuscore=? ";
			arr.add(stuscore.getStuscore());
		}
		
		try {
			pstmt=conn.prepareStatement(sql);
			for (int i = 0; i < arr.size() ; i++) {
				pstmt.setObject(i+1, arr.get(i));
			}
			
			ResultSet rs=pstmt.executeQuery();
			List<StuScore> list=new ArrayList<StuScore>();
			while(rs.next()){
				StuScore s=new StuScore();
				s.setStuno(rs.getString(1));
				s.setCname(rs.getString(2));
				s.setStuscore(rs.getInt(3));
				
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	public int addStuScore(StuScore stuscore) {
		String sql="insert into stuscore value(?,?,?)";
		
		ArrayList list=new ArrayList();
		list.add(stuscore.getStuno());
		list.add(stuscore.getCname());
		list.add(stuscore.getStuscore());
		
		return db.doExc(sql, list);
	}
	
	//删除
	public int delStuScore(StuScore stuscore) {
		String sql="delete from stuscore where stuno=? and cname=? and stuscore=?";
		
		ArrayList list=new ArrayList();
		list.add(stuscore.getStuno());
		list.add(stuscore.getCname());
		list.add(stuscore.getStuscore());
		return db.doExc(sql, list);
	}
	
	//修改
	public int upStuScore(StuScore stuscore) {
		String sql="update stuscore set stuno=?, cname=?, stuscore=? where stuno=? and cname=? and stuscore=? ";
		
		ArrayList list=new ArrayList();
		list.add(stuscore.getStuno());
		list.add(stuscore.getCname());
		list.add(stuscore.getStuscore());
		list.add(stuscore.getStuno());
		list.add(stuscore.getCname());
		list.add(stuscore.getStuscore());
		
		return db.doExc(sql, list);
		
	}
}
