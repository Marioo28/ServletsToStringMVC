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

<form action="piesa" method="post">
 ID<input type="text" name="id"><br>
 Nume<input type="text" name="nume"><br>
 Categorie<input type="text" name="categorie"><br>
 Stoc<input type="text" name="stoc"><br>
 
  
  <input type="submit" value="Creeaza piesa">
</form>

<a href="piese">Back</a>
</body>
</html>