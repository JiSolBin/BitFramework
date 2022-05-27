package com.bit.frame.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.frame.controller.AddController;
import com.bit.frame.controller.IndexController;
import com.bit.frame.controller.ListController;
import com.bit.frame.controller.LoginController;

public class FrontController extends HttpServlet {
	
	String prefix, suffix;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doDo(req, resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		prefix = "/WEB-INF/views/";
		suffix = ".jsp";
		
		String url = req.getRequestURI().substring(req.getContextPath().length());
		String path = "";
		
		MyController controller = null;
		if(url.equals("/index.bit")) {
			controller = new IndexController();
		}
		else if(url.equals("/list.bit")) {
			controller = new ListController();
		}
		else if(url.equals("/login.bit")) {
			controller = new LoginController();
		}else if(url.equals("/add.bit")){
			controller = new AddController();
		}
		
		path = controller.execute(req, resp);
		
		if(path.startsWith("redirect:")) resp.sendRedirect(path.substring("redirect:".length()));
		else {
			path = prefix + path + suffix;
			
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
		}
	}
}
