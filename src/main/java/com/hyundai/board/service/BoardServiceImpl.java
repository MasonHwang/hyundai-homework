package com.hyundai.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.Criteria;
import com.hyundai.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Override
	public int updateBoard(BoardVO boardVO) {
		try {
			int result = boardMapper.updateBoard(boardVO);
			System.out.println("수정 결과: " + result);
			if(result != 1) {
				throw new RuntimeException("수정이 성공적으로 이뤄지지 않았습니다.");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
		return 1;
	}


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
	@Transactional
	public BoardVO selectBoard(BoardVO boardVO) {
		try {
			boardVO = boardMapper.selectBoard(boardVO);
			boardMapper.increaseHitcount(boardVO);
			return boardVO;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}


	@Override
	public int deleteBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		
		try {
			int result = boardMapper.deleteBoard(boardVO);
			System.out.println("삭제 결과: " + result);
			if(result != 1) {
				throw new RuntimeException("삭제가 성공적으로 이뤄지지 않았습니다.");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
		return 1;
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


	@Override
	public List<BoardVO> selectMemberBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.selectMemberBoard(boardVO);
	}


	@Override
	public List<BoardVO> getBoard(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getBoard(cri);
	}


	@Override
	public List<BoardVO> getMemberBoard(Criteria cri, String mid) {
		// TODO Auto-generated method stub
		return boardMapper.getMemberBoard(cri, mid);
	}


	@Override
	public int getMemberTotal(String mid) {
		// TODO Auto-generated method stub
		return boardMapper.getMemberTotal(mid);
	}


	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return boardMapper.getTotal();
	}
	
	
	
}
