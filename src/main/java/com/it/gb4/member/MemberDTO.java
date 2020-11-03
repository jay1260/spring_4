package com.it.gb4.member;

import com.it.gb4.member.memberFile.MemberFileDTO;

public class MemberDTO{
	
	private long num;
	private String id;
	private String pw;
	private String name;
	private String email;
	// memberDTO는 memberFileDTO를 가지고 있다
	// 자식 has a 부모
	private MemberFileDTO memberFileDTO;
	
	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}
	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
