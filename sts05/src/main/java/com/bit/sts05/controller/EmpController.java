package com.bit.sts05.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts05.model.EmpDao;
import com.bit.sts05.model.EmpVo;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmpDao<EmpVo> empDao;
	
	@RequestMapping("/")
	public String list(Model model) throws SQLException {
		
		model.addAttribute("list", empDao.findAll());
		return "emp/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insert(@ModelAttribute EmpVo bean) throws SQLException {
		
		empDao.insertOne(bean);
		return "redirect:./";
	}
}
