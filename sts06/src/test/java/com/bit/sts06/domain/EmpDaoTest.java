package com.bit.sts06.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {
	
	static EmpDao empDao;
	private int cnt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		empDao = ac.getBean(EmpDao.class);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() throws SQLException {
		assertNotNull(empDao);
		assertNotNull(empDao.findAll());
		cnt = empDao.findAll().size();
		assertNotEquals(0, cnt);
		log.debug("size:"+cnt);
	}

	@Test
	public void test2() throws SQLException {
		assertNotNull(empDao);
		try {
			log.debug(empDao.findOne(500).toString());
		}catch (Exception e) {}
		assertNotNull(empDao.findOne(1001));
	}
	
	@Test
	public void test3() throws SQLException {
		assertNotNull(empDao);
		EmpVo target = new EmpVo(801, 1000, "test", "tester", null);
		//int before = empDao.findAll().size(); //cnt
		empDao.insertOne(target);
		//assertEquals(before+1, empDao.findAll().size());
		
		assertEquals(1, empDao.updateOne(target));
		assertEquals(1, empDao.deleteOne(target.getEmpno()));
	}
	
	@Test
	public void test4() throws Exception {
		log.debug("size:"+empDao.findSize());
	}
}
