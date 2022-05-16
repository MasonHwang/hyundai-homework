package com.hyundai.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.mapper.MemberMapper;
/**
 * @author 		: 고석준, 황명하
 * @fileName 	: MemberServiceImpl.java
 * @date 		: 2022. 5. 16.
 * @description : 멤버 기능 관련 서비스
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		try {
			memberMapper.insertMember(memberVO);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}

}
