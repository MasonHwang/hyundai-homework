package com.hyundai.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.Criteria;
import com.hyundai.board.domain.MemberVO;

/**
 * @author 		: 고석준, 황명하
 * @fileName 	: BoardMapper.java
 * @date 		: 2022. 5. 13.
 * @description : 게시판 관련 매퍼 작성
 */
@Mapper
public interface BoardMapper {
	//게시글 CRUD (고석준)
	public int insertBoard(BoardVO boardVO);
	public List<BoardVO> selectAllBoard();
	public int updateBoard(BoardVO boardVO);
	public int deleteBoard(BoardVO boardVO);
	public BoardVO selectBoard(BoardVO boardVO);
	public List<BoardVO> selectMemberBoard(BoardVO boardVO);
	
	//페이징 기준이 적용된 게시글 리스트 (황명하)
	public List<BoardVO> getBoard(Criteria cri);
	//페이징 기준이 적용된 내가 작석한 게시글 리스트 (황명하)
	public List<BoardVO> getMemberBoard(@Param("cri")Criteria cri, @Param("mid")String mid);
	//전체 게시글 수 (황명하)
	public int getTotal();
	//내가 작성한 게시글 수 (황명하)
	public int getMemberTotal(String mid);
	//게시글 조회수 증가 (고석준)
	public void increaseHitcount(BoardVO boardVO);
	
}
