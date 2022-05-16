package com.hyundai.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.ReplyVO;

@SpringBootTest
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper replyMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void insertReplyTest() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setRcontent("reply test");
		replyVO.setMid("user12@email.com");
		replyVO.setBno(35);
		
		int rows = replyMapper.insertReply(replyVO);
		System.out.println(rows);
	}
	
	@Test
	public void selectReplyTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(35);
		
		List<ReplyVO> replylist = replyMapper.selectReply(boardVO);
		for(ReplyVO vo : replylist) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void updateReplyTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(35);
		
		List<ReplyVO> replylist = replyMapper.selectReply(boardVO);
		ReplyVO updateReply = replylist.get(0);
		updateReply.setRcontent("updateTest");
		int rows = replyMapper.updateReply(updateReply);
		System.out.println("ROWS : !!!!!!" + rows);
	}
	
	@Test
	public void deleteReplyTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(35);
		List<ReplyVO> replylist = replyMapper.selectReply(boardVO);
		ReplyVO deleteReply = replylist.get(0);
		
		int rows = replyMapper.deleteReply(deleteReply);
		System.out.println("ROWS delete : " + rows + " !@@@2");
	}
}
