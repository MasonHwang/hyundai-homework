package com.hyundai.board.mapper;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.board.domain.ImageVO;

@SpringBootTest
public class ImageMapperTest {
	@Autowired
	private ImageMapper imageMapper;
	
	@Test
	public void insertImageTest() {
		String uuid = UUID.randomUUID().toString();
		ImageVO imageVO = new ImageVO();
		imageVO.setIid(uuid);
		imageVO.setIattachoname(uuid + "_name");
		imageVO.setIattachsname(uuid+"_s_name");
		
		int row = imageMapper.insertImage(imageVO);
		
		System.out.println("insert rows : " + row);
		
	}
	@Test
	public void selectAllImageTest() {
		List<ImageVO> list = imageMapper.selectAllImage();
		for(ImageVO vo : list) {
			System.out.println(vo);
		}
	}
	@Test
	public void selectImageTest() {
		String uuid = UUID.randomUUID().toString();
		ImageVO imageVO = new ImageVO();
		imageVO.setIid(uuid);
		imageVO.setIattachoname(uuid + "_name");
		imageVO.setIattachsname(uuid+"_s_name");
		
		int row = imageMapper.insertImage(imageVO);
		
		ImageVO vo1 = imageMapper.selectImage(imageVO);
		
		System.out.println(vo1);
	}
}
