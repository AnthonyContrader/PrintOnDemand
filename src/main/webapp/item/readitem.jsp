<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ItemDTO"%>
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
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ClientServlet?mode=clientlist">Profilo</a>
  <a class="active" href="ItemServlet?mode=itemlist">Articoli</a>
  <a class="active" href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ItemDTO u = (ItemDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Tipo</th>
		<th>Colore</th>
		<th>Taglia</th>
		<th>Immagine</th>
		<th>QRLink</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td><%=u.getDescr()%></td>
		<td><%=u.getTipo()%></td>
		<td> <%=u.getColore()%></td>
		<td> <%=u.getTaglia()%></td>
		<td> <%=u.getImmagine()%></td>
		<td> <%=u.getLink()%></td>
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