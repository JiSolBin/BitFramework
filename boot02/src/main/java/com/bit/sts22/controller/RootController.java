package com.bit.sts22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.service.DeptWebService;

@Controller
public class RootController {
	
	@Autowired
	DeptWebService deptWebService;

	@GetMapping("/")
	@ResponseBody
	public String index() {
		
		return "Hello world";
	}
	
	@GetMapping("/ex01")
	public String ex01(Model model) {
		
		model.addAttribute("msg", "환영");
		
		// templates 폴더 안의 ex01
		return "ex01";
	}
	
	// 리스트
	@GetMapping("/dept")
	public String list(Model model) {
		
		deptWebService.selectAll(model);
		return "list";
	}
	
	// 입력
	@PostMapping("/dept")
	public String add(Dept bean) {
		
		deptWebService.insert(bean);
		return "redirect:/dept";
	}
	
	// 입력페이지
	@GetMapping("/dept/add")
	public String add() {
		
		return "add";
	}
	
	// 상세페이지
	@GetMapping("/dept/{deptno}")
	public String one(@PathVariable int deptno, Model model){
		
		deptWebService.selectOne(model, "bean", deptno);
		return "detail";
	}
	
	// 수정
	@PutMapping("/dept/{deptno}")
	public String edit(@ModelAttribute Dept bean) {
		
		deptWebService.update(bean);
		return "redirect:/dept";
	}
	
	// 삭제
	@DeleteMapping("/dept/{deptno}")
	public String delete(@PathVariable int deptno) {
		
		deptWebService.delete(deptno);
		return "redirect:/dept";
	}
}
