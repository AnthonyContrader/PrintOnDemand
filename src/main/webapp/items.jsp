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
  <a  href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a  href="/client/getall">Profilo</a>
  <a  class="active" href="/item/getall">Articoli</a>
  <a  href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
  <br>
<div class="main">

	<%
		List<ItemDTO> list = (List<ItemDTO>) request.getSession().getAttribute("list");
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
			<th></th>
		</tr>
		<%
			for (ItemDTO u : list) {
		%>
		<tr>
			<td><a href="/item/read?id=<%=u.getId()%>">
					<%=u.getNome()%>
			</a></td>
			<td><%=u.getDescrizione()%></td>
			<td><a href="/item/read?tipo=<%=u.getTipo()%>&id=<%=u.getId()%>">
					<%=u.getTipo()%></a></td>
			<td><%=u.getColore()%></td>
			<td><%=u.getTaglia()%></td>
			<%
			if((u.getImmagine()!=null)&& (u.getImmagine().length()>34 ) ){
			%>
			<td><%=u.getImmagine().substring(34) %></td>
			<%
			}else{
			%>
			<td><%=u.getImmagine() %></td>
			<%
			}
			%>
			<td><%=u.getLink()%></td>
			<td><a href="/item/preupdate?id=<%=u.getId()%>">Edit</a>
			</td>
			<td><a href="/item/delete?id=<%=u.getId()%>">Delete</a>
			</td>
			<td><a href=/order/getall?id=<%=u.getId()%>>Ordina</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form class="artform" id="floatright" action="/item/insert" method="post">
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
     <label for="descrizione">Descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione" name="descrizione" placeholder="inserisci descrizione oggetto"> 
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
  
   

      <button type="submit" >Insert</button>
</form>
</div>

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>