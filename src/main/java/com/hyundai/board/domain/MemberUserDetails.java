package com.hyundai.board.domain;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 		: 고석준
 * @fileName 	: MemberUserDetails.java
 * @date 		: 2022. 5. 14.
 * @description : Spring Security에서 사용자의 정보를 담는 인터페이스
 */
@Setter
@Getter
public class MemberUserDetails extends User implements OAuth2User{
	
	private static final long serialVersionUID = 1L;
	private String memail;
	private String mname;
	private int fromsocial;
	private Map<String, Object> OA2_attr;
	
	public MemberUserDetails(String username, String password, int fromsocial,
			List<GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.memail = username;
		this.fromsocial = fromsocial;
	}
	
	
	public MemberUserDetails(String username, String password, int fromsocial,
			List<GrantedAuthority> authorities, Map<String, Object> OA2_attr) {
		this(username, password, fromsocial, authorities);
		this.OA2_attr = OA2_attr;
	}


	@Override
	public Map<String, Object> getAttributes() {
		return OA2_attr;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
