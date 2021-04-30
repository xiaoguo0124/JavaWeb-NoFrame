package com.zr.coursemanage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDao {
	
	public Connection getConn() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/coursemanage";
		String uroot="root";
		String upwd="123456";
		try {
			conn=DriverManager.getConnection(url, uroot, upwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int doExc(String sql, ArrayList list) {
		Connection conn=getConn();
		PreparedStatement pstmt=null;
		int num=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			for (int i = 0; i <list.size() ; i++) {
				pstmt.setObject(i+1, list.get(i));
			}
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		daoClose(conn,pstmt);
		return num;
	}
	
	public void daoClose(Connection conn, PreparedStatement pstmt) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
