package com.hyundai.board.domain;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 		: 고석준
 * @fileName 	: MemberUserDetails.java
 * @date 		: 2022. 5. 14.
 * @description : 
 */
@Setter
@Getter
public class MemberUserDetails extends User{
	
	private static final long serialVersionUID = 1L;
	private String memail;
	private String mname;
	private int fromsocial;
	
	public MemberUserDetails(String username, String password, int fromsocial,
			List<GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.memail = username;
		this.fromsocial = fromsocial;
	}

}
