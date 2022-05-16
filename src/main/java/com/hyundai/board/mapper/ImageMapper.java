package com.hyundai.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.board.domain.ImageVO;

/**
 * @author 		: 고석준
 * @fileName 	: ImageMapper.java
 * @date 		: 2022. 5. 13.
 * @description : 이미지 관련 매퍼 작성
 */
@Mapper
public interface ImageMapper {
	//이미지 CRUD (고석준)
	public int insertImage(ImageVO imageVO);
	public List<ImageVO> selectAllImage();
	public ImageVO selectImage(ImageVO imageVO);
	
}
