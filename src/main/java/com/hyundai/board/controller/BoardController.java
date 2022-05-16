package com.hyundai.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.domain.MemberUserDetails;
import com.hyundai.board.domain.ReplyVO;
import com.hyundai.board.domain.Criteria;
import com.hyundai.board.domain.PageVO;
import com.hyundai.board.service.BoardService;
import com.hyundai.board.service.ReplyService;

/**
 * @author 		: 황명하, 고석준
 * @fileName 	: BoardController.java
 * @date 		: 2022. 5. 16.
 * @description : 게시판 기능(조회, 삽입, 삭제, 변경) 관련 컨트롤러
 */
@Controller
@RequestMapping(value="board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	// 페이징이 적용된 게시글 리스트 화면 출력 (황명하)
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String boardlist(Criteria criteria, Model model)throws Exception {
		try {
			model.addAttribute("list", boardService.getBoard(criteria));
			model.addAttribute("pageMaker", new PageVO(boardService.getTotal(), 10, criteria));
			return "boardlist";
		}catch(Exception e) {
			throw e;
		}
	}
	// 게시글 작성 폼 화면으로 이동 (황명하)
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insertBoard() {
		return "insertboard";
	}
	// 입력된 게시글 작성폼을 이용해 DB에 Insert (황명하)
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insertBoard(@ModelAttribute BoardVO boardVO, Model model) {
		try {
			boardService.insertBoard(boardVO);
			return "redirect:list";
		}catch(Exception e) {
			model.addAttribute("msg", "게시글 등록 오류입니다.");
			model.addAttribute("url", "javascript:history.back();");
			return "result";
		}
	}
	
	// 게시글 상세보기 기능 구현 (고석준, 황명하)
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam(defaultValue = "0") int no ,
			@AuthenticationPrincipal MemberUserDetails memberUserDetails,
			Model model) {
		try {
			
			BoardVO vo = new BoardVO();
			vo.setBno(no);
			BoardVO boardVO = boardService.selectBoard(vo);
			model.addAttribute("board", boardVO);
			System.out.println(boardVO);
			
			List<ReplyVO> replylist = replyService.selectReply(vo);
			model.addAttribute("replylist", replylist);
			
			return "boarddetail";
		}catch(Exception e) {
			model.addAttribute("msg", "접근할 수 없는 게시물이거나 시스템 오류입니다.");
			model.addAttribute("url", "board/list");
			e.printStackTrace();
			return "result";
		}
	}
	
	// 게시글 삭제 수행(황명하)
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteBoard(@RequestParam int no, @RequestParam String id) {
		try {
			BoardVO vo = new BoardVO();
			vo.setBno(no);
			vo.setMid(id);
			int result = boardService.deleteBoard(vo);
			return "redirect:list";
		}catch(Exception e) {
			throw e;
		}
	}
	
	//게시글 수정 폼으로 이동 (황명하)
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam int no, @RequestParam String id, Model model) {
		try {
			BoardVO vo = new BoardVO();
			vo.setBno(no);
			BoardVO boardVO = boardService.selectBoard(vo);
			// 해당 유저가 글 작성자가 같지 않다면 접근 못하도록 설정
			if(!boardVO.getMid().equals(id)) return "/board/list";
			model.addAttribute("board", boardVO);
			System.out.println(boardVO);
			return "updateform";	
		}catch(Exception e) {
			throw e;
		}
	}
	
	// 입력된 게시글 수정폼을 이용해 수정 실행 (황명하)
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(BoardVO boardVO, Model model) {
		System.out.println("수정 시작");
		try {
			int result = boardService.updateBoard(boardVO);
			return "redirect:list";
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	
}
