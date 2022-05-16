package com.hyundai.board.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

/**
 * @author 		: 황명하
 * @fileName 	: Criteria.java
 * @date 		: 2022. 5. 16.
 * @description : 특정 페이지의 게시판을 조회하기 위한 클래스, 검색을 위한 기준데이터
 */

@Component
@Data
public class Criteria {
	private int pageNum;
	private int amount;
	private String type;
	private String keyword;
	
	
	public Criteria() {this(1,10);}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", pageNum).queryParam("amount", amount);
		return builder.toUriString();
	}
 	
	public String[] getTypeArr() {
		return type == null ? new String[]{} : type.split("");
	}
}
