package com.hyundai.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.mapper.MemberMapper;

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
