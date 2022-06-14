package com.bit.sts11;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts11.model.DeptDao;

@Controller
public class HomeController {
	
	@Autowired
	DeptDao deptDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@ResponseBody
	public String home(Model model) throws SQLException {
		
		model.addAttribute("list", deptDao.findAll());		
		return "home";
	}
	
}
