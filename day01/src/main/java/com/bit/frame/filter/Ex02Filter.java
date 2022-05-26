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
import javax.servlet.http.HttpServletRequest;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "encoding", value="euc-kr"))
public class Ex02Filter implements Filter {
	String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Ex02Filter init");
		
		// 서버 시작하자 마자 파라미터 가져와서 encoding 변수에 집어넣음
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Ex02Filter doFilter");
		
		// post방식으로 동작되는 것들 utf-8 인코딩
		HttpServletRequest req = (HttpServletRequest) request;
		if(!"GET".equals(req.getMethod()))
			req.setCharacterEncoding(encoding);
				
		chain.doFilter(request, response);
		// 체이닝 할 필터가 없으므로 서블릿을 실행시킴
	}

	@Override
	public void destroy() {
		System.out.println("Ex02Filter destroy");
	}

}
