package com.bit.frame.service;

// import org.apache.log4j.Logger;

public class UserService {
	
	// 이런 공통 로직을 빼고 핵심 기능만 둠
	// Logger log = Logger.getLogger(this.getClass());
	
	int su;
	String msg;
	
	public void setSu(int su) {
		this.su = su;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String printMsg() {
		// log.debug("printMsg...");
		System.out.println(msg+" 출력");
		return msg;
	}
	
	public void printSu() {
		
		// log.debug("printSu...");
		String[] arr = {"첫", "둘"};
		System.out.println(arr[su]);
	}
}
