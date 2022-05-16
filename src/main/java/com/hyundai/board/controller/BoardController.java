package com.hyundai.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyundai.board.domain.BoardVO;
import com.hyundai.board.service.BoardService;

@Controller
@RequestMapping(value="board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String boardlist(Model model)throws Exception {
		try {
			List<BoardVO> list = boardService.selectAllBoard();
			model.addAttribute("list", list);
			return "boardlist";
		}catch(Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insertBoard() {
		return "insertboard";
	}
	
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
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam(defaultValue = "0") int no ,Model model) {
		try {
			
			BoardVO vo = new BoardVO();
			vo.setBno(no);
			BoardVO boardVO = boardService.selectBoard(vo);
			model.addAttribute("board", boardVO);
			System.out.println(boardVO);
			return "boarddetail";
		}catch(Exception e) {
			model.addAttribute("msg", "접근할 수 없는 게시물이거나 시스템 오류입니다.");
			model.addAttribute("url", "board/list");
			return "result";
		}
	}
	
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
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@RequestParam int bno, BoardVO boardVO, Model model) {
		System.out.println("수정 시작");
		try {
			
			boardVO.setBno(bno);
			int result = boardService.updateBoard(boardVO);
			return "redirect:list";
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	
}
