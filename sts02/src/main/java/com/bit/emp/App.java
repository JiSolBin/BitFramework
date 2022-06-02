package com.bit.emp;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.emp.model.EmpVo;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		// xml로 부터 만들어낸 객체
		EmpVo bean = (EmpVo) ac.getBean("bean");
		System.out.println(bean);
	}

}
