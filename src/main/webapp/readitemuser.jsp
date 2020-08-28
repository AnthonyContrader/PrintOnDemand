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
		
	</tr>
	<tr>
		<td><%=u.getNome()%></td>
		<td><%=u.getDescrizione()%></td>
		<td><%=u.getTipo()%></td>
		<td> <%=u.getColore()%></td>
		<td> <%=u.getTaglia()%></td>
		
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