package com.it.gb4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.it.gb4.member.MemberDTO;
import com.it.gb4.member.memberFile.MemberFileDTO;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {
	
	@Autowired
	private MemberUserService memberUserService;
	
	// idCheck
	@GetMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberIdCheck(memberDTO);
		
		int result = 1; // 중복아이디
		if(memberDTO == null) {
			result = 0; // 사용가능
		}
		
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getName());
		System.out.println(photo.getSize());
		
		
		int result = memberUserService.setMemberJoin(memberDTO, photo, session);
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	// 6.
	@GetMapping("memberJoin")
	public ModelAndView setMemberJoin()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberJoin");
		return mv;
	}
	
	// 5.
	@GetMapping("memberDelete")
	public ModelAndView setMemberDelete(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		int result = memberUserService.setMemberDelete(memberDTO);
		if(result>0) {
			session.invalidate();
		}
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	// 4.
	@PostMapping("memberUpdate")
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO s = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(s.getId());
		
		int result = memberUserService.setMemberUpdate(memberDTO);
		
		if(result>0) {
			s.setName(memberDTO.getName());
			s.setEmail(memberDTO.getEmail());
			session.setAttribute("member", s);
		}
		
		mv.setViewName("redirect:./memberPage");
		
		return mv;
	}
	
	// 4.
	@GetMapping("memberUpdate")
	public ModelAndView setMemberUpdate()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		
		return mv;
	}
	
	// 3.
	@GetMapping("memberPage")
	public ModelAndView getMemberPage()throws Exception{
		ModelAndView mv = new ModelAndView();

//		// getOne을 memberFileDTO에 리턴해서 file변수에 담아서 보내는 방식
//		// memberFile이랑 memberUser 쿼리문에서 각각 정보를 가져올 때,
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		MemberFileDTO memberFileDTO = memberUserService.getOne(memberDTO);
//		mv.addObject("file", memberFileDTO);
		mv.setViewName("member/memberPage");
		return mv;
	}

	// 2.
	@GetMapping("memberLogOut")
	public ModelAndView getMemberLogOut(HttpSession session) throws Exception{
		// 웹 브라우저 종료
		// 일정시간 경과로 종료(로그인 후에 요청이 발생하면 시간이 연장)
		// memberDTO를 null로 대체
		// 유지 시간을 강제로 0으로 변경
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	// 1.
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
		if(memberDTO != null) {
			// 로그인 성공 index 페이지
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else {
			// 로그인 실패(alert), 로그인입력 폼 이동
			mv.addObject("msg", "Login Fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
}
