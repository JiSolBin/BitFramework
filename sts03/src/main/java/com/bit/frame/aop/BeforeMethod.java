package com.bit.frame.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

// AOP를 위해 MethodBeforeAdvice 상속 받음
public class BeforeMethod implements MethodBeforeAdvice {

	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		// method : 메서드 정보를 볼 수 있음 (접근 제한자, 리턴타입, 매개변수 등등)
		// args : 인자
		// target : this (여기선 UserService)
		
		log.debug("before...");
	}
	
}
