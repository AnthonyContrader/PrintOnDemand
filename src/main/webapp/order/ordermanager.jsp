<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.OrderDTO"
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
  <a class="active" href="OrderServlet?mode=itemlist">Orders</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<OrderDTO> list = (List<OrderDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>IDCliente</th>
			<th>IDitem</th>
			<th>data</th>
			<th>prezzo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (OrderDTO u : list) {
		%>
		<tr>
			<td><a href=OrderServlet?mode=read&id=<%=u.getOrderId() %>>
					<%=u.getClientId() %>
			</a></td>
			<td><%=u.getItemId()%></td>
			<td><%=u.getDate()%></td>
			<td><%=u.getPrezzo()%></td>
			<td><a href=UserServlet?mode=read&update=true&id=<%=u.getOrderId()%>>Edit</a>
			</td>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ItemServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="idcl">IDCliente</label>
    </div>
    <div class="col-75">
      <input type="text" id="idcl" name="IDCliente" placeholder="inserisci l'id del cliente cui spedire">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idit">IDitem</label>
    </div>
    <div class="col-75">
      <input type="text" id="idit" name="IDitem" placeholder="inserisci l'id dell'item da inserire"> 
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
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>