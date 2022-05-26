package com.bit.frame.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex02Filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Ex02Filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Ex02Filter doFilter");
		
		chain.doFilter(request, response);
		// 체이닝 할 필터가 없으므로 서블릿을 실행시킴
	}

	@Override
	public void destroy() {
		System.out.println("Ex02Filter destroy");
	}

}
