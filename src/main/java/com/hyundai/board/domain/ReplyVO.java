package com.hyundai.board.domain;

import java.sql.Date;

import lombok.Data;

/**
 * @author 		: 고석준
 * @fileName 	: ReplyVO.java
 * @date 		: 2022. 5. 16.
 * @description : 댓글 VO
 */
@Data
public class ReplyVO {
	private int rno;
	private String rcontent;
	private Date rdate;
	private int bno;
	private String mid;
}
