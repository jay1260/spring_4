package com.it.gb4.member.memberFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberFileService {

	@Autowired
	private MemberFileDAO memberFileDAO;

	public MemberFileDTO getOne(MemberFileDTO memberFileDTO) throws Exception{
		return memberFileDAO.getOne(memberFileDTO);
	}
}
