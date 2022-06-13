package com.bit.sts08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts08.domain.Emp;
import com.bit.sts08.repository.EmpDao;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao empDao;
	
	@Override
	public void selectAll(Model model) {
		model.addAttribute("list", empDao.findAll());
		model.addAttribute("total", empDao.totalSize());
	}
	
	@Transactional
	@Override
	public Emp insert(Emp bean) {
		empDao.insertOne(bean);
		return empDao.findOne(bean.getEmpno());
	}
	
	@Override
	public Emp detail(int empno) {
		return empDao.findOne(empno);
	}
	
	@Override
	public Emp update(Emp bean) {
		empDao.updateOne(bean);
		return empDao.findOne(bean.getEmpno());
	}
	
	@Override
	public boolean delete(int empno) {
		return empDao.deleteOne(empno)>0;
	}
}
