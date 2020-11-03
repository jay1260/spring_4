package com.it.gb4.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.it.gb4.board.BoardDTO;
import com.it.gb4.board.qna.QnaDAO;
import com.it.gb4.member.MemberDTO;

@Component
public class QnaUpdateInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private QnaDAO qnaDAO;
	
	
	// 여러가지 방법을 비교하면서 작성한 것.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		long num = Long.parseLong(request.getParameter("num"));
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		
		boardDTO = qnaDAO.getOne(boardDTO);
		
		// session
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		boolean check = false;
		if(boardDTO.getWriter().equals(memberDTO.getId())) {
			check = true;
		}else {
			request.setAttribute("msg", "작성자가 아닙니다.");
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return check;
	}
	
	
	// update -> method가 GET일때 실행, POST면 그냥 종료
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// 메서드 형식
		String method = request.getMethod(); // GET, POST
		
		if(method.equals("POST")) {
			
			return;
		}
		
		// 로그인한 사용자 ID
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		String id = memberDTO.getId();
		
		// 글 작성자
		Map<String, Object> model = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)model.get("dto");
		String writer = boardDTO.getWriter();
		
		String board = (String)model.get("board");
		
		// 비교
		if(!id.equals(writer)) {
			// 리스트로 이동
			modelAndView.addObject("msg", "작성자가 아니므로 권한이 없습니다.");
			modelAndView.addObject("path", board+"List");
			modelAndView.setViewName("common/result");
			
		}
	}
}
