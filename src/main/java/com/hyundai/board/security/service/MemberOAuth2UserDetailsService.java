package com.hyundai.board.security.service;

import lombok.extern.log4j.Log4j2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.hyundai.board.domain.MemberRole;
import com.hyundai.board.domain.MemberUserDetails;
import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.mapper.MemberMapper;

/**
 * @author 		: 고석준, 황명하 (Pair Programming)
 * @fileName 	: MemberOAuth2UserDetailsService.java
 * @date 		: 2022. 5. 14.
 * @description : OAuth2를 이용한 시큐리티 소셜 로그인 처리 관련 서비스
 */
@Log4j2
@Service
public class MemberOAuth2UserDetailsService
       extends DefaultOAuth2UserService{
	
	@Autowired
	private MemberMapper membermapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private MemberVO saveSocialMember(String email) {
		
		MemberVO vo = new MemberVO();
		vo.setMid(email);
		MemberVO result = membermapper.selectMember(vo);
		
		if(result != null) {
			System.out.println("기존회원");
			return result;
		}
		
		MemberVO member = new MemberVO();
		member.setMid(email);
		member.setFromsocial(1);
		member.setMenabled(1);
		member.setMname(email);
		member.setMpassword(passwordEncoder.encode("1111"));
		member.setMrole(MemberRole.USER);
		membermapper.insertMember(member);
		
		result = membermapper.selectMember(member);
		return result;
	} 
	
   @Override
   public OAuth2User loadUser(OAuth2UserRequest userRequest)
           throws OAuth2AuthenticationException {
       System.out.println("-----loaduser---------------");
       System.out.println("userRequest" + userRequest);
       
       String clientName = userRequest.getClientRegistration()
               .getClientName();
      
       //사용자 정보 가져오기 구글에서 허용한 API 범위
       OAuth2User oAuth2User = super.loadUser(userRequest);
       System.out.println("=====================");
       oAuth2User.getAttributes().forEach( ( k , v ) ->{
    	   System.out.println(k + " : " + v);
       });//end foreach
       
       
       String email = null;
       
       if(clientName.equals("Google")) {
    	   email = oAuth2User.getAttribute("email");
    	   
       }
       
       MemberVO memberVO = saveSocialMember(email);
       List<GrantedAuthority> authorities = new ArrayList<>();
       authorities.add(
               new SimpleGrantedAuthority("ROLE_" + memberVO.getMrole()));      
       
       MemberUserDetails memberUserDetails = new MemberUserDetails(memberVO.getMid(), memberVO.getMpassword(), 1, authorities,oAuth2User.getAttributes());
       memberUserDetails.setMname(memberVO.getMname());
       memberUserDetails.setFromsocial(memberVO.getFromsocial());
       return memberUserDetails;
       
   }//end load..
   
   
   
}//end class
