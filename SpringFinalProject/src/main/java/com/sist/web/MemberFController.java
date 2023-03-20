package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MemberDAO;

@Controller
@RequestMapping("member/")
public class MemberFController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("join.do")
	public String member_join() {
		
		return "member/join";
	}
}
