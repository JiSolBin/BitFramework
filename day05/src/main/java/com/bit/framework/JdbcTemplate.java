package com.bit.framework;

import java.sql.*;

import javax.sql.DataSource;

public class JdbcTemplate {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSource;
	
	public JdbcTemplate() {}
	
	public JdbcTemplate(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int executeUpdate(String sql, Object[] objs) throws SQLException {

		 try{
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			return pstmt.executeUpdate();
		 }finally {
			close();
		 }
	}
	
	private void close() throws SQLException {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
}
