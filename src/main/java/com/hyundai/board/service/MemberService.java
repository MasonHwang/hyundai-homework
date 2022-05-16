package com.hyundai.board.service;

import com.hyundai.board.domain.MemberVO;
/**
 * @author 		: 고석준, 황명하
 * @fileName 	: MemberService.java
 * @date 		: 2022. 5. 16.
 * @description : 멤버 기능 관련 서비스
 */
public interface MemberService {
	int insertMember(MemberVO memberVO);
}
