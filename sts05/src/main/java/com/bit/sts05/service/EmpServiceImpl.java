package com.bit.sts05.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts05.model.EmpDao;
import com.bit.sts05.model.EmpVo;

//여기에 붙으면 이 클래스에 속한 모든 메서드에 트랜잭션 처리
//@Transactional(rollbackFor=SQLException.class)
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao<EmpVo> empDao;
	
	@Override
	public void selectAll(Model model) throws SQLException {
		
		model.addAttribute("list", empDao.findAll());
	}
	
	//여기에 붙으면 이 메서드만 트랜잭션 처리
	@Transactional(rollbackFor=SQLException.class)
	@Override
	public void insert(EmpVo bean) throws SQLException {
		
		empDao.insertOne(bean);
		
		// 두 번 입력 되도록
		bean.setEmpno(bean.getEmpno()+1);
		empDao.insertOne(bean);
	}
}
