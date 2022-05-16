package com.hyundai.board.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno;
	private String rcontent;
	private Date rdate;
	private int bno;
	private String mid;
}
