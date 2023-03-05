package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.JejuDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.JejuFoodVO;

@RestController
public class JejuRestController {
	@Autowired
	private JejuDAO dao;

	@GetMapping(value= "jeju/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list_vue(String page) {
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		
		List<JejuFoodVO> list = dao.jejuFoodListData(map);
		JSONArray arr = new JSONArray();
		int i = 0;
		for(JejuFoodVO vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("no", vo.getNo());
			obj.put("poster", vo.getPoster());
			obj.put("title", vo.getTitle());
			arr.add(obj);
		}
		return arr.toJSONString();
	}
	
	@RequestMapping(value="jeju/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_detail_vue(int no) {
		
		   JejuFoodVO vo=dao.jejuDetailData(no);
		   JSONObject obj=new JSONObject();
		   /*
		    * private int no, hit;
			  private String title, url, poster, image, addr, addr2, tel, type, parking, time, menu, score;
		    */
		   obj.put("no", vo.getNo());
		   obj.put("title", vo.getTitle());
		   obj.put("score", vo.getScore());
		   obj.put("poster", vo.getPoster());
		   obj.put("tel", vo.getTel());
		   obj.put("type", vo.getType());
		   obj.put("parking", vo.getParking());
		   obj.put("addr",vo.getAddr());
		   obj.put("addr2",vo.getAddr2());
		   obj.put("menu", vo.getMenu());
		   obj.put("time", vo.getTime());
		   
		   return obj.toJSONString();
	}
}
