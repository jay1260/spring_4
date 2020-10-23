package com.it.gb4.member.memberUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.gb4.member.MemberDTO;
import com.it.gb4.member.MemberService;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	// 3.
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	// 2.
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	// 1.
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

}
