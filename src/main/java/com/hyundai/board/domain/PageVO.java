package com.hyundai.board.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author 		: 황명하
 * @fileName 	: PageVO.java
 * @date 		: 2022. 5. 16.
 * @description : 게시판 페이징을 실제 담당하는 클래스
 */
@Component
@Data
public class PageVO {
	private int pageCount;
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev, next;
	private int total;
	private Criteria criteria;
	
	public PageVO() {}
	
	public PageVO(int total, int pageCount, Criteria criteria) {
		this.total = total;
		this.criteria = criteria;
		this.pageCount = pageCount;
		
		this.endPage = (int)(Math.ceil(criteria.getPageNum()*1.0/pageCount))*pageCount;
		this.startPage = endPage - (pageCount-1);
		
		realEnd = (int)(Math.ceil(total*1.0 / criteria.getAmount()));
		
		if(endPage > realEnd) {
			endPage = realEnd == 0? 1 : realEnd;
		}
		
		prev = startPage > 1;
		next = endPage < realEnd;
		
	}
}
