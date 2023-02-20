package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MemberVO;

@Controller
public class MemberController {
	@RequestMapping("member/insert.do")
	public String member_insert(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {}
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		vo.setAddress(address);
		vo.setTel(tel);
		
		request.setAttribute("vo", vo);
		return "member/insert_ok";
	}
	
	@RequestMapping("member/insert2.do") // GET/POST동시에 처리
	/*
	 *   public void addAtttribute(String key, Object obj) {
	 *   	request.setAttribute(key, obj)
	 *   }
	 */
	// request를 필요한 경우가 아니면 가급적 사용 금지 (클라이언트 ip가 있어서)
	public String member_insert2(MemberVO vo, Model model) {
		// 전송 객체 => Model안에 request가 있다 = request.setAttribute("vo", vo);
		model.addAttribute("vo",vo);
		return "member/insert_ok2";
	}
}
