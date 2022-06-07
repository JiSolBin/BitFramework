package com.bit.sts04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex07Controller {
	
	@RequestMapping("/ex07")
	public String ex07() {
		
		return "ex01";
	}
}
