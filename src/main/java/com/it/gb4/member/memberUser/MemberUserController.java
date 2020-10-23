package com.it.gb4.member.memberUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {

	@GetMapping("memberLogin")
	public void getMemberLogin() {
		System.out.println("Member Login");
	}
}
