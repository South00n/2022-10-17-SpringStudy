package com.sist.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String seoul_list(String page, Model model, HttpServletRequest request) {
		
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
		// 쿠키관련
		List<SeoulLocationVO> cList = new ArrayList<SeoulLocationVO>();
		// 쿠키 관련
		// 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = cookies.length-1; i>=0; i--) {
				if(cookies[i].getName().startsWith("seoul")) {
					String no = cookies[i].getValue();
					SeoulLocationVO vo = dao.seoulDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		model.addAttribute("cList", cList);
		return "seoul/list";
	}
	
	@GetMapping("seoul/detail_before.do")
	public String jeju_detail_before(int no, HttpServletResponse response, RedirectAttributes ra) {
		
		Cookie cookie = new Cookie("seoul"+no, String.valueOf(no)); // 스트링변환
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		// 브라우저로 전송
		response.addCookie(cookie);
		
		ra.addAttribute("no", no);
		// return "redirect:detail.do?no="+no; 

		return "redirect:detail.do";
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
