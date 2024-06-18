<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page isELIgnored="false"%>
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
	if (session.getAttribute("auth").equals("admin")) {
	%>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nume</th>
				<th>Categorie</th>
				<th>Stoc</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			Set<Piesa> piese = (Set<Piesa>) request.getAttribute("pieces");
			if (piese.isEmpty()) {
			%>
			Nu exista piese
			<%
			} else {
			for (Piesa piesa : piese) {
			%>
			<tr>
				<td><%=piesa.getId()%></td>
				<td><%=piesa.getNume()%></td>
				<td><%=piesa.getCategorie()%></td>
				<td><%=piesa.getStoc()%></td>
				<td>
					<form action="delete-piesa" method="post">
						<input type="hidden" name="id" value="<%=piesa.getId()%>">
						<input type="submit" value="Sterge piesa">
					</form>
					<form action="update-stoc" method="get">
						<input type="hidden" name="id" value="<%=piesa.getId()%>">
						<input type="submit" value="Updateaza stoc">
					</form>
				</td>
			</tr>
			<%
			}
			}
			%>

		</tbody>
	</table>
	<a href="add-piesa">Adaugare piesa</a>
	<%
	
	} else {
	%>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nume</th>
				<th>Categorie</th>
				<th>Stoc</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			Set<Piesa> piese = (Set<Piesa>) request.getAttribute("pieces");
			if (piese.isEmpty()) {
			%>
			Nu exista nici o piesa
			<%
			} else {
			for (Piesa piesa : piese) {
			%>
			<tr>
				<td><%=piesa.getId()%></td>
				<td><%=piesa.getNume()%></td>
				<td><%=piesa.getCategorie()%></td>
				<td><%=piesa.getStoc()%></td>
				<td>
					<form action="update-stoc" method="get">
						<input type="hidden" name="id" value="<%=piesa.getId()%>">
						<input type="submit" value="Updateaza stoc">
					</form>
				</td>
			</tr>
			<%
			}
			}
			%>

		</tbody>
	</table>
	<%
	}
	%>
	<a href="welcomeAdministrator">Back</a>

	<a href="logout" method="get">Logout</a>
	<br><br>
	<tr>
		<td>${message}</td>
	</tr>
</body>
</html>
