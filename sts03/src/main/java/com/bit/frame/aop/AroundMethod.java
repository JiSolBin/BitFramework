package com.bit.frame.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class AroundMethod implements MethodInterceptor {
	
	Logger log = Logger.getLogger(this.getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 필터와 비슷한 느낌으로 보면 됨. 체이닝으로 엮듯 엮어야 함
		// return 으로 다음꺼 엮기 (return invocation.proceed())
		// before일 때만 실행 됨 -> try finally로 묶으면 after도 출력
//		try {
//			System.out.println("around before...");
//			return invocation.proceed();
//		} finally {
//			System.out.println("around after...");
//		}
		
		// return 하지 않고 object로 받아서 마지막에 return 해줄 수도 있음
		// 정상적으로 수행했을 때는 잘 작동하지만, exception이 발생하면 before만 하고 after는 작동X
		// proceed()를 try, catch로 감싸면 exception이 발생해도 잘 실행됨
		
		// 만약 after를 catch 블럭에 넣는다면 exception이 발생하지 않을 경우에만 실행 -> exception method 처럼 사용 가능
		// try 블럭에 넣는다면  return 처럼 사용 가능
		// = 내가 원하는 형태로 정교하게 제어할 수 있다!!
		log.debug("around before...");
		Object obj = null;
		try {
			obj = invocation.proceed();
			log.debug("around after...");
		} catch (Exception e) {
		}
		return obj;
	}

}
