package com.bit.sts08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bit.sts08.domain.Emp;
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
	
	@GetMapping("/emp/add")
	public String add() {
		
		return "add";
	}
	
	@PostMapping("/emp/")
	public String add(@ModelAttribute("bean") Emp bean, Model model) {
		try {
			empServiceImple.insert(bean);
			return "redirect:./";
		} catch (Exception e){
			model.addAttribute("err", e);
			// redirect 아니니까 같은 request scope, bean이 그대로 전달 됨
			return "add";
		}
	}
	
	@GetMapping("/emp/{empno}")
	public String detail(Model model, @PathVariable int empno) {
		
		model.addAttribute("bean", empServiceImple.detail(empno));
		return "detail";
	}
	
	@PutMapping("/emp/{empno}")
	public String update(@PathVariable int empno, Emp bean) {
		
		empServiceImple.update(bean);
		return "redirect:./"+empno;
	}
}
