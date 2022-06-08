package com.bit.sts05.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class UserBefore {

	public void beforeTargetMethod(JoinPoint thisJoinPoint) {
		
		Class cls = thisJoinPoint.getSignature().getDeclaringType();
		String name = thisJoinPoint.getSignature().getName();
		Object[] args = thisJoinPoint.getArgs();
		
		System.out.println("method before run...");
		System.out.println("class : "+cls);
		System.out.println("name : "+name);
		System.out.println(Arrays.toString(args));
	}
}
