package com.bit.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.framework.BitController;

public class DeleteController implements BitController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse reps) throws Exception {

		EmpDao dao = new EmpDao();
		dao.deleteOne(Integer.parseInt(req.getParameter("empno")));
		return "redirect:index.bit";
	}

}
