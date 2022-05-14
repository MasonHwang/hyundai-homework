package com.hyundai.board.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 		: 고석준
 * @fileName 	: MemberVO.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@Data
public class MemberVO implements Serializable{
	private String mid; //id email 역할 가지도록 
	private String mname;
	private String mpassword;
	private int menabled;
	private MemberRole mrole;
	
	private int fromsocial;
}
