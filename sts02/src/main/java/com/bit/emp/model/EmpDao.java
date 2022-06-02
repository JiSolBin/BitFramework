package com.bit.emp.model;

import java.sql.SQLException;
import java.util.List;

// 느슨한 결합을 위해 만든 인터페이스
public interface EmpDao {

	List<EmpVo> selectAll() throws SQLException;
	
	void insertOne(EmpVo bean) throws SQLException;
	
	int updateOne(EmpVo bean) throws SQLException;
	
	int deleteOne(int num) throws SQLException;
	
	EmpVo selectOne(int num) throws SQLException;
}
