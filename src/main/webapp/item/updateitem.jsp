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
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ItemServlet?mode=itemlist">Items</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ItemDTO u = (ItemDTO) request.getAttribute("dto");%>
<%UserDTO v = (UserDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ItemServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nomw">Nomw</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" value=<%=u.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="descr">Descrizione</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="descr" name="descr" value=<%=u.getDescr()%>> 
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
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="immagine">Immagine</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="immagine" name="immagine" value=<%=u.getImmagine()%>> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="usertype">
  				<option value="ADMIN" <%if(v.getUsertype().equals("ADMIN")) {%>selected<%}%>>ADMIN</option>
  				<option value="USER" <%if(v.getUsertype().equals("USER")) {%>selected<%}%>>USER</option>
			</select>
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>