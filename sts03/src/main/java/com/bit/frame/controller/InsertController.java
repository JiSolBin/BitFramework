package com.bit.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.frame.model.EmpDao;
import com.bit.frame.model.EmpVo;

// AddController 보다 간편한 형태
public class InsertController extends AbstractCommandController{

	@Autowired
	EmpDao empDao;
	
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		// errors.hasErrors() == true 일 경우 insert 처리 안하도록 할 수 있음
		System.out.println(errors.hasErrors());
		
		EmpVo bean = (EmpVo) command;
		empDao.insertOne(bean);
		return new ModelAndView("redirect:list");
		
		// 이러면 내가 아래서 add 한 error를 보내서 처리할 수 있음
		// return new ModelAndView("redirect:list", "err", errors);
	}

	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {

		EmpVo bean = (EmpVo) command;
		if(bean.getEname().isEmpty()) {
			ObjectError error = new ObjectError("ename", "이름 비었음");
			errors.addError(error);
		}
		
		System.out.println(errors);
	}
}
