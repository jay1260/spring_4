package com.it.gb4.member;

public interface MemberDAO {
	
	// login
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception;

	// update
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;

	public int setMemberDelete(MemberDTO memberDTO) throws Exception;
}
