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
  <a  href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/client/getall">Profilo</a>
  <a  href="/item/getall">Articoli</a>
  <a  href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
  <br>
<div class="main">

<%ItemDTO u = (ItemDTO) request.getSession().getAttribute("dto");%>
<%if(!(boolean) request.getSession().getAttribute("uploaded")){
	%>
	
	
<form id="floatleft" action="/order/upload" method="post" enctype="multipart/form-data">
  <div class="row">
    <div class="col-25">
      <label for="ord">Carica Immagine</label>
    </div>
    <div class="col-70">
    <input type="file" id="img" name="img" accept=".jpg">
    <button type="submit" >Upload</button>
     </div>
     </div>
      
    </form>
<%}else{%>
	<div class="uploadd">
     
      <h3 align="center">Upload Completo</h3>
    
    
     </div>
	 <%} %>

<form id="floatleft" action="/item/custom" method="post" enctype="multipart/form-data">
  <% if((boolean) request.getSession().getAttribute("uploaded")){%>
  <input type="hidden" id="immagine" name="immagine" value="..\<%=request.getSession().getAttribute("path")%>" >
  <% 
  }else{ %> 
    <input type="hidden" id="immagine" name="immagine" value="" >
    <%} %>
  <div class="row">
    <div class="col-25">
     <label for="pass">Inserisci QRCode </label>
    </div>
    <div class="col-70">
      <input type="text" id="link" name="link" > 
			<input type="hidden" id="id" name="id" value=<%=u.getId()%>>
			</div>
			 <button type="submit" align="center">Personalizza</button>
    
  </div>
      
     
      
     
</form>

	
</div>

<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>