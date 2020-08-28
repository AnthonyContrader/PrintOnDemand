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
  <a  href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a  href="/client/getall">Profilo</a>
  <a  href="/item/getall">Articoli</a>
  <a class="active" href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
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