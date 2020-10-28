package com.it.gb4.member.memberUser;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.it.gb4.member.MemberDTO;
import com.it.gb4.member.MemberService;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	// 5.
	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	// 4.
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		// HDD 폴더에, 이름
		// 저장할 폴더 경로
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		System.out.println(path);
		
		// 이름 중복되지 않도록,,
		// 1. 시간으로 설정(millis)
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		String name = photo.getOriginalFilename();
		name = time+"_"+name;
		System.out.println(name);
	
		File file = new File(path, name);
		
		// HDD저장
		// 1. FileCopyUtils라는 객체의 메서드 활용
		byte [] ar = photo.getBytes();
		FileCopyUtils.copy(ar, file);
		
		return 0;//memberUserDAO.setMemberJoin(memberDTO);
	}
	
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
