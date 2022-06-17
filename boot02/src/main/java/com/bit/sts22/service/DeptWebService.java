package com.bit.sts22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts22.domain.Dept;
import com.bit.sts22.repository.DeptDao;

@Service
public class DeptWebService {

	@Autowired
	DeptDao deptDao;
	
	public void selectAll(Model model) {
		model.addAttribute("list", deptDao.findAll());
	}
	
	public void insert(Dept bean) {
		deptDao.insertOne(bean);
	}
	
	public void selectOne(String modelName, Model model, int deptno) {
		// 서비스가 model명을 정하면 안됨. 위에도 바꾸는게 맞음!
		model.addAttribute(modelName, deptDao.findOne(deptno));
	}
	
	// 오버로드
	public void selectOne(Model model, String modelName, int deptno) {
		model.addAttribute(modelName, deptDao.findOne(deptno));
	}

	public int update(Dept bean) {
		
		return deptDao.updateOne(bean);
	}
	
	public int delete(int deptno) {
		
		return deptDao.deleteOne(deptno);
	}
}
