package com.hyundai.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyundai.board.domain.MemberRole;
import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.service.MemberService;

@Controller
@RequestMapping(value="member/*")
public class MemberController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpSession httpSession)throws Exception {
		return "loginform";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(HttpSession httpSession)throws Exception {
		return "signupform";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute MemberVO memberVO) {
		memberVO.setMpassword(passwordEncoder.encode(memberVO.getMpassword()));
		memberVO.setFromsocial(0);
		memberVO.setMrole(MemberRole.USER);
		int result = memberService.insertMember(memberVO);
		if(result != 1) {
			return "redirect:/member/signup";
		}
		return "redirect:/member/login";
	}
	
	
}