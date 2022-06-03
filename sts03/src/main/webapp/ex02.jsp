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
	<h1>if 조건문</h1>
	<c:set value="3" var="su"></c:set>
	<c:if test="${1<su }">
		<p>1 보다 큼</p>
		<c:if test="${su<5 }">
			<p>5 보다 작음</p>
		</c:if>
	</c:if>
	<c:if test="${1>su }">
		<p>1 보다 작음</p>
	</c:if>
	<br>
	<h1>when 조건문</h1>
	<c:choose>
		<c:when test="${su<1 }">
			<p>1보다 작다</p>
		</c:when>
		<c:when test="${su<2 }">
			<p>2보다 작다</p>
		</c:when>
		<c:when test="${su<3 }">
			<p>3보다 작다</p>
		</c:when>
		<c:when test="${su<4 }">
			<p>4보다 작다</p>
		</c:when>
		<c:when test="${su<5 }">
			<p>5보다 작다</p>
		</c:when>
		<c:otherwise>
			<p>5 이상</p>
		</c:otherwise>
	</c:choose>
</body>
</html>