package com.bit.sts30.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	DataSource dataSource;

	@RequestMapping("/home")
	public String page1() {
		return "home";
	}
	
	@RequestMapping("/")
	public String page2() throws SQLException {
		log.debug(dataSource.toString());
		log.debug(dataSource.getConnection().toString());
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
