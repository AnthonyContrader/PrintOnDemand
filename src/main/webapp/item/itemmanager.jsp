<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.ItemDTO"
	import="it.contrader.dto.UserDTO"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Item Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ItemServlet?mode=itemlist">Items</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ItemDTO> list = (List<ItemDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Nome</th>
			<th>Descrizione</th>
			<th>Tipo</th>
			<th>Colore</th>
			<th>Taglia</th>
			<th>Immagine</th>
			<th>QRLink</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ItemDTO u : list) {
		%>
		<tr>
			<td><a href=ItemServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getDescr()%></td>
			<td><%=u.getTipo()%></td>
			<td><%=u.getColore()%></td>
			<td><%=u.getTaglia()%></td>
			<td><%=u.getImmagine()%></td>
			<td><%=u.getLink()%></td>
			<td><a href=UserServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=UserServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ItemServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" placeholder="inserisci nome oggetto">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="descr">Descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="descr" name="descr" placeholder="inserisci descrizione oggetto"> 
    </div>
  </div>
  
   <div class="row">
    <div class="col-25">
     <label for="tipo">Tipo</label>
    </div>
    <div class="col-75">
      <input type="text" id="tipo" name="tipo" placeholder="inserisci tipo oggetto"> 
    </div>
  </div>
  
   <div class="row">
    <div class="col-25">
     <label for="colore">Colore</label>
    </div>
    <div class="col-75">
      <input type="text" id="colore" name="colore" placeholder="inserisci colore oggetto"> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="taglia">Taglia</label>
    </div>
    <div class="col-75">
      <input type="text" id="taglia" name="taglia" placeholder="inserisci taglia oggetto(se possiede taglia)"> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="immagine">Immagine</label>
    </div>
    <div class="col-75">
      <input type="text" id="immagine" name="immagine" placeholder="inserisci immagine da aggiungere all'oggetto"> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="link">Link</label>
    </div>
    <div class="col-75">
      <input type="text" id="link" name="link" placeholder="inserisci QR Link da associare all'immagine"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="usertype">
  				<option value="ADMIN">ADMIN</option>
  				<option value="USER">USER</option>
 
			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>