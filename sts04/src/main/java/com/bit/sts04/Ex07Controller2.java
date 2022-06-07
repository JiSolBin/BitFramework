package com.bit.sts04;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex07Controller2 {
	
	// http://localhost:8080/sts04/ex07_2?id=admin
	@RequestMapping("/ex07_2")
	public String ex07(HttpSession session, String id) {
		
		System.out.println(session.getId());
		System.out.println(id);
		return "ex01";
	}
}
