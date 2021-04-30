package com.zr.coursemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.coursemanage.entity.CourseInfo;


//课程信息
public class CourseInfoDao {
	BaseDao db=new BaseDao();
	
	public List<CourseInfo> getAllCourseInfo(){
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		
		String sql="select cno,cname,tno from courseinfo";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			List<CourseInfo> list=new ArrayList<CourseInfo>();
			while(rs.next()){
				CourseInfo ci=new CourseInfo();
				ci.setCno(rs.getString(1));
				ci.setCname(rs.getString(2));
				ci.setTno(rs.getString(3));
				list.add(ci);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询
	public List<CourseInfo> getCourseInfo(CourseInfo courseinfo){
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		ArrayList arr=new ArrayList();
		
		String sql="select * from CourseInfo where 1=1";
		if(!courseinfo.getCno().equals("")) {
			sql=sql+" and cno=? ";
			arr.add(courseinfo.getCno());
		}
		if(!courseinfo.getCname().equals("")) {
			sql=sql+" and cname like '%"+courseinfo.getCname()+"%'";
		}
		if(!courseinfo.getTno().equals("")) {
			sql=sql+" and tno=? ";
			arr.add(courseinfo.getTno());
		}
		
		try {
			pstmt=conn.prepareStatement(sql);
			for (int i = 0; i < arr.size() ; i++) {
				pstmt.setObject(i+1, arr.get(i));
			}
			
			ResultSet rs=pstmt.executeQuery();
			List<CourseInfo> list=new ArrayList<CourseInfo>();
			while(rs.next()){
				CourseInfo c=new CourseInfo();
				c.setCno(rs.getString(1));
				c.setCname(rs.getString(2));
				c.setTno(rs.getString(3));
				
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//添加
	public int addCourseInfo(CourseInfo courseinfo) {
		String sql="insert into courseinfo value(?,?,?)";
		
		ArrayList list=new ArrayList();
		list.add(courseinfo.getCno());
		list.add(courseinfo.getCname());
		list.add(courseinfo.getTno());
		
		return db.doExc(sql, list);
	}
	
	//删除
	public int delCourseInfo(String cno) {
		String sql="delete from courseinfo where cno=?";
		
		ArrayList list=new ArrayList();
		list.add(cno);
		
		return db.doExc(sql, list);
	}
	
	//修改
	public int upCourseInfo(CourseInfo courseinfo) {
		String sql="update courseinfo set cno=?, cname=?, tno=? where cno=?";
		
		System.out.println(sql);
		ArrayList list=new ArrayList();
		list.add(courseinfo.getCno());
		list.add(courseinfo.getCname());
		list.add(courseinfo.getTno());
		list.add(courseinfo.getCno());
		
		return db.doExc(sql, list);
		
	}
}
