package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.SeoulDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.JejuLocationVO;
import com.sist.vo.SeoulLocationVO;

@Controller
public class SeoulController {
	@Autowired
	private SeoulDAO dao;
	
	@GetMapping("seoul/list.do")
	public String seoul_list(String page, Model model) {
		
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 20;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;
		map.put("start", start);
		map.put("end", end);
				
		List<SeoulLocationVO> list = dao.seoulListData(map);
		for(SeoulLocationVO vo : list) {
			String title = vo.getTitle();
			if(title.length() > 19) {
				title = title.substring(0, 16)+ "...";
				vo.setTitle(title);
			}
			vo.setTitle(title);
		}
		int totalpage = dao.seoulTotalPage();
		
		final int BLOCK = 5;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "seoul/list";
	}
	
	@GetMapping("seoul/detail.do")
	public String seoulDetailData(int no, Model model) {
		
		SeoulLocationVO vo = dao.seoulDetailData(no);
		
		String addr = vo.getAddress();
		String[] addrs = addr.split(" ");
		Map map = new HashMap();
		map.put("addr", addrs[2].trim());
		
		List<FoodVO> list = dao.SeoulFoodData(map);
		model.addAttribute("list", list);
		
		model.addAttribute("vo", vo);
		
		return "seoul/detail";
	}
	
}
