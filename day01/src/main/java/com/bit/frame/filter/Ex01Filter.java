package com.bit.frame.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "key", value="value"))
public class Ex01Filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Ex01Filter init");
		// 먼저 준비가 되어있음
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Ex01Filter doFilter");
		// ex01.bit로 들어가면 뜸
		// 화면은 안 뜸 -> 필터가 먼저 실행 됨
		// Ex02Filter 만들어도 init은 둘 다 되지만 doFilter는 Ex01Filter만 실행 됨
		
		chain.doFilter(request, response);
		// 이거 적어주면 Ex02Filter doFilter도 실행 됨
		// 이전에 했던 next() 체이닝과 비슷함
	}

	@Override
	public void destroy() {
		System.out.println("Ex01Filter destroy");
		// 서버 끌 때 일어남
	}

}
