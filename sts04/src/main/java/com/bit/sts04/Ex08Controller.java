package com.bit.sts04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex08Controller {
	
	@RequestMapping("/ex08")
	public String ex08() {
		
		return "ex01";
	}
	
	@RequestMapping("/ex09")
	public String ex09() {
		
		return "ex09";
	}
	
	@RequestMapping("/ex10")
	public String ex10(HttpServletRequest req) {
		
		req.setAttribute("msg", "¸Þ½ÃÁö");
		return "ex09";
	}
}
