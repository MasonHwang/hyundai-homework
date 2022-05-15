package com.hyundai.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.service.BoardService;

@RestController
@RequestMapping(value="board/*")
public class BoardRESTController {

	@Autowired
	BoardService boardService;

	//REST 방식으로 구현
//	@RequestMapping(value="/detail", method = RequestMethod.GET)
//	public ResponseEntity<BoardVO> boardDetail(@RequestParam(defaultValue = "0") int no) {
//		ResponseEntity<BoardVO> entry = null;
//		
//		try {
//			BoardVO vo = new BoardVO();
//			vo.setBno(no);
//			entry = new ResponseEntity<BoardVO>(boardService.selectBoard(vo), HttpStatus.OK);
//		}catch(Exception e) {
//			entry = new ResponseEntity<BoardVO>(HttpStatus.BAD_REQUEST);
//		}
//		return entry;
//	}
	
}
