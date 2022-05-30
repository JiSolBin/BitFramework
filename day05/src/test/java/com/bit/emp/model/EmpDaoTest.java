package com.bit.emp.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpDaoTest {
	
	EmpDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new EmpDao();
	}

	@Test
	public void testSelectAll() throws SQLException {
		
		// dummy data가 있기 때문에
		assertTrue(dao.selectAll().size()>0);
	}

	@Test
	public void testInsertOne() throws SQLException {
		// dao.conn.setAutoCommit(false);
		EmpVo target = new EmpVo(1002, 1000, "test", "tester");
		dao.insertOne(target);
	}
}
