package com.hyundai.board.service;

import java.util.List;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.Criteria;

/**
 * @author 		: 고석준, 황명하
 * @fileName 	: BoardService.java
 * @date 		: 2022. 5. 16.
 * @description : 게시판 기능 관련 서비스
 */
public interface BoardService {
	
	void insertBoard(BoardVO boardVO);
	
	List<BoardVO> selectAllBoard();
	
	BoardVO selectBoard(BoardVO boardVO);
	
	int deleteBoard(BoardVO boardVO);
	
	int updateBoard(BoardVO boardVO);
	
	List<BoardVO> selectMemberBoard(BoardVO boardVO);
	
	List<BoardVO> getBoard(Criteria cri);

	List<BoardVO> getMemberBoard(Criteria cri, String mid);
	
	int getTotal();

	int getMemberTotal(String mid);
}
