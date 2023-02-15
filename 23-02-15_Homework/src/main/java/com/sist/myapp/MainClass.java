package com.sist.myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.GoodsConfig;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Component
public class MainClass {
	
	@Autowired
	private GoodsDAO dao;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		ApplicationContext app =
				new ClassPathXmlApplicationContext("app.xml");
		*/
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(GoodsConfig.class);
		System.out.println("============ 상품메뉴 =============");
		System.out.println("1. All");
		System.out.println("2. Best");
		System.out.println("3. New");
		System.out.println("4. Special");
		System.out.println("=================================");
		
		String[] table = {"", "ALL", "BEST", "NEW", "SPECIAL"};
		System.out.print("메뉴를 선택하세요 : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int menu = Integer.parseInt(br.readLine());
		
		Map map = new HashMap();
		map.put("goods_tbl", "goods_"+ table[menu]);
		MainClass mc = app.getBean("mainClass", MainClass.class);
		
		List<GoodsVO> list = mc.dao.GoodsListData(map);
		
		for(GoodsVO vo : list) {
			bw.write(vo.getNo() + "." + vo.getName() + " (" + vo.getPrice() + ")");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
