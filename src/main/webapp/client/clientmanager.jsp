<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Client Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="ClientServlet?mode=clientlist">Client</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ClientDTO> list = (List<ClientDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>User ID</th>
			<th>nome</th>
			<th>cognome</th>
			<th>indirizzo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ClientDTO u : list) {
		%>
		<tr>
			<td><a href=ClientServlet?mode=read&id=<%=u.getUserId()%>>
			</a></td>
			<td> <%=u.getName()%></td>
			<td><%=u.getSurname()%></td>
			<td><%=u.getAddress()%></td>
			<td><a href=ClientServlet?mode=read&update=true&id=<%=u.getUserId()%>>Edit</a>
			</td>
			<td><a href=ClientServlet?mode=delete&id=<%=u.getUserId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ClientServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="client" name="nome" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Cognome</label>
    </div>
    <div class="col-75">
      <input type="text" id="cognome" name="cognome" placeholder="inserisci cognome"> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="pass">Indirizzo</label>
    </div>
    <div class="col-75">
      <input type="text" id="indirizzo" name="indirizzo" placeholder="inserisci indirizzo"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>