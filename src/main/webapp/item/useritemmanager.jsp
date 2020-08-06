<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.ItemDTO"
	import="it.contrader.dto.UserDTO"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Item Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="ClientServlet?mode=clientlist">Profilo</a>
  <a class="active" href="ItemServlet?mode=itemlist">Articoli</a>
  <a  href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Nome</th>
			<th>Descrizione</th>
			<th>Tipo</th>
			<th>Colore</th>
			<th>Taglia</th>
			<th></th>
		</tr>
		<%
			for (ItemDTO u : list) {
		%>
		<tr>
			<td><a href=ItemServlet?mode=read&iditem=<%=u.getId()%>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getDescr()%></td>
			<td><a href="ItemServlet?mode=readitem&tipo=<%=u.getTipo()%>&iditem=<%=u.getId()%>">
					<%=u.getTipo()%></a></td>
			<td><%=u.getColore()%></td>
			<td><%=u.getTaglia()%></td>
			<td><a href=OrderServlet?mode=orderlist&iditem=<%=u.getId()%>>Ordina</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>





</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>