package com.it.gb4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;
import com.it.gb4.board.BoardDTO;
import com.it.gb4.util.Pager;

public class QnaServiceTest extends MyTestCase{

	@Autowired
	private QnaService qnaService;

	//@Test
	public void qnaListTest()throws Exception{
		Pager pager = new Pager();
		
		List<BoardDTO> ar = qnaService.getList(pager);
		System.out.println(ar.size());
		
		assertEquals(10, ar.size());
	}
}
