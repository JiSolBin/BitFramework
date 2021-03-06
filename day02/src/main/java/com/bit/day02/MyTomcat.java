package com.bit.day02;

import org.apache.catalina.Context;
import org.apache.catalina.Server;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;


public class MyTomcat {

	public static void main(String[] args) {
		Tomcat serve = new Tomcat();
		serve.setPort(8080);
		try {
			Context cont = serve.addContext("/", "C:\\BitFramework\\day02\\src\\main\\webapp");
			serve.addWebapp("/", "C:\\BitFramework\\day02\\src\\main\\webapp");
			serve.addServlet(cont, "/ex01", (HttpServlet)Class.forName("com.bit.controller.Ex01Controller").newInstance());
			cont.addServletMapping("/ex01", "/ex01");
			
			serve.start();
			Server server = serve.getServer();
			server.await();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
