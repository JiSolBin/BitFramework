package com.bit.sts07.domain;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao {

	List<DeptVo> findAll() throws SQLException;
	DeptVo findOne(int idx) throws SQLException;
	void insertOne(DeptVo bean) throws SQLException;
	int updateOne(DeptVo bean) throws SQLException;
	int deleteOne(int idx) throws SQLException;
}
