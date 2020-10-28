package com.it.gb4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;
import com.it.gb4.board.BoardDTO;
import com.it.gb4.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;

	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = qnaDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setInsertTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setTitle("Title Test ing");
		boardDTO.setWriter("Writer Test ing");
		boardDTO.setContents("Contents Test ing");
		
		int result = qnaDAO.setInsert(boardDTO);
		
		assertNotEquals(0, result);
	}
}
