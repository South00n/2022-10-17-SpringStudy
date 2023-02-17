package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;

import com.sist.config.BookConfig;
import com.sist.model.*;
import com.sist.service.JejuService;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;

@Component
public class MainClass {
	@Autowired
	private Model model;
	@Autowired
	private JejuService js;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(BookConfig.class);
		
		MainClass mc = (MainClass)app.getBean("mainClass");
		System.out.println("====== 제주 명소 ======");
		//JejuService js = (JejuService)app.getBean("jejuService");
		List<JejuLocationVO> list = mc.js.locationListData();
		for(JejuLocationVO vo : list) {
			System.out.println(vo.getTitle() + "(" + vo.getPrice() + ")");
		}
		System.out.println("====== 제주 맛집 ======");
		List<JejuFoodVO> list2 = mc.js.foodListData();
		for(JejuFoodVO vo:list2) {
			System.out.println(vo.getTitle() + "(" + vo.getScore() + ")");
		}
		/*System.out.println("======== 카테고리 ========");
		mc.model.bookCategory();
		System.out.println("=======================");
		Scanner sc = new Scanner(System.in);
		System.out.print("카테고리 선택 : ");
		int no = sc.nextInt();
		String[] cate = {
				"",
				"사회과학",
				"기술과학",
				"순수과학",
				"총류",
				"종교",
				"철학",
				"문학",
				"역사",
				"예술",
				"언어",
		};
		System.out.println("======== 실행 결과 =========");
		mc.model.bookListData(cate[no]);*/
	}
}
