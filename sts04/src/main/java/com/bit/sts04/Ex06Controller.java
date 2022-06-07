package com.bit.sts04;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex06Controller {
	
	@RequestMapping("/ex06")
	public void ex06(HttpServletResponse resp) throws IOException {
		
		resp.getWriter().print("ex06 page");
	}
}
