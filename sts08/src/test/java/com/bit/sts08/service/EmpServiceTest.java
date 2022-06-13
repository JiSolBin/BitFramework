package com.bit.sts08.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.bit.sts08.domain.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpServiceTest {

	Model model;
	
	@Autowired
	EmpService empService;
	
	@Test
	public void test1SelectAll() {
		model = new ExtendedModelMap();
		assertNotNull(model);
		empService.selectAll(model);
		
//		int total = (int) model.getAttribute("total");
//		log.debug(total+"");
//		assertNotEquals(0, total);
//		List<Emp> list = (List<Emp>) model.getAttribute("list");
//		for(Emp emp:list) {
//			log.debug(emp.toString());
//			assertNotNull(emp);
//		}
		
		//model에 total, list 모르면
		Map<String, Object> map = model.asMap();
		Set<Entry<String, Object>> entrys = map.entrySet();
		for(Entry<String, Object> entry : entrys) {
			log.debug(entry.getKey());
			log.debug(entry.getValue().toString());
		}
	}

	@Transactional
	@Test
	public void test2Insert() {
		Emp target = new Emp(703, 1000, "test", "tester", null);
		assertEquals(target, empService.insert(target));
	}
	
	@Test
	public void test3Detail() {
		Emp target = new Emp(1000, 1000, "테스트", "잡", null);
		assertEquals(target, empService.detail(target.getEmpno()));
	}
	
	@Transactional
	@Test
	public void test4Update() {
		Emp target = new Emp(1000, 1000, "테스트", "잡", null);
		target.setEname("edit");
		assertEquals(target, empService.update(target));
	}
	
	@Transactional
	@Test
	public void test5Delete() {
		assertTrue(empService.delete(1000));
	}
}
