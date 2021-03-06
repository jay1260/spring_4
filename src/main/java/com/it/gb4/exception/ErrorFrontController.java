package com.it.gb4.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/**")
public class ErrorFrontController {

	@GetMapping("error404")
	public ModelAndView error404()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "존재하지 않는 페이지입니다.");
		mv.setViewName("error/error_Front");
		
		return mv;
	}
}
