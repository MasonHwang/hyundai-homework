package com.hyundai.board.mapper;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.ImageVO;
import com.hyundai.board.domain.MemberVO;

/**
 * @author 		: 고석준
 * @fileName 	: BoardMapperTest.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@SpringBootTest
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private ImageMapper imageMapper;
	
	@Test
	public void insertBoardTest() {
		List<MemberVO> membervo = memberMapper.selectAllMember();
		
		List<ImageVO> imagevo = imageMapper.selectAllImage();
		
		BoardVO vo = new BoardVO();
		vo.setBtitle("testTitle");
		vo.setBcontent("testContent");
		
		vo.setMid(membervo.get(0).getMid());
		
		
		int rows = boardMapper.insertBoard(vo);
		System.out.println(rows);
		
	}
	
	@Test
	public void selectAllBoardTest() {
		List<BoardVO> list = boardMapper.selectAllBoard();
		
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void updateBoardTest() {
		
		List<BoardVO> boardvo = boardMapper.selectAllBoard();
		
		BoardVO vo = new BoardVO();
		vo.setBtitle("updateTitle");
		vo.setBcontent("updateContent");
		
		vo.setBno(boardvo.get(0).getBno());
		vo.setMid(boardvo.get(0).getMid());
		vo.setIid(boardvo.get(0).getIid());
		
		int rows = boardMapper.updateBoard(vo);
		System.out.println(rows);
	}
	
	@Test
	public void deleteBaordTest() {
		List<BoardVO> boardvo = boardMapper.selectAllBoard();
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(boardvo.get(0).getBno());
		vo.setMid(boardvo.get(0).getMid());
		vo.setIid(boardvo.get(0).getIid());
		
		int rows = boardMapper.deleteBoard(vo);
		System.out.println("삭제된 행 : " + rows);
	}
	
	@Test
	public void selectBoardTest() {
		List<BoardVO> boardvo = boardMapper.selectAllBoard();
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(boardvo.get(0).getBno());
		
		BoardVO boardVO = boardMapper.selectBoard(vo);
		System.out.println(boardVO);
	}
	
	@Test
	public void selectMemberBoardTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setMid("user11@email.com");
		
		List<BoardVO> list = boardMapper.selectMemberBoard(boardVO);
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
}
