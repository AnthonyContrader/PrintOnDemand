<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ClientServlet?mode=clientlist">Profilo</a>
  <a  href="ItemServlet?mode=itemlist">Articoli</a>
  <a  href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  </div>
<br>

<div class="main">

<%ClientDTO u = (ClientDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ClientServlet?mode=update&idclient=<%=u.getIdclient()%>" method="post">
  <div class="row">
    <div class="col-25">
     <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="nome" name="nome" value="<%=u.getName()%>"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="cognome">Cognome</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="cognome" name="cognome" value="<%=u.getSurname()%>"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="indirizzo">Indirizzo</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="indirizzo" name="indirizzo" value="<%=u.getAddress()%>"> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>