package com.sist.myapp;

import java.sql.*;

public class StudentDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
		
	}
	public void getConnection() {
		try {
			conn= DriverManager.getConnection(url, "hr", "happy");
		} catch (Exception e) {}
	}
	public void disConnection() {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	public void studentInsert(StudentVO svo1, StudentVO svo2) {
		try {
			getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, svo1.getHakbun());
			ps.setString(2, svo1.getName());
			ps.setInt(3, svo1.getKor());
			ps.setInt(4, svo1.getEng());
			ps.setInt(5, svo1.getMath());
			ps.executeUpdate();
			
			sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, svo2.getHakbun());
			ps.setString(2, svo2.getName());
			ps.setInt(3, svo2.getKor());
			ps.setInt(4, svo2.getEng());
			ps.setInt(5, svo2.getMath());
			ps.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {}
			disConnection();
		}
	}
}















