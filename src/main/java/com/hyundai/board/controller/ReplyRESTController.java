package com.hyundai.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.MemberUserDetails;
import com.hyundai.board.domain.ReplyVO;
import com.hyundai.board.service.ReplyService;

/**
 * @author 		: 고석준
 * @fileName 	: ReplyRESTController.java
 * @date 		: 2022. 5. 16.
 * @description : 관련 관련 기능(생성, 삭제 수정)에 대한 컨트롤러
 */

@RestController
@RequestMapping("/reply")
public class ReplyRESTController {
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/insert")
	public ResponseEntity<List<ReplyVO>> insertReply(@RequestBody ReplyVO replyVO,
			@AuthenticationPrincipal MemberUserDetails memberUserDetails){
		replyVO.setMid(memberUserDetails.getMemail());
		int rows = replyService.insertReply(replyVO);
		if(rows != 1) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(replyVO.getBno());
		List<ReplyVO> replylist = replyService.selectReply(boardVO);
		return new ResponseEntity<>(replylist, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteReply(@RequestBody ReplyVO replyVO,
			@AuthenticationPrincipal MemberUserDetails memberUserDetails){
		replyVO.setMid(memberUserDetails.getMemail());
		int rows = replyService.deleteReply(replyVO);
		if(rows != 1) {
			return new ResponseEntity<>("FAILURE", HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateReply(@RequestBody ReplyVO replyVO,
			@AuthenticationPrincipal MemberUserDetails memberUserDetails){
		replyVO.setMid(memberUserDetails.getMemail());
		int rows = replyService.updateReply(replyVO);
		if(rows != 1) {
			return new ResponseEntity<>("FAILURE", HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

	
}
