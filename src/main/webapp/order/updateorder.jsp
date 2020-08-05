<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ItemDTO"%>
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
  <a  href="ClientServlet?mode=clientlist">Profilo</a>
  <a  href="ItemServlet?mode=itemlist">Articoli</a>
  <a class="active" href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ItemDTO u = (ItemDTO) request.getAttribute("dto");%>


<form id="floatleft" action="OrderServlet?mode=update&iditem=<%=u.getId() %>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="ord">Immagine da inserire nell'articolo</label>
    </div>
    <div class="col-75">
      <input type="text" id="immagine" name="immagine" >
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Link del QRCode da inserire nell'articolo</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="link" name="link" > 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>