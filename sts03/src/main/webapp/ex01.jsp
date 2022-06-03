<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl</h1>
	<h2>out</h2>
	<ul>
		<li><c:out value="1234"></c:out></li>
		<li><c:out value="3.14"></c:out></li>
		<li><c:out value="문자열"></c:out></li>
		<li><c:out value="값1">중복X</c:out></li>
		<li><c:out value="${null }">el null</c:out></li>
		<li><c:out value="null">문자열</c:out></li>
		<li><c:out default="초기값" value=""></c:out></li>
		<li><c:out default="초기값" value="덮어쓰기"></c:out></li>
		<br>
		<li>장점 : 변수, 제어문 등을 사용 할 수 있음</li>
		<c:set value="abc" var="a1"></c:set>
		<li>${a1 }</li>
		<li><c:out value="${a1 }"></c:out></li>
		<br>
		<c:set var="a2">1234</c:set>
		<li>${a2 }</li>
		<c:set var="a2" scope="request">4321</c:set>
		<li>${a2 } : 1234 출력 됨 default scope는 page라서</li>
		<li>${requestScope.a2 } : requestScope.a2 해주면 4321 출력</li>
		<br>
		<jsp:useBean id="bean" class="com.bit.frame.service.UserService"></jsp:useBean>
		<c:set target="${bean }" value="2222" property="su"></c:set>
		<li>${bean.su }</li>
	</ul>
</body>
</html>