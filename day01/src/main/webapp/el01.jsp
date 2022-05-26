<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el language (EL 표현식)</h1>
	<p></p>
	<p>${1+2+3+4+5}</p>
	
	<table>
		<tr>
			<th>자료형</th>
			<th>표현식</th>
			<th>EL</th>
			<th></th>
		</tr>
		<tr>
			<td>숫자(정수)</td>
			<td><%=-1234 %></td>
			<td>${-1234 }</td>
			<td></td>
		</tr>
		<tr>
			<td>숫자(실수)</td>
			<td><%=3.14 %></td>
			<td>${3.14 }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자</td>
			<td><%='A' %></td>
			<td>${'' }</td>
			<td>EL은 내용 없어도 ㄱㅊ -> 문자열임 -> 문자 표현 안함</td>
		</tr>
   		<tr>
	         <td>문자</td>
	         <td><%='A' %></td>
	         <td></td>
	         <td>문자 지원안하고, 문자열만 지원</td>
      	</tr>
      	<tr>
	         <td>문자열</td>
	         <td><%="ABC" %></td>
	         <td>${'"ABC"' }</td>
	         <td></td>
     	</tr>
		<tr>
			<td>bool</td>
			<td><%=true %></td>
			<td>${true }</td>
			<td></td>
		</tr>
		<tr>
			<td>object</td>
			<td><%=new java.util.Date() %></td>
			<td></td>
			<td>EL은 전달받아야 쓸 수 있음</td>
		</tr>
		<tr>
			<td>object</td>
			<td>
				<%
				Object a = null;
				out.print(a);
				%>
			</td>
			<td>${null }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산</td>
			<td><%=5/2 %></td>
			<td>${5/2 }</td>
			<td>다 같은데 나누기만 다름</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5%2 %></td>
			<td>${5%2 }</td>
			<td></td>
		</tr>
	</table>
</body>
</html>