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


<form id="floatleft" action="/client/update" method="post">

  <div class="row">
    <div class="col-25">
     <label for="nome">Nome</label>
    </div>
    <div class="col-75">
    <input
			type="hidden" id="userID" name="userID" value="<%=u.getUser().getId()%>">
	<input
			type="hidden" id="id" name="id" value="<%=u.getId()%>">
      <input
			type="text" id="nome" name="nome" value="<%=u.getNome()%>"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="cognome">Cognome</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="cognome" name="cognome" value="<%=u.getCognome()%>"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="indirizzo">Indirizzo</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="indirizzo" name="indirizzo" value="<%=u.getIndirizzo()%>"> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>