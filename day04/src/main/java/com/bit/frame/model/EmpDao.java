package com.bit.frame.model;

import java.sql.*;
import java.util.*;

import com.bit.frame.model.entity.EmpVo;
import com.bit.frame.util.QueryTemplate;
import com.bit.frame.util.UpdateTemplate;

public class EmpDao {

	public List<EmpVo> selectAll() throws SQLException {

		String sql = "select * from emp";
		QueryTemplate template = new QueryTemplate() {
			
			@Override
			public Object rowMapper(ResultSet rs) throws SQLException {
				EmpVo bean = new EmpVo();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setSal(rs.getInt("sal"));
				bean.setJob(rs.getString("job"));
				
				return bean;
			}
		};
		
		template.setConn(getConnection());
		return template.executeQuery(sql);
	}

	public void insertOne(int empno, String ename, int sal, String job) throws SQLException {

		String sql = "insert into emp (empno,ename,sal,job) values(?,?,?,?)";
		UpdateTemplate template = new UpdateTemplate() {
			
			@Override
			public void setStatement(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, empno);
				pstmt.setString(2, ename);
				pstmt.setInt(3, sal);
				pstmt.setString(4, job);
			}
		};
		
		template.setConn(getConnection());
		template.executeUpdate(sql);
	}
	
	public void deleteOne(int empno) throws SQLException {

		String sql = "delete from emp where empno=?";
		UpdateTemplate template = new UpdateTemplate(getConnection()) {
			
			@Override
			public void setStatement(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, empno);
			}
		};
		
		template.executeUpdate(sql);
	}

	public Object selectOne(int empno) throws SQLException {

		String sql = "select * from emp where empno="+empno;
		QueryTemplate template = new QueryTemplate() {
			
			@Override
			public Object rowMapper(ResultSet rs) throws SQLException {
				EmpVo bean = new EmpVo();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setSal(rs.getInt("sal"));
				bean.setJob(rs.getString("job"));
				
				return bean;
			}
		};
		
		template.setConn(getConnection());
		return (EmpVo) template.queryForObject(sql);
	}
	
	public Connection getConnection() throws SQLException {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott";
		String user = "user01";
		String password = "1234";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(url, user, password);
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

}