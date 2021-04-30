package com.zr.coursemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zr.coursemanage.entity.StuUser;

public class StuUserDao {
	BaseDao db=new BaseDao();
	
	//登录
	public boolean getStuUser(StuUser stuuser) {
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		
		String sql="SELECT * FROM stuuser WHERE (stuno=? OR stuname=?) AND stupwd=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, stuuser.getStuno());
			pstmt.setString(2, stuuser.getStuname());
			pstmt.setString(3, stuuser.getStupwd());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//注册
	public int addStuUser(StuUser stuuser) {
		String sql="insert into stuuser values(?,?,?)";
		ArrayList alist=new ArrayList();
		alist.add(stuuser.getStuno());
		alist.add(stuuser.getStuname());
		alist.add(stuuser.getStupwd());
		
		return db.doExc(sql, alist);
		
	}
	

}
