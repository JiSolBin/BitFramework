package com.bit.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.frame.model.EmpDao;

public class ListController implements Controller {

	// @Autowired -> type 매칭을 통해 자동으로 주입 받음 (setter 필요 X)
	@Autowired
	EmpDao empDao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("list", "list", empDao.findAll());
	}

}
