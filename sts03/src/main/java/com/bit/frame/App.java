package com.bit.frame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.frame.service.UserService;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		// (서비스 빈 + aop 빈 = proxy) 를 get
		UserService service = (UserService) context.getBean("service");
		
		service.setMsg("수정");
		service.printMsg();
		// exception 일 땐 afterMethod 작동X -> ThrowsAdvice
		// service.setSu(3);
		service.printSu();
	}

}
