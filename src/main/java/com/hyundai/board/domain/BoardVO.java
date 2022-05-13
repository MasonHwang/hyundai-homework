package com.hyundai.board.domain;

import java.sql.Date;

import lombok.Data;

/**
 * @author 		: 고석준
 * @fileName 	: BoardVO.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@Data
public class BoardVO {
	private int bno;//pk
	private String btitle;
	private String bcontent;
	private Date bdate;
	private int bhitcount;
	
	//fk
	private String mid;
	private String iid;
}
