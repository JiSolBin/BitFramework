package com.bit.sts07.domain;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl implements DeptDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<DeptVo> findAll() throws SQLException {
		return sqlSession.selectList("dept.selectAll");
	}

	@Override
	public DeptVo findOne(int idx) throws SQLException {
		return sqlSession.selectOne("dept.selectOne", idx);
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		sqlSession.insert("dept.addOne", bean);
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		// return 안받는 거 아닌가? -> Mybatis에서 update, delete는 무조건 int 리턴
		return sqlSession.update("dept.updateOne", bean);
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		return sqlSession.delete("dept.deleteOne", idx);
	}

}
