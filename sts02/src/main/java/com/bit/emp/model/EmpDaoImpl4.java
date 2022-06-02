package com.bit.emp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

// connection을 보이게 함으로써 내가 제어할 수 있도록 함
public class EmpDaoImpl4 implements EmpDao {
	
	JdbcTemplate jdbcTemplate;
	
	PlatformTransactionManager transactionManager;

	RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>() {
		
		@Override
		public EmpVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EmpVo(
					rs.getInt("empno"), rs.getInt("sal"), 
					rs.getString("ename"), rs.getString("job"), 
					rs.getDate("hiredate")
					);
		}
	};
	
	public EmpDaoImpl4(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
		this.jdbcTemplate = jdbcTemplate;
		this.transactionManager = transactionManager;
	}

	@Override
	public List<EmpVo> selectAll() throws SQLException {

		// 아래 PreparedStatementCreator는 내부클래스+로컬클래스
		// 실행 하기 전에 쿼리문을 임의적으로 바꾸어버리면 소스코드가 바뀌는 꼴이 됨
		final String sql = "select * from emp";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				// connection으로부터 sql 실행
				return conn.prepareStatement(sql);
			}
		};
		return jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public void insertOne(EmpVo bean) throws SQLException {
		
		// status가 같다 = 동일한 커넥션이다
		// 만약 두개의 커넥션? 두개의 status 만들면 됨
		// status를 받아내는 것은 트랜잭션 매니저가 해줌 (getTransaction)
		// getTransaction의 기준이 되는게 definition, 이것도 두개 만들면 됨
		TransactionStatus status = null;
		TransactionDefinition definition = new DefaultTransactionDefinition();
		status = transactionManager.getTransaction(definition);
		
		try {
			PreparedStatementCreator psc = new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("첫 번째 Connection " + conn.hashCode());
					String sql = "insert into emp (ename, sal, job, empno, hiredate) values (?,?,?,?,now())";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bean.getEname());
					pstmt.setInt(2, bean.getSal());
					pstmt.setString(3, bean.getJob());
					pstmt.setInt(4, bean.getEmpno());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
			
			// 한 번 더 했을 경우 -> 두 번째꺼는 primary key인데 겹쳐서 실패함
			// 하나는 커밋됐고, 두 번째는 rollback 되어야 함 -> 같은 커넥션이어야 함 -> 다른 커넥션임
			// 두 번째에서 롤백 해봤자 첫 번째는 이미 커밋되어버림 -> 하나의 커넥션으로 묶어야 함
			// -> 트랜잭션 주입 받아서 묶기 -> conn.hashCode() 일치함 = 같은 커넥션
			psc = new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					System.out.println("두 번째 Connection " + conn.hashCode());
					String sql = "insert into emp (ename, sal, job, empno, hiredate) values (?,?,?,?,now())";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bean.getEname());
					pstmt.setInt(2, bean.getSal());
					pstmt.setString(3, bean.getJob());
					pstmt.setInt(4, bean.getEmpno());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc);
			transactionManager.commit(status);
		}catch (Exception e){
			transactionManager.rollback(status);
		}
	}

	@Override
	public int updateOne(EmpVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpVo selectOne(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
