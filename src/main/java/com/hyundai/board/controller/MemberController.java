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
import com.hyundai.board.domain.Criteria;
import com.hyundai.board.domain.MemberRole;
import com.hyundai.board.domain.MemberUserDetails;
import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.domain.PageVO;
import com.hyundai.board.service.BoardService;
import com.hyundai.board.service.MemberService;

/**
 * @author 		: 황명하, 고석준
 * @fileName 	: MemberController.java
 * @date 		: 2022. 5. 16.
 * @description : 유저 관련 기능(로그인, 가입, 마이페이지)에 대한 컨트롤러
 */

@Controller
@RequestMapping(value="member/*")
public class MemberController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MemberService memberService;
	@Autowired
	private BoardService boardService;
	
	//로그인 페이지로 화면 이동 (황명하)
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpSession httpSession)throws Exception {
		return "loginform";
	}
	
	//회원가입 페이지로 화면 이동 (황명하)
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(HttpSession httpSession)throws Exception {
		return "signupform";
	}
	
	//회원가입 기능 수행 (황명하)
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
	
	//페이징이 적용된 내 게시글과 마이페이지 출력 (고석준)
	@RequestMapping(value="/mypage")
	public String mypage(Criteria criteria, @AuthenticationPrincipal MemberUserDetails memberUserDetails,
			Model model) {
		String mid = memberUserDetails.getMemail();
		System.out.println("사용자 아이디 : " + mid);
		
		model.addAttribute("username", memberUserDetails.getMname());		
		
		model.addAttribute("list", boardService.getMemberBoard(criteria, mid));
		model.addAttribute("pageMaker", new PageVO(boardService.getMemberTotal(mid), 10, criteria));
		return "mypage";
	}
}