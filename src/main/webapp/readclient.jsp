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
  <a  href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/client/getall">Profilo</a>
  <a  href="/item/getall">Articoli</a>
  <a  href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
<br>

<div class="main">
<%ClientDTO u = (ClientDTO) request.getSession().getAttribute("dto");%>


<table>
	<tr> 
		<th>ClientID</th>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Indirizzo</th>
	</tr>
	<tr>
		<td><%=u.getId()%></td>
		<td> <%=u.getNome()%></td>
		<td> <%=u.getCognome()%></td>
		<td> <%=u.getIndirizzo() %></td>
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