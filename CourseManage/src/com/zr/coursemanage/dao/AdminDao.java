package com.zr.coursemanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zr.coursemanage.entity.Admin;

public class AdminDao {
	BaseDao db=new BaseDao();
	
	//管理员登录
	public boolean getAdmin(Admin admin) {
		Connection conn=db.getConn();
		PreparedStatement pstmt=null;
		
		String sql="select * from admin where user=? and upwd=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, admin.getUser());
			pstmt.setString(2, admin.getUpwd());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	//管理员注册
	public int addAdmin(Admin admin) {
		String sql="insert into admin values(?,?)";
		
		ArrayList list=new ArrayList();
		list.add(admin.getUser());
		list.add(admin.getUpwd());
		
		return db.doExc(sql, list);
		
	}
	
}
