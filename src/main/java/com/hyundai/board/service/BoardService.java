package com.hyundai.board.service;

import java.util.List;

import com.hyundai.board.domain.BoardVO;

public interface BoardService {
	
	
	
	void insertBoard(BoardVO boardVO);
	
	List<BoardVO> selectAllBoard();
	
	BoardVO selectBoard(BoardVO boardVO);
	
	int deleteBoard(BoardVO boardVO);
	
	int updateBoard(BoardVO boardVO);
}
