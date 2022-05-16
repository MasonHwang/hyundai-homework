package com.hyundai.board.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.ReplyVO;
import com.hyundai.board.mapper.BoardMapper;
import com.hyundai.board.mapper.MemberMapper;

/**
 * @author 		: 고석준
 * @fileName 	: ReplyServiceTest.java
 * @date 		: 2022. 5. 16.
 * @description : 
 */
@SpringBootTest
public class ReplyServiceTest {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void insertReplyTest() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setRcontent("reply test");
		replyVO.setMid("user12@email.com");
		replyVO.setBno(35);
		
		int rows = replyService.insertReply(replyVO);
		System.out.println(rows);
	}
	
	@Test
	public void selectReplyTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(35);
		
		List<ReplyVO> replylist = replyService.selectReply(boardVO);
		for(ReplyVO vo : replylist) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void updateReplyTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(35);
		
		List<ReplyVO> replylist = replyService.selectReply(boardVO);
		ReplyVO updateReply = replylist.get(0);
		updateReply.setRcontent("updateTest");
		int rows = replyService.updateReply(updateReply);
		System.out.println("ROWS : !!!!!!" + rows);
	}
	
	@Test
	public void deleteReplyTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(35);
		List<ReplyVO> replylist = replyService.selectReply(boardVO);
		ReplyVO deleteReply = replylist.get(0);
		
		int rows = replyService.deleteReply(deleteReply);
		System.out.println("ROWS delete : " + rows + " !@@@2");
	}
}
