package com.hyundai.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.ReplyVO;
import com.hyundai.board.mapper.ReplyMapper;

/**
 * @author 		: 고석준
 * @fileName 	: ReplyServiceImpl.java
 * @date 		: 2022. 5. 16.
 * @description : 
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int insertReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyMapper.insertReply(replyVO);
	}

	@Override
	public List<ReplyVO> selectReply(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return replyMapper.selectReply(boardVO);
	}

	@Override
	public int updateReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyMapper.updateReply(replyVO);
	}

	@Override
	public int deleteReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyMapper.deleteReply(replyVO);
	}

}
