package com.sist.myapp;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.EmpConfig;
import com.sist.dao.*;
// 클래스와 클래스간의 상호 연결 => XML
public class MainClass {
	// 주입 => 스프링에서 생성후에 주입 => 자동 주입 요청 => @Autowired
	private EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ApplicationContext app =
				new ClassPathXmlApplicationContext("app.xml");*/
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(EmpConfig.class);
		MainClass mc = (MainClass)app.getBean("mc");
		List<EmpVO> list = mc.dao.empListData();
		for(EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + " " + vo.getJob());
		}
	}

}
