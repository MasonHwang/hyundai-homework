package com.hyundai.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="member/*")
public class MemberController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpSession httpSession)throws Exception {
		return "loginform";
	}
}