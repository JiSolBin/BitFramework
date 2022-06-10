<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/header.jspf"%>
</head>
<body>
	<%@ include file="template/menu.jspf"%>

	<div class="page-header">
		<h1>
			DEPT Edit Page <small>Edit Data</small>
		</h1>
	</div>
	
	<form action="../${bean.deptno}" method="post">
	  <!-- put으로 작동되게 하려고 넣음 + filter에 HiddenHttpMethodFilter 추가 -->
	  <input type="hidden" name="_method" value="put">
	  
	  <div class="form-group">
	    <label for="deptno">deptno</label>
	    <input type="text" class="form-control" id="deptno" name="deptno" value="${bean.deptno }" readonly>
	  </div>
	  <div class="form-group">
	    <label for="dname">dname</label>
	    <input type="text" class="form-control" id="dname" name="dname" value="${bean.dname }">
	  </div>
	  <div class="form-group">
	    <label for="">loc</label>
	    <input type="text" class="form-control" id="loc" name="loc" value="${bean.loc }">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	  <button type="reset" class="btn btn-default">Reset</button>
	  <button type="button" class="btn btn-default" onclick="history.back();">Back</button>
	</form>
</body>
</html>