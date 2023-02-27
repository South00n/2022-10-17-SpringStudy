package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	//include / forward => request를 공유
	@GetMapping("food/food_list.do")
	public String food_list(int cno, Model model) { // DispatcherServlet에서 호출 => 매개변수에 값을 채워서 호출
		List<FoodVO> fList = dao.foodListData(cno);
		for(FoodVO vo : fList) {
			String address = vo.getAddress();
			address = address.substring(0, address.lastIndexOf("지"));
			vo.setAddress(address.trim());
			
			String poster = vo.getPoster();
			poster = poster.substring(0, poster.indexOf("^"));
			poster = poster.replace("#", "&");
			vo.setPoster(poster);
		}
		
		CategoryVO vo = dao.categoryInfoData(cno);
		model.addAttribute("vo", vo);
		model.addAttribute("fList",fList);
		model.addAttribute("main_jsp", "../food/food_list.jsp");
		return "main/main";
	}
	
	//food/detail.do?fno=${fvo.fno }
	@GetMapping("food/detail.do")
	public String food_detail(int fno, Model model) {
		// DAO 연동
		FoodVO vo = dao.foodDetailData(fno);
		String[] addrs = vo.getAddress().split(" ");
		
		model.addAttribute("addr", addrs[1].trim());
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../food/detail.jsp");
		return "main/main";
	}
}
