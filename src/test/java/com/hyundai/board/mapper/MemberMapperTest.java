package com.hyundai.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.MemberVO;

@SpringBootTest
public class MemberMapperTest {
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void insertMemberTest() {
		int rows = 0;
		for(int i=1 ; i<=10 ; i++) {
			MemberVO vo = new MemberVO();
			vo.setMid("user"+i);
			vo.setMname("이름" +i);
			vo.setMpassword("password" + i);
			vo.setMemail("user" + i + "@email.com");
			if(i<9) {
				vo.setMrole("ROLE_MEMBER");
			}else {
				vo.setMrole("ROLE_ADMIN");
			}
			rows += memberMapper.insertMember(vo);
		}
		
		System.out.println("rows : " + rows);
	}
	
	@Test
	public void selectAllMemberTest() {
		List<MemberVO> list = memberMapper.selectAllMember();
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void updateMemberTest() {
		MemberVO updateVO = new MemberVO();
		updateVO.setMid("TEST");
		updateVO.setMname("TEST_UPDATE");
		updateVO.setMpassword("TEST_update");
		updateVO.setMenabled(0);
		updateVO.setMrole("ROLE_TEST_update");
		updateVO.setMemail("TEST");
		
		int rows = memberMapper.updateMember(updateVO);
		
		System.out.println("rows : "+ rows);
	}
	
	@Test
	public void deleteMemberTest() {
		MemberVO vo = new MemberVO();
		vo.setMid("TEST");
		vo.setMname("TEST_UPDATE");
		vo.setMpassword("TEST_update");
		vo.setMenabled(0);
		vo.setMrole("ROLE_TEST_update");
		vo.setMemail("TEST");
		
		int rows = memberMapper.deleteMember(vo);
		
		System.out.println("rows: "+ rows);
	}
	
	@Test
	public void selectMemberTest() {
		MemberVO vo = new MemberVO();
		vo.setMid("user1");
		vo.setMemail("user1@email.com");
		
		MemberVO result = memberMapper.selectMember(vo);
		
		System.out.println(result);
		
		MemberVO vo1 = new MemberVO();
		vo1.setMid("user1");
		result = memberMapper.selectMember(vo1);
		System.out.println("조회된 사용자 : " +result);
	}
}
