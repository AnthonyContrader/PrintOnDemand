<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ItemDTO"
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Item</title>
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

<%ItemDTO u = (ItemDTO) request.getSession().getAttribute("dto");%>



<form id="floatleft" action="/item/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" value="<%=u.getNome()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="descrizione">Descrizione</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="descrizione" name="descrizione" value="<%=u.getDescrizione()%>"> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="tipo">Tipo</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="tipo" name="tipo" value=<%=u.getTipo()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="colore">Colore</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="colore" name="colore" value=<%=u.getColore()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="taglia">Taglia</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="taglia" name="taglia" value=<%=u.getTaglia()%>> 
			<input type="hidden" id="id" name="id" value=<%=u.getId()%>> 
    </div>
  </div>
   
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>