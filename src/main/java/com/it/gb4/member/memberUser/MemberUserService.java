package com.it.gb4.member.memberUser;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.it.gb4.member.MemberDTO;
import com.it.gb4.member.MemberService;
import com.it.gb4.member.memberFile.MemberFileDAO;
import com.it.gb4.member.memberFile.MemberFileDTO;
import com.it.gb4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
//	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception{
//		return memberFileDAO.getOne(memberDTO);
//	}
	
	// 5.
	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	// 4.
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		System.out.println(path);
		File file = new File(path);
		String fileName = "";

		
		int result = memberUserDAO.setMemberJoin(memberDTO);
		
		// 첨부파일을 올리면 (올리지 않으면 실행 X)
		if(photo.getSize() !=0) {
			fileName = fileSaver.saveCopy(file, photo);
			// memberFile Insert 순서 중요!!
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			result = memberFileDAO.setInsert(memberFileDTO);
		}
		
		return result;
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
