package com.it.gb4.member.memberUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.gb4.member.MemberDTO;
import com.it.gb4.member.MemberService;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	// 2.
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	// 1.
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

}
