package com.bit.sts06.controller;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts06.domain.EmpDao;
import com.bit.sts06.domain.EmpVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api")
public class ApiController {

	@Autowired
	EmpDao empDao;
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public void list(HttpServletResponse res) throws IOException, SQLException {
		
		res.setContentType("application/json; charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.print("{\"root\":[");
//		boolean bool = true;
//		for(EmpVo bean : empDao.findAll()) {
//			if(bool) {
//				bool = false;
//			}else {
//				out.print(',');
//			}
//			out.print("{\"empno\":"+bean.getEmpno()+",\"ename\":\""+bean.getEname()+"\""
//					+ ",\"hiredate\":\""
//					+(bean.getHiredate()==null?"":bean.getHiredate().getTime())+"\"}");
//		}
//		out.print("]}");
		
		JsonArray arr = new JsonArray();
		
		for(EmpVo bean : empDao.findAll()) {
			JsonObject json = new JsonObject();
			json.addProperty("empno", bean.getEmpno());
			json.addProperty("ename", bean.getEname());
			json.addProperty("hiredate", bean.getHiredate()==null?"":bean.getHiredate().getTime()+"");
			arr.add(json);
		}
		
		res.getWriter().print(arr.toString()); 
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public void add(HttpServletResponse res, @ModelAttribute EmpVo bean) throws SQLException {
		
		log.info("add api param:"+bean);
		empDao.insertOne(bean);
		res.setStatus(HttpServletResponse.SC_OK);
	}
	
	@RequestMapping(value="/emp/{empno}", method = RequestMethod.GET)
	public void detail(@PathVariable("empno") int empno, HttpServletResponse res) 
			throws SQLException, IOException {

		EmpVo bean = empDao.findOne(empno);
		res.setStatus(HttpServletResponse.SC_OK);
		
//		res.getWriter().print("{\"empno\":"+bean.getEmpno()+",\"ename\":\""+bean.getEname()+"\""
//				+ ",\"job\":\""+bean.getJob()+"\",\"sal\":"+bean.getSal()+"}");
		
//		JsonObject json = new JsonObject();
//		json.addProperty("empno", bean.getEmpno());
//		json.addProperty("ename", bean.getEname());
//		json.addProperty("sal", bean.getSal());
//		json.addProperty("job", bean.getJob());
//		res.getWriter().print(json.toString());
		
		// Gson 사용해서 편리하게
		Gson gson = new Gson();
		res.getWriter().print(gson.toJson(bean));
	}
	
	@RequestMapping(value = "/emp/{idx}", method = RequestMethod.PUT)
	public void update(HttpServletResponse res, HttpServletRequest req) 
			throws IOException, SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String msg = br.readLine();
		log.info(msg);
		Gson gson = new Gson();
		EmpVo bean = gson.fromJson(msg, EmpVo.class);
		empDao.updateOne(bean);
		res.setStatus(HttpServletResponse.SC_OK);
	}
}
