package com.sist.myapp;

public class MainClass {
	
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		StudentVO vo = new StudentVO();
		vo.setHakbun(8);
		vo.setName("이순신");
		vo.setKor(100);
		vo.setEng(89);
		vo.setMath(90);
		
		StudentVO vo1 = new StudentVO();
		vo1.setHakbun(9);
		vo1.setName("춘향이");
		vo1.setKor(90);
		vo1.setEng(90);
		vo1.setMath(90);
		
		dao.studentInsert(vo, vo1);
	}
}
