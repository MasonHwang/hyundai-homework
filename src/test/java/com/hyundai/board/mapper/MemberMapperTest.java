package com.hyundai.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.MemberRole;
import com.hyundai.board.domain.MemberVO;

/**
 * @author 		: 고석준
 * @fileName 	: MemberMapperTest.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@SpringBootTest
public class MemberMapperTest {
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void insertMemberTest() {
		int rows = 0;
		for(int i=1 ; i<=10 ; i++) {
			MemberVO vo = new MemberVO();
			vo.setMid("user"+i + "@email.com");
			vo.setMname("이름" +i);
			vo.setMpassword("password" + i);
			vo.setFromsocial(0);
			if(i<9) {
				vo.setMrole(MemberRole.USER);
			}else {
				vo.setMrole(MemberRole.ADMIN);
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
		updateVO.setMid("TEST@email.com");
		updateVO.setMname("TEST_UPDATE");
		updateVO.setMpassword("TEST_update");
		updateVO.setMenabled(0);
		updateVO.setMrole(MemberRole.USER);
		
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
		vo.setMrole(MemberRole.USER);
		
		int rows = memberMapper.deleteMember(vo);
		
		System.out.println("rows: "+ rows);
	}
	
	@Test
	public void selectMemberTest() {
		MemberVO vo = new MemberVO();
		vo.setMid("user1@email.com");
		
		MemberVO result = memberMapper.selectMember(vo);
		
		System.out.println(result);
		
		MemberVO vo1 = new MemberVO();
		vo1.setMid("user1");
		result = memberMapper.selectMember(vo1);
		System.out.println("조회된 사용자 : " +result);
	}
}
