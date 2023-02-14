package com.sist.myapp;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {
	private EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	public static void main(String[] args) {
		// 설정파일이 자바면 어노테이션컨피그~
		// 설정파일이 xml이면 얘
		ApplicationContext app =
				new ClassPathXmlApplicationContext("application-datasource.xml");
		MainClass mc = (MainClass)app.getBean("mc");
		List<EmpVO> list = mc.dao.empListData();
		for(EmpVO vo : list) {
			System.out.println(vo.getEmpno()+ " "
					+vo.getEname()+ " "
					+vo.getJob());
		}
		
		EmpVO vo = mc.dao.empDetailData(7788);
		System.out.println(vo.getEmpno()+ " "
				+vo.getEname()+ " "
				+vo.getJob());
	}
}
