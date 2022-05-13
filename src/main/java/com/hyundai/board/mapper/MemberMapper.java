package com.hyundai.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.board.domain.MemberVO;

/**
 * @author 		: 고석준
 * @fileName 	: MemberMapper.java
 * @date 		: 2022. 5. 13.
 * @description : 
 */
@Mapper
public interface MemberMapper {
	//CRUD
	public int insertMember(MemberVO memberVO);
	public List<MemberVO> selectAllMember();
	public int updateMember(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
	
	public MemberVO selectMember(MemberVO memberVO);
}
