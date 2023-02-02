package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbooRepository;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbooRepository guestbookRepository;
	

	@RequestMapping("/")
	public String list(Model model) {				
		List<GuestBookVo> list = guestbookRepository.findAll();
		model.addAttribute("list",list);
		return "/WEB-INF/views/list.jsp";
	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String add(GuestBookVo vo) {	
		guestbookRepository.insert(vo);		
		return "redirect:/";
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String delete(String no,Model model) {	
		model.addAttribute("no",no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String delete(int no,String password) {	
		boolean result =guestbookRepository.delete(no, password);
		return "redirect:/";
	}
	
}
