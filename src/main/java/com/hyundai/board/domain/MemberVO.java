package com.hyundai.board.domain;

import lombok.Data;

@Data
public class MemberVO {
	private String mid;
	private String mname;
	private String mpassword;
	private int menabled;
	private String mrole;
	private String memail;
}
