package com.hyundai.board.domain;

import lombok.Data;

/**
 * @author 		: 고석준
 * @fileName 	: MemberVO.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@Data
public class MemberVO {
	private String mid;
	private String mname;
	private String mpassword;
	private int menabled;
	private String mrole;
	private String memail;
}
