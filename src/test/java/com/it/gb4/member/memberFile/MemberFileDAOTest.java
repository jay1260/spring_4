package com.it.gb4.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;

public class MemberFileDAOTest extends MyTestCase {

	@Autowired
	private MemberFileDAO memberFileDAO;

	//@Test(expected = RuntimeException.class)
	public void setInsertTest() throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		
		memberFileDTO.setId("id46666777766666");
		memberFileDTO.setFileName("fileName1");
		memberFileDTO.setOriName("oriName1");
		
		int result = memberFileDAO.setInsert(memberFileDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void getOneTest() throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("t1");
		
		memberFileDTO = memberFileDAO.getOne(memberFileDTO);
		
		System.out.println(memberFileDTO.getFileName());
		
		assertNotNull(memberFileDTO);
	}
}
