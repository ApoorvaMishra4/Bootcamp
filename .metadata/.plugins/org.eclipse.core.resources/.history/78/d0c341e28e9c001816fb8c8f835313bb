<%@page import="com.jda.model.UserModel"%>
<html>
<head>
</head>
<body>
	<%
		String username = "";
		if (session != null) {
			if (session.getAttribute("user") != null) {
				UserModel user = (UserModel) request.getSession().getAttribute("user");
				username = user.getName();
			} else {
				response.sendRedirect("index.html");
			}
		}
	%>
	Welcome :
	<%=username%>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>