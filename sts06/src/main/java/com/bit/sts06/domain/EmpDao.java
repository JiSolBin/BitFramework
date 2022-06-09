package com.bit.sts06.domain;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {

	// 트랜잭션 처리해서 롤백 하려면 throw 해줘야함
	// exception이 기준이 되기 때문 (service, dao)
	List<EmpVo> findAll() throws SQLException;
	
	EmpVo findOne(int idx) throws SQLException;
	
	void insertOne(EmpVo bean) throws SQLException;
	
	int updateOne(EmpVo bean) throws SQLException;
	
	int deleteOne(int idx) throws SQLException;
	
	int findSize() throws SQLException;
}
