package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;

public class UserAfter {

	public void afterTargetMethod(JoinPoint thisJoinPoint) {
		System.out.println("method after run...");
	}
	
	public void afterReturningTargetMethod(JoinPoint point, Object retVal) {
		
		System.out.println("after run value:"+retVal);
	}
	
	public void afterThrowingTargetMethod(JoinPoint point, Exception exception) 
			throws Exception {
		
		System.out.println(exception.toString());
	}
}
