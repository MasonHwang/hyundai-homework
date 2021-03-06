package com.hyundai.board.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hyundai.board.domain.MemberUserDetails;
import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.mapper.MemberMapper;

/**
 * @author 		: 고석준, 황명하 (Pair Programming)
 * @fileName 	: MemberUserDetailsService.java
 * @date 		: 2022. 5. 14.
 * @description : 스프링 시큐리티를 이용한 로그인 처리 관련 서비스
 */
@Service
public class MemberUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MemberVO result = null;
		
		MemberVO vo = new MemberVO();
	
		vo.setMid(username);
		result = memberMapper.selectMember(vo);
		
		MemberVO result2 = result;
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + result2.getMrole()));
		
		//MemberVO -> MemberUserDetails 변환 
		MemberUserDetails memberUserDetails = new
				MemberUserDetails(result2.getMid(), result2.getMpassword(), result2.getFromsocial(),
						authorities);
		//MemberUserDetails 값 세팅 
		memberUserDetails.setMname(result2.getMname());
		memberUserDetails.setFromsocial(result2.getFromsocial());
		
	
		
		return memberUserDetails;
		
	}

}
