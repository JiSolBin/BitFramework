package com.bit.sts07;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts07.domain.EmpDao;
import com.bit.sts07.domain.EmpVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api")
//@Controller
//@ResponseBody
@RestController
public class ApiController {
	
	@Autowired
	EmpDao empDao;

	@RequestMapping("/test")
	//@ResponseBody
	public Object test() {
		List list = new ArrayList();
		list.add("첫번째");
		list.add("두번째");
		list.add("세번째");
		return list;
	}
	
	//@RequestMapping(value = "/emp", method = RequestMethod.GET)
	@GetMapping("/emp")
	//@ResponseBody
	public List<EmpVo> list() throws SQLException{
		
		List<EmpVo> list = empDao.findAll();
		return list;
	}
	
	@PostMapping("/emp")
	//@ResponseBody
	public void add(EmpVo bean) throws SQLException {
		
		log.info(bean.toString());
		empDao.insertOne(bean);
	}
	
	@GetMapping("/emp/{empno}")
	//@ResponseBody
	public EmpVo detail(@PathVariable int empno) throws SQLException {
		
		EmpVo bean = empDao.findOne(empno);
		return bean;
	}
	
	@PutMapping("/emp/{empno}")
	//@ResponseBody
	public void update(@RequestBody EmpVo bean) {
		
		log.info("update:"+bean.getEmpno());
		
		int result = 0;
		try {
			result = empDao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 우리가 원하는대로 exception 핸들링 가능
		if(result==0)
			throw new IllegalArgumentException("수정 안됨");
	}
}
