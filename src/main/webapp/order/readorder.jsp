<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Item</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="ClientServlet?mode=clientlist">Profilo</a>
  <a  href="ItemServlet?mode=itemlist">Articoli</a>
  <a class="active" href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%OrderDTO u = (OrderDTO) request.getAttribute("dto");%>


<table>
	<tr> 
			<th>IDCliente</th>
			<th>IDitem</th>
			<th>data</th>
			<th>prezzo</th>
	</tr>
	<tr>
		<td><%=u.getClientId()%></td>
		<td><%=u.getItemId()%></td>
		<td><%=u.getDate()%></td>
		<td> <%=u.getPrezzo()%></td>
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