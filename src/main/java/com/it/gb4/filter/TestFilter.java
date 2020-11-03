package com.it.gb4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		// qna 로그인한 사람만 접근 가능
		HttpServletRequest req = (HttpServletRequest)request;

		
		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		String result = uri.substring(uri.lastIndexOf("/")+1);
		
		System.out.println("URL : "+url);
		System.out.println("URI : "+uri);
		System.out.println("Result : "+result); // qnaList출력
		
		HttpSession session = req.getSession();

		// 로그인 했냐 안했냐만 확인하는거라 Object타입을 사용
		Object obj = session.getAttribute("member");

		if(result.equals("qnaList") || obj!=null) {
			chain.doFilter(request, response);			
		}else {
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
