package com.bit.day02;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.startup.Tomcat;

public class MyTomcat {

	public static void main(String[] args) {
		Tomcat serve = new Tomcat();
		serve.setPort(8080);
		try {
			serve.addWebapp("/", "C:\\BitFramework\\day02\\src\\main\\webapp");
			serve.start();
			Server server = serve.getServer();
			server.await();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
