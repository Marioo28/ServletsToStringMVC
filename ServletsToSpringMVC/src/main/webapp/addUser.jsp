<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
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

<form action="user" method="post">
 UserName<input type="text" name="username"><br>
 LastName<input type="text" name="lastname"><br>
 FirstName<input type="text" name="firstname"><br>
 Age<input type="text" name="age"><br>
 Password<input type="text" name="password"><br>
 Type<select name="type">
			<option value="admin">Admin</option>
			<option value="user" selected>User</option>
			</select><br> 
  
  <input type="submit" value="Creeaza user">
</form>

<a href="users">Back</a>

<br>
	<tr>
		<td>${message}</td>
	</tr>
</body>
</html>