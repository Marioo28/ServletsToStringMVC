<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@page import="com.fdm.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
<%if(session.getAttribute("auth")==null){
	response.sendRedirect("login.jsp?message=Please Login First");
	return;
}	
if(session.getAttribute("auth").equals("admin")){
%>
	<table>
		<thead>
			<tr>
				<th>UserName</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Age</th>
				<th>Type</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			Set<User> users = (Set<User>) request.getAttribute("users");
			for (User user : users) {
			%>
			<tr>
				<td><%=user.getUsername()%></td>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getLastName()%></td>
				<td><%=user.getAge()%></td>
				<td><%=user.getType()%></td>
				<td>
					<form action="delete-user" method="post">
						<input type="hidden" name="username" value="<%=user.getUsername()%>">
						<input type="submit" value="Sterge user">
					</form>
					<form action="update-user" method="get">
						<input type="hidden" name="username" value="<%=user.getUsername()%>">
						<input type="submit" value="Updateaza user">
					</form>
				</td>
			</tr>

			<%
			}
			%>

		</tbody>
	</table>
	<a href="add-user">Adaugare user</a>
	<%
	}else {
			User user = (User) session.getAttribute("user");	
			if (user == null) {
	            %>
	            <tr>
	                <td colspan="6">Nu exista niciun utilizator</td>
	            </tr>
	            <%
	            }else {
			%>
			<h2>User info</h2>
			UserName: <%=user.getUsername()%><br>
			LastName: <%=user.getLastName()%><br>
 			FirstName: <%=user.getFirstName()%><br>
 			Age: <%=user.getAge()%><br>
 			Type: <%=user.getType()%><br>
			
	<%
		}
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