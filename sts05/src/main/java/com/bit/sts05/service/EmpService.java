package com.bit.sts05.service;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.bit.sts05.model.EmpVo;

//이 인터페이스 상속받는 모든 클래스에 트랜잭션 처리
//@Transactional(rollbackFor=SQLException.class)
public interface EmpService {

	void selectAll(Model model) throws SQLException;

	void insert(EmpVo bean) throws SQLException;

}