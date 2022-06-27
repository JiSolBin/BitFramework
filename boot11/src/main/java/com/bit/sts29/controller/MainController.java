package com.bit.sts29.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping("/home")
	public String page1() {
		
		String msg = "abcd";
		System.out.println(msg);
		// 똑같은 "abcd"를 가지고 encoding을 했지만 결과는 다 다르게 나옴
		// 스프링 부트가 사용하는 암호화 방식, 암호화는 되지만 복호화는 안됨
		System.out.println(passwordEncoder.encode(msg));
		System.out.println(passwordEncoder.encode(msg));
		System.out.println(passwordEncoder.encode(msg));
		// 복호화 안되지만 match 가능
		String msg2 = passwordEncoder.encode(msg);
		System.out.println(passwordEncoder.matches(msg, msg2));
		System.out.println(passwordEncoder.matches(msg, "abcd"));
		
		return "home";
	}
	
	@RequestMapping("/")
	public String page2() {
		return "home";
	}
	
	@RequestMapping("/hello")
	public String page3() {
		return "hello";
	}
	
	@RequestMapping("/login")
	public String page4() {
		return "login";
	}
}
