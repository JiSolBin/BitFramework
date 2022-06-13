<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<link rel="stylesheet" type="text/css" href="./webjars/bootstrap/5.1.3/css/bootstrap.min.css">
	<script type="text/javascript" src="./webjars/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript" src="./webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="./">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./emp/">EMP</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./emp/add">EMP_Add</a>
        </li>
       <c:if test="${sessionScope.result eq null }">
        	<li class="nav-item">
	          <a class="nav-link" href="./login/">LOGIN</a>
	        </li>
        </c:if>
        <c:if test="${sessionScope.result eq true }">
        	<li class="nav-item">
	          <a class="nav-link" href="./logout/">LOGOUT</a>
	        </li>
        </c:if>
        <c:if test="${sessionScope.result}">
        	<li class="nav-item">${sessionScope.user }</li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
