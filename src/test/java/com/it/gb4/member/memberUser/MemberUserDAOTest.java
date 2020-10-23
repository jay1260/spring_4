package com.it.gb4.member.memberUser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.it.gb4.MyTestCase;
import com.it.gb4.member.MemberDTO;

public class MemberUserDAOTest extends MyTestCase{

	@Autowired
	private MemberUserDAO memberUserDAO;

	@Test
	public void getMemberLoginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("Id2");
		memberDTO.setPw("Pw2");
		
		memberDTO = memberUserDAO.getMemberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}
}
