package com.hyundai.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.MemberRole;
import com.hyundai.board.domain.MemberVO;

@SpringBootTest
public class MemberServiceTest {
	@Autowired
	private MemberService memberService;
	
	@Test
	public void insertMemberTest() {
		MemberVO memberVO = new MemberVO();
		MemberVO vo = new MemberVO();
		vo.setMid("test@email.com");
		vo.setMname("test");
		vo.setMpassword("test" );
		vo.setFromsocial(0);
	
		vo.setMrole(MemberRole.USER);
		
		int rows = memberService.insertMember(memberVO);
		System.out.println(rows);
	}
}
