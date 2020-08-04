<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="UserServlet?mode=userlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ClientDTO u = (ClientDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>UserID</th>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Indirizzo</th>
	</tr>
	<tr>
		<td><%=u.getUserId()%></td>
		<td> <%=u.getName()%></td>
		<td> <%=u.getSurname()%></td>
		<td> <%= u.getAddress() %></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>