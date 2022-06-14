package com.bit.sts11.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bit.sts11.domain.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Dept> findAll(){
		return jdbcTemplate.query("select * from dept", new RowMapper<Dept>() {

			@Override
			public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			}
			
		});
	}
}
