package com.hyundai.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.MemberRole;
import com.hyundai.board.domain.MemberUserDetails;
import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.service.BoardService;
import com.hyundai.board.service.MemberService;

@Controller
@RequestMapping(value="member/*")
public class MemberController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberService memberService;
	@Autowired
	private BoardService boardService;
	
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
	
	//고석준작성 
	@RequestMapping(value="/mypage")
	public String mypage(@AuthenticationPrincipal MemberUserDetails memberUserDetails,
			Model model) {
		
		System.out.println("사용자 이름 : " + memberUserDetails.getMname());
		
		model.addAttribute("username", memberUserDetails.getMemail());
		
		BoardVO boardVO = new BoardVO();
		boardVO.setMid( memberUserDetails.getMemail());
		
		List<BoardVO> boardList = boardService.selectMemberBoard(boardVO);
		model.addAttribute("boardlist", boardList);
		
		
		return "mypage";
	}
	
	
}