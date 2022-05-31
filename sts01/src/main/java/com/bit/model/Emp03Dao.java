package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Emp03Dao extends JdbcDaoSupport{
	
	private DataSource dataSource;
	
	public Emp03Dao() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/scott");
		dataSource.setUser("user01");
		dataSource.setPassword("1234");
		super.setDataSource(dataSource);
	}

	public List<EmpVo> selectAll() throws ClassNotFoundException, SQLException{
		
		String sql = "select * from emp";
		
		RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {
			
			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new EmpVo(
						rs.getInt("empno"), rs.getString("ename"),
						rs.getInt("sal"), rs.getString("job")
						);
			}
		};
		
		JdbcTemplate template = getJdbcTemplate();
		return template.query(sql, rowMapper);
	}

	public void insertOne(EmpVo bean) throws ClassNotFoundException, SQLException {
		
		String sql = "insert into emp (empno, ename, sal, job) values (?,?,?,?)";
		JdbcTemplate template = getJdbcTemplate();
		template.update(sql, new Object[] {bean.getEmpno(), bean.getEname(), bean.getSal(), bean.getJob()});
	}

	public EmpVo selectOne(int parseInt) throws SQLException {
		
		String sql = "select * from emp where empno=?";
		
		RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {
			
			@Override
			public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new EmpVo(
						rs.getInt("empno"), rs.getString("ename"),
						rs.getInt("sal"), rs.getString("job")
						);
			}
		};
		
		JdbcTemplate template = getJdbcTemplate();
		return template.queryForObject(sql, new Object[] {parseInt}, rowMapper);
	}

	public int updateOne(EmpVo bean) throws SQLException {
		
		String sql = "update emp set ename=?, sal=?, job=? where empno=?";
		return getJdbcTemplate().update(sql, bean.getEname(), bean.getSal(), bean.getJob(), bean.getEmpno());
	}

	public int deleteOne(int empno) throws SQLException {
		
		String sql = "delete from emp where empno=?";
		return getJdbcTemplate().update(sql, empno);
	}
}
