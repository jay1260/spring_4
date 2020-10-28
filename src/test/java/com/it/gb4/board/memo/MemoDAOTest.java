package com.it.gb4.board.memo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;
import com.it.gb4.util.Pager;

public class MemoDAOTest extends MyTestCase {

	@Autowired
	private MemoDAO memoDAO;

	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<MemoDTO> ar = memoDAO.getList(pager);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setInsertTest() throws Exception{
		
		for(int i=0; i<100; i++) {
			MemoDTO memoDTO = new MemoDTO();
			memoDTO.setContents("contents"+i);
			memoDTO.setWriter("writer"+i);
			
			int result = memoDAO.setInsert(memoDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
	}
	
}
