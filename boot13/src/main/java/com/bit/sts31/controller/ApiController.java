package com.bit.sts31.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts31.TokenServiceImpl;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	TokenServiceImpl tokenServiceImpl;
	
	@GetMapping("/create")
	public String create() {
		return tokenServiceImpl.createToken();
	}
	
	@GetMapping("/check")
	public String check(String token) {
		return tokenServiceImpl.getUser(token);
	}
}
