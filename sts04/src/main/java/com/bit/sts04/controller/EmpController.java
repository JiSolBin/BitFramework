package com.bit.sts04.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts04.model.EmpDao;
import com.bit.sts04.model.EmpVo;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	
	@Autowired
	EmpDao<EmpVo> empDao;

	@RequestMapping("list")
	public void list(Model model) throws SQLException {
		
		model.addAttribute("list", empDao.findAll());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {}
	
	// �Ķ���� ���� �� @RequestParam ���� ������ (���� ���·� ���� ����)
	// but �Ķ���� name�� �������� �ٸ� ��� ���� �Ұ��� 
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String insert(@RequestParam("empno") int empno, @RequestParam("ename") String ename
			, @RequestParam int sal, String job) throws SQLException {
		
		empDao.insertOne(new EmpVo(empno, sal, ename, job, null));
		return "redirect:list";
	}
}
