package com.hyundai.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.Criteria;
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
	
	public List<BoardVO> getBoard(Criteria cri);
	
	public List<BoardVO> getMemberBoard(@Param("cri")Criteria cri, @Param("mid")String mid);
	public int getTotal();
	public int getMemberTotal(String mid);
	public void increaseHitcount(BoardVO boardVO);
	
}
