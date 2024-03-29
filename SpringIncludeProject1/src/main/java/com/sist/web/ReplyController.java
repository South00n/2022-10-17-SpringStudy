package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class ReplyController {
   private String[] url = {"", "../food/detail.do", "../jeju/food_detail.do"};
   @Autowired
   private ReplyDAO dao;
   
   @PostMapping("reply/insert.do")
   // forward => Model , redirect => RedirectAttributes
   public String reply_insert(ReplyVO vo,RedirectAttributes ra,HttpSession session)
   {
	   // 객체 단위 => 커맨드 객체 
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   dao.replyInsert(vo);
	   ra.addAttribute("fno", vo.getRno());
	   ra.addAttribute("type", vo.getType());
	   return "redirect:"+url[vo.getType()];
   }
   
   @GetMapping("reply/delete.do")
   public String reply_delete(ReplyVO vo, RedirectAttributes ra) {
	   dao.replyDelete(vo.getNo());
	   ra.addAttribute("fno", vo.getRno());
	   ra.addAttribute("type", vo.getType());
	   return "redirect:"+url[vo.getType()];
   }
   
   @PostMapping("reply/update.do")
   public String reply_update(ReplyVO vo, RedirectAttributes ra) {
	   
	   dao.replyUpdate(vo.getNo(), vo.getMsg());
	   ra.addAttribute("fno", vo.getRno());
	   ra.addAttribute("type", vo.getType());
	   return "redirect:"+url[vo.getType()];
   }
}