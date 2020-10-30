package com.it.gb4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;
import com.it.gb4.board.BoardDTO;
import com.it.gb4.board.file.BoardFileDTO;
import com.it.gb4.util.Pager;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void setInsertFileTest() throws Exception{
		BoardFileDTO boardFileDTO = new BoardFileDTO();

		boardFileDTO.setNum(8);
		boardFileDTO.setFileName("f2");
		boardFileDTO.setOriName("o2");
		
		int result = noticeDAO.setInsertFile(boardFileDTO);
		System.out.println(result);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setInsertTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("Title Test 1");
		boardDTO.setWriter("Writer Test 1");
		boardDTO.setContents("Contents Test 1");
		int result = noticeDAO.setInsert(boardDTO);
		assertEquals(1, result);
	}
}
