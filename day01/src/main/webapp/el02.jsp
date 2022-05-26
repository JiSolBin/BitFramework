<%@page import="com.bit.frame.controller.DeptVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>값 전달</h1>
	<%
		String msg1 = "ABCD";
		String[] arr1 = {"item1", "item2", "item3"}; // 배열
		DeptVo bean = new DeptVo(); // 객체 : getter 호출해서 씀 (getter 없으면 500 에러)
		bean.setDeptno(111);
		bean.setDname("test");
		bean.setLoc("seoul");
		
		// ArrayList 가능
		// Set은 JSTL ite 사용해야함
		// map은 key로 꺼내면 됨 (map.get("key1"), map.key1)
	
		// pageContext가 디폴트
		// pageContext에 없으면 request->session->application
		// pageScope, ~Scope 형식으로 끄집어낼 수 있음
		pageContext.setAttribute("msg2", "pageContext");
		request.setAttribute("msg2", "request");
		session.setAttribute("msg2", "session");
		application.setAttribute("msg2", "application");

		application.setAttribute("msg3", arr1);
		pageContext.setAttribute("bean", bean);
	%>

	<p>msg1 = <%=msg1 %></p>
	<p>msg1 = ${msg1 } (출력 안됨. 스코프 상에 올려야 함)</p>
	<p>pageContext = <%=pageContext.getAttribute("msg2") %></p>
	<p>pageContext = ${pageScope.msg2 }</p>
	<p>request = <%=request.getAttribute("msg2") %></p>
	<p>request = ${requestScope.msg2 }</p>
	<p>session = <%=session.getAttribute("msg2") %></p>
	<p>session = ${sessionScope.msg2 }</p>
	<p>application = <%=application.getAttribute("msg2") %></p>
	<p>application = ${applicationScope.msg2 }</p>
	
	<p>arr = ${applicationScope.msg3[0] }</p>
	<p>arr = ${applicationScope.msg3[1] }</p>
	<p>arr = ${applicationScope.msg3[2] }</p>
	<p>arr = ${applicationScope.msg3[3] }(오류 없이 걍 안나옴)</p>
	
	<p>bean = ${bean }</p>
	<p>bean = ${bean.deptno }</p>
	<p>bean = ${bean.dname }</p>
	<p>bean = ${bean.loc }</p>
</body>
</html>