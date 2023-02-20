package com.sist.dao;

public class MovieDAO {
	public void getConnection() {
		System.out.println("오라클 연결..");
	}
	public void disConnection() {
		System.out.println("오라클 닫기");
	}
	public void select() {
		getConnection(); //===========================
		System.out.println("SELECT문장 수행"); // 핵심 모듈
		disConnection(); //=========================== 공톨뮤둘 (반복)
	}
	public void insert() {
		getConnection();
		System.out.println("INSERT문장 수행");
		disConnection();
	}
	public void update() {
		getConnection();
		System.out.println("UPDATE문장 수행");
		disConnection();
		
	}
	public void delete() {
		getConnection();
		System.out.println("UdPDATE문장 수행");
		disConnection();
	}
}
