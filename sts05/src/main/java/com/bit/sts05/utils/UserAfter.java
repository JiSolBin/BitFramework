package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;

public class UserAfter {

	public void afterTargetMethod(JoinPoint thisJoinPoint) {
		System.out.println("method after run...");
	}
}
