package com.hyundai.board.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.Criteria;
import com.hyundai.board.domain.ImageVO;
import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.mapper.ImageMapper;
import com.hyundai.board.mapper.MemberMapper;

@SpringBootTest
public class BoardServiceTest {
	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Test
	public void updateBoardTest() {
		List<BoardVO> boardvo = boardService.selectAllBoard();
		
		BoardVO vo = new BoardVO();
		vo.setBtitle("updateTitle");
		vo.setBcontent("updateContent");
		
		vo.setBno(boardvo.get(0).getBno());
		vo.setMid(boardvo.get(0).getMid());
		vo.setIid(boardvo.get(0).getIid());
		
		int rows = boardService.updateBoard(vo);
		System.out.println(rows);
	}
	
	@Test
	public void selectAllBoardTest() {
		List<BoardVO> list = boardService.selectAllBoard();
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void selectBoard() {
		List<BoardVO> boardvo = boardService.selectAllBoard();
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(boardvo.get(0).getBno());
		
		BoardVO boardVO = boardService.selectBoard(vo);
		System.out.println(boardVO);
	}
	
	@Test
	public void deleteBaordTest() {
		List<BoardVO> boardvo = boardService.selectAllBoard();
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(boardvo.get(0).getBno());
		vo.setMid(boardvo.get(0).getMid());
		vo.setIid(boardvo.get(0).getIid());
		
		int rows = boardService.deleteBoard(vo);
		System.out.println(rows);
	}
	
	@Test
	public void inserBoardTest() {
		List<MemberVO> membervo = memberMapper.selectAllMember();
		
		List<ImageVO> imagevo = imageMapper.selectAllImage();
		
		BoardVO vo = new BoardVO();
		vo.setBtitle("testTitle");
		vo.setBcontent("testContent");
		
		vo.setMid(membervo.get(0).getMid());
		
		
		boardService.insertBoard(vo);
	}
	@Test
	public void selectMemberBoardTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setMid("user11@email.com");
		
		List<BoardVO> list = boardService.selectMemberBoard(boardVO);
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	@Test
	public void getBoardTst() {
		Criteria cri = new Criteria();
		cri.setAmount(3);
		cri.setPageNum(1);
		
		List<BoardVO> list = boardService.getBoard(cri);
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	@Test
	public void getMemberBoardTest() {
		Criteria cri = new Criteria();
		cri.setAmount(3);
		cri.setPageNum(1);
		
		List<BoardVO> list = boardService.getMemberBoard(cri,"user11@email");
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	@Test
	public void getMemberTotalTest() {
		int rows = boardService.getMemberTotal("user11@gmail.com");
		System.out.println(rows);
	}
	@Test
	public void getTotalTest() {
		int rows = boardService.getTotal();
		System.out.println(rows);
	}
}
