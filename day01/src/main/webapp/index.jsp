<html>
<body>
	<h2>Hello World!</h2>
	<p>param : <%=request.getParameter("id") %></p>
	<form method="post">
		<input type="text" name="id">
		<button>submit</button>
	</form>
</body>
</html>
