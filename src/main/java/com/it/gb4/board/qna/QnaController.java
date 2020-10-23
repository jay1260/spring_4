package com.it.gb4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.gb4.board.BoardDTO;
import com.it.gb4.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardDTO);
		mv.setViewName("board/boardList");
		
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.addObject("board", "qna");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardDTO);
		
		String message = "Update Fail";
		if(result>0) {
			message = "Update Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate() throws Exception {
		// 글번호 출력
		// 글제목, 글내용
		BoardDTO boardDTO = new BoardDTO();
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardUpdate");
		mv.addObject("dto", boardDTO);
		
		mv.addObject("board", "qna");
		
		return mv;

	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(boardDTO);
		
		String message = "Reply Write Fail";
		if(result>0) {
			message = "Reply Write Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.addObject("dto", boardDTO);
			mv.setViewName("board/boardSelect");
			mv.addObject("board", "qna");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./qnaList");
		}
		
		
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO);
		
		String message = "Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "qna");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);

		BoardDTO boardDTO = ar.get(0);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		System.out.println(qnaDTO.getDepth());
		
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
