package com.bit.frame.model;

import java.sql.*;
import java.util.*;

import com.bit.frame.model.entity.EmpVo;

public class EmpDao {

	public List<EmpVo> selectAll() throws SQLException {

		List<EmpVo> list = new ArrayList<>();
		String sql = "select * from emp";

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott";
		String user = "user01";
		String password = "1234";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpVo bean = new EmpVo();
				bean.setEmpno(rs.getInt("empno"));
				bean.setEname(rs.getString("ename"));
				bean.setSal(rs.getInt("sal"));
				bean.setJob(rs.getString("job"));
				list.add(bean);
			}
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

	public void insertOne(int empno, String ename, int sal, String job) throws SQLException {

		String sql = "insert into emp (empno,ename,sal,job) values(?,?,?,?)";
		executeUpdate(sql, new Object[] { empno, ename, sal, job });
	}

	public void executeUpdate(String sql, Object[] arr) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++)
				pstmt.setObject(i + 1, arr[i]);
			pstmt.executeUpdate();
		} finally {
			close(conn, pstmt, null);
		}
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

	public void deleteOne(int empno) throws SQLException {

		String sql = "delete from emp where empno=?";
		executeUpdate(sql, new Object[] { empno });
	}
}