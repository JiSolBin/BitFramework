package com.bit.sts08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.sts08.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService empServiceImple; 
	
	@GetMapping("/emp/")
	public String list(Model model) {
		
		empServiceImple.selectAll(model);
		return "list";
	}
}
