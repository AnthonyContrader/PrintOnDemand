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
  <a  href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a href="/client/getall">Profilo</a>
  <a class="active" href="/item/getall">Articoli</a>
  <a  href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
<br>
<div class="main">
	<%
		List<ItemDTO> list = (List<ItemDTO>) request.getSession().getAttribute("list");
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
				<%
		int i=0;
			for (ClientDTO u : list) {
				i++;
		%>
			<td><a href="/item/read?iditem=<%=u.getId()%>">
					<%=u.getNome()%>
			</a></td>
			<td><%=u.getDescrizione()%></td>
			<td><a href="/item/read?tipo=<%=u.getTipo()%>&iditem=<%=u.getId()%>">
					<%=u.getTipo()%></a></td>
			<td><%=u.getColore()%></td>
			<td><%=u.getTaglia()%></td>
			<td><a href=/order/getall&iditem=<%=u.getId()%>>Ordina</a>
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