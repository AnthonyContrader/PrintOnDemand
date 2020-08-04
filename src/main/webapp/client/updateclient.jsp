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
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ClientDTO u = (ClientDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ClientServlet?mode=update&id=<%=u.getUserId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">UserID</label>
    </div>
    <div class="col-75">
      <input type="text" id="client" name="userid" value=<%=u.getUserId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Nome</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="nome" name="nome" value=<%=u.getName()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Cognome</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="cognome" name="cognome" value=<%=u.getSurname()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="pass">Indirizzo</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="indirizzo" name="indirizzo" value=<%=u.getAddress()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>