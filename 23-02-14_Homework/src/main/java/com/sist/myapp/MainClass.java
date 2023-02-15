package com.sist.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.DeptDAO;
import com.sist.dao.DeptVO;

public class MainClass {
	
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app =
				new ClassPathXmlApplicationContext("application-datasource.xml");
		
		MainClass main = (MainClass)app.getBean("main");
		List<DeptVO> list = main.dao.deptListData();
		for(DeptVO vo : list) {
			System.out.println(vo.getDeptno() + " " + vo.getDname() + " " + vo.getLoc());
		}
		
		DeptVO vo = main.dao.deptDetailData(20);
		System.out.println(vo.getDeptno() + " " + vo.getDname() + " " + vo.getLoc());
	}

}
