<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf" %>
</head>
<body>
<%@ include file="template/menu.jspf" %>

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath }/index.bit">Home</a></li>
  <li class="active">EMP</li>
</ol>
<h3 class="page-header">EMP List</h3>
<table class="table">
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>hiredate</th>
		</tr>
	</thead>
</table>

<%@ include file="template/footer.jspf" %>
</body>
</html>