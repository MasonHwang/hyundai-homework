package com.hyundai.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.MemberVO;

/**
 * @author 		: 고석준
 * @fileName 	: BoardMapper.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@Mapper
public interface BoardMapper {
	//CRUD
	public int insertBoard(BoardVO boardVO);
	public List<BoardVO> selectAllBoard();
	public int updateBoard(BoardVO boardVO);
	public int deleteBoard(BoardVO boardVO);
	
	public BoardVO selectBoard(BoardVO boardVO);
	
	public List<BoardVO> selectMemberBoard(BoardVO boardVO);
}
