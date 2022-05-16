package com.hyundai.board.service;

import java.util.List;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.ReplyVO;

/**
 * @author 		: 고석준
 * @fileName 	: ReplyService.java
 * @date 		: 2022. 5. 16.
 * @description : 
 */
public interface ReplyService {
	//CRUD
	public int insertReply(ReplyVO replyVO);
		
	//글의 댓글리스트 
	public List<ReplyVO> selectReply(BoardVO boardVO);
		
	public int updateReply(ReplyVO replyVO);
		
	public int deleteReply(ReplyVO replyVO);
}
