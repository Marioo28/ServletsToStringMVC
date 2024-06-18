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
	<form action="login" method="post">
		Username:<input type="text" name="username"><br>
		Password:<input type="password" name="password"><br> 
		Language<select name="language">
			<option value="Ro" selected>Ro</option>
			<option value="En" >En</option>
			</select><br> 
		<input type="submit" value="Login">
	</form>
	<br>
	<!-- primim mesajele din controller -->
	<tr>
		<td>${message}</td>
	</tr>
	
	<!-- primim mesajele din alte jsp-uri -->
	
	<%
	String mesaj = request.getParameter("message");
	if (mesaj != null) {
	%>
	<p><%=mesaj%></p>
	<%
	}
	%>
</body>
</html>