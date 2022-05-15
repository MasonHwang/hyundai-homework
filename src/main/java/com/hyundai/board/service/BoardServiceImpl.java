package com.hyundai.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> selectAllBoard() {
		try {
			return boardMapper.selectAllBoard();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	
	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		try {
			boardVO = boardMapper.selectBoard(boardVO);
			return boardVO;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}


	@Override
	public void insertBoard(BoardVO boardVO) {
		try {
			boardMapper.insertBoard(boardVO);
			System.out.println("게시글 입력 성공");
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
}
