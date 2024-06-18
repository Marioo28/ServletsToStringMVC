<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (session.getAttribute("auth") == null) {
		response.sendRedirect("login.jsp?message=Please Login First");
		return;
	}
	%>

	<a href="users">Vizualizare users</a>

	<a href="piese">Vizualizare piese</a>

	<a href="logout" method="get">Logout</a>
	<br><br>
	<tr>
		<td>${message}</td>
	</tr>
</body>