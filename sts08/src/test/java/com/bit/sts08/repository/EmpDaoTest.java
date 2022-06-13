package com.bit.sts08.repository;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts08.domain.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpDaoTest {

	@Autowired
	EmpDao empDao;
	
	static int total;
	
	@Test
	public void test1FindAll() {
		assertNotNull(empDao.findAll());
		total = empDao.findAll().size();
	}
	
	@Test
	public void test3FindOne() {
		assertNotNull(empDao.findOne(999));
		log.debug(empDao.findOne(999).toString());
	}
	
	@Transactional
	@Test
	public void test2InsertOne() {
		Emp emp = new Emp(778, 1000, "test", "tester", null);
		assertNotEquals(0, empDao.insertOne(emp));
	}

	@Transactional
	@Test
	public void test4UpdateOne() {
		Emp emp = empDao.findOne(999);
		emp.setEname("edit");
		assertNotEquals(0, empDao.updateOne(emp));
		assertEquals(emp.getEname(), empDao.findOne(emp.getEmpno()).getEname());
		// hashAndEquals에서 날짜 제외해야 함
		// assertEquals(emp, empDao.updateOne(emp));
	}
	
	@Transactional
	@Test
	public void test5DeleteOne() {
		assertNotEquals(0, empDao.deleteOne(999));
		assertNull(empDao.findOne(999));
	}
	
	@Test
	public void test6TotalSize() {
		assertEquals(total, empDao.totalSize());
	}
	
	@Test
	public void test7FindMany() {
		assertTrue(empDao.findMany("test").size()>0);
	}
}
