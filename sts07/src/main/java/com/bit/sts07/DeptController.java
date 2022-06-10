package com.bit.sts07;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts07.domain.DeptDao;
import com.bit.sts07.domain.DeptVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptDao deptDao;

	// 리스트
	@GetMapping("/")
	public String list(Model model) throws SQLException {
		
		model.addAttribute("list", deptDao.findAll());
		return "list";
	}
	
	// 추가
	@PostMapping("/")
	public String insert(@ModelAttribute DeptVo bean) throws SQLException {
		
		deptDao.insertOne(bean);
		return "redirect:./";
	}
	
	// 추가 페이지
	@GetMapping("/add")
	public String add() {
		
		return "add";
	}
	
	// 디테일
	@GetMapping("/{1}")
	public String detail(@PathVariable("1") int deptno, Model model) throws SQLException {
		
		model.addAttribute("bean", deptDao.findOne(deptno));
		return "detail";
	}
	
	// 수정 페이지
	@GetMapping("/{1}/edit")
	public String edit(@PathVariable("1") int deptno, Model model) throws SQLException {
		
		model.addAttribute("bean", deptDao.findOne(deptno));
		return "edit";
	}
	
	// 수정
	// post로 받아왔으나 필터가 강제로 put으로 동작하게끔 해줬음
	@PutMapping("/{1}")
	public String update(@PathVariable("1") int deptno, @ModelAttribute DeptVo bean) throws SQLException {
		
		deptDao.updateOne(bean);
		return "redirect:./"+deptno;
	}
	
	@DeleteMapping("/{deptno}")
	public String delete(@PathVariable int deptno) throws SQLException {
		
		deptDao.deleteOne(deptno);
		return "redirect:./";
	}
}
