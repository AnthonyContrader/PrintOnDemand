<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ItemDTO"
    import="it.contrader.dto.UserDTO"%>
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
  <a class="active" href="/item/getall">Articoli</a>
  <a  href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
  <br>
<div class="main">
<%ItemDTO u = (ItemDTO) request.getSession().getAttribute("dto");
String usertype=((UserDTO)request.getSession().getAttribute("user")).getUsertype();
%>



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
		<td><%=u.getNome()%></td>
		<td><%=u.getDescrizione()%></td>
		<td><%=u.getTipo()%></td>
		<td> <%=u.getColore()%></td>
		<td> <%=u.getTaglia()%></td>
		<%
		if((u.getImmagine()!=null)&& (u.getImmagine().length()>18 ) ){ %>
		<td> <a href="<%=u.getImmagine().substring(18) %>">
		<img class="zoom" src="<%=u.getImmagine().substring(18) %>" alt=""></img>
		<%}else{ %><td><img src="../css/nullimg.png" alt="img non disponibile" width="70" height="70"></img> <%} %>
		</a></td>
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