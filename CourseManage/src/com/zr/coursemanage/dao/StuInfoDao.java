package com.zr.coursemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.coursemanage.entity.StuInfo;

public class StuInfoDao {
	BaseDao db=new BaseDao();
	
	public List<StuInfo> getStuInfoAll(){
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		
		String sql="select stuno,stuname,stusex,stuage,stucourse from stuinfo";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			List<StuInfo> stulist=new ArrayList<StuInfo>();
			while(rs.next()){
				StuInfo stu=new StuInfo();
				stu.setStuno(rs.getString(1));
				stu.setStuname(rs.getString(2));
				stu.setStusex(rs.getString(3));
				stu.setStuage(rs.getInt(4));
				stu.setStucourse(rs.getString(5));
				stulist.add(stu);
			}
			return stulist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询
	public List<StuInfo> getStuInfo(StuInfo stuinfo){
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		ArrayList arr=new ArrayList();
		
		String sql="select stuno,stuname,stusex,stuage,stucourse from stuinfo where 1=1 ";
		if(!stuinfo.getStuno().equals("")) {
			sql=sql+" and stuno=? ";
			arr.add(stuinfo.getStuno());
		}
		if(!stuinfo.getStuname().equals("")) {
			sql=sql+" and stuname like '%"+stuinfo.getStuname()+"%' ";
		}
		if(!stuinfo.getStusex().equals("")) {
			sql=sql+" and stusex=? ";
			arr.add(stuinfo.getStusex());
		}
		if(!stuinfo.getStucourse().equals("undefined")) {
			sql=sql+" and stucourse like '%"+stuinfo.getStucourse()+"%' ";
		}
		
		try {
			pstmt=conn.prepareStatement(sql);
			for (int i = 0; i < arr.size() ; i++) {
				pstmt.setObject(i+1, arr.get(i));
			}
			
			ResultSet rs=pstmt.executeQuery();
			List<StuInfo> stulist=new ArrayList<StuInfo>();
			while(rs.next()){
				StuInfo s=new StuInfo();
				s.setStuno(rs.getString(1));
				s.setStuname(rs.getString(2));
				s.setStusex(rs.getString(3));
				s.setStuage(rs.getInt(4));
				s.setStucourse(rs.getString(5));
				
				stulist.add(s);
			}
			return stulist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	public int addStuInfo(StuInfo stuinfo) {
		String sql="insert into stuinfo value(?,?,?,?,?)";
		
		ArrayList list=new ArrayList();
		list.add(stuinfo.getStuno());
		list.add(stuinfo.getStuname());
		list.add(stuinfo.getStusex());
		list.add(stuinfo.getStuage());
		list.add(stuinfo.getStucourse());
		
		return db.doExc(sql, list);
	}
	
	//删除
	public int delStuInfo(String stuno) {
		String sql="delete from stuinfo where stuno=?";
		
		ArrayList list=new ArrayList();
		list.add(stuno);
		
		return db.doExc(sql, list);
	}
	
	//修改
	public int upStuInfo(StuInfo stuinfo) {
		String sql="update stuinfo set stuname=?,stusex=?,stuage=?,stucourse=? where stuno=?";
		
		ArrayList list=new ArrayList();
		list.add(stuinfo.getStuname());
		list.add(stuinfo.getStusex());
		list.add(stuinfo.getStuage());
		list.add(stuinfo.getStucourse());
		list.add(stuinfo.getStuno());
		
		return db.doExc(sql, list);
		
	}
	
	
}
