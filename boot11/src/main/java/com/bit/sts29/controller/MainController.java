package com.bit.sts29.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class MainController {

	@RequestMapping("/home")
	public String page1() {
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
