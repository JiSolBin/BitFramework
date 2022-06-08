package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;

public class UserBefore {

	public void beforeTargetMethod(JoinPoint thisJoinPoint) {
		System.out.println("method before run...");
	}
}
