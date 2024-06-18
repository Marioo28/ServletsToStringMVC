<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.fdm.model.*"%>
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
	
	
<form action= "update-user" method="post">
<% User user = (User) request.getAttribute("user");
%>
<input type="hidden" name="username" value="<%=user.getUsername()%>">
Username:<%=user.getUsername() %>  <br>
FirstName:<input type="text" name="newFirstName" value="<%=user.getFirstName() %>">  <br>
LastName:<input type="text" name="newLastName" value="<%=user.getLastName() %>"> <br>  
Password:<input type="password" name="newPassword" value="<%=user.getPassword() %>"> <br>  
Age:<input type="number" name="newAge" value="<%=user.getAge() %>"> <br>   
Type:<select name="newType">
		<option value="admin"<%=user.getType().equals("admin") ? "selected" : ""%>>Admin</option>
		<option value="user"<%=user.getType().equals("user") ? "selected" : ""%>>User</option>
		</select><br>

<input type = "submit" value ="Update user"> 
</body>
</html>