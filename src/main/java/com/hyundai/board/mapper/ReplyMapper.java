package com.hyundai.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.ReplyVO;

/**
 * @author 		: 고석준
 * @fileName 	: ReplyMapper.java
 * @date 		: 2022. 5. 16.
 * @description : 댓글 관련 매퍼 작성
 */
@Mapper
public interface ReplyMapper {
	//댓글 CRUD (고석준)
	public int insertReply(ReplyVO replyVO);
	//글의 댓글리스트 
	public List<ReplyVO> selectReply(BoardVO boardVO);
	public int updateReply(ReplyVO replyVO);
	public int deleteReply(ReplyVO replyVO);
}
