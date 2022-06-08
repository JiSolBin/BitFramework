package com.bit.sts05.service;

public class MyModuleImpl implements MyModule {

	@Override
	public void func01() {
		System.out.println("첫 번째 기능 실행...");
	}
	
	@Override
	public void func02(int su) {
		System.out.println(su+"를 전달 받은 두 번째 기능 실행...");
	}
	
	@Override
	public String func03() {
		String msg="세 번째";
		System.out.println(msg+"라는 문자열을 전달 받은 세 번째 기능 실행...");
		return msg;
	}
	
	@Override
	public void func04() {
		// ArrayIndexOutOfBoundsException
		Object[] obj = {};
		obj[1] = 1111;
	}
}
