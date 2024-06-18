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

<form action= "update-stoc" method="post">
<% Piesa piesa = (Piesa) request.getAttribute("piesa");
%>
<input type="hidden" name="id" value="<%=piesa.getId()%>">
ID:<%=piesa.getId() %>  <br>
Nume:<%=piesa.getNume() %>  <br>
Categorie:<%=piesa.getCategorie() %> <br>  
Stoc:<input type="number" name="newStoc" value="<%=piesa.getStoc()%>"><br>

<input type = "submit" value ="Update stoc"> 
</form>
</body>
</html>