<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.OrderDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="OrderServlet?mode=orderlist">Orders</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<OrderDTO> list = (List<OrderDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>IDclient</th>
			<th>IDItem</th>
			<th>data</th>
			<th>prezzo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (OrderDTO u : list) {
		%>
		<tr>
			<td><a href=UserServlet?mode=read&id=<%=u.getOrderId()%>>
					<%=u.getClientId()%>
			</a></td>
			<td><%=u.getItemId()%></td>
			<td><%=u.getDate()%></td>
			<td><%=u.getPrezzo()%></td>
			<!-- <td><a href=UserServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a> -->
			</td>
			<!--<td><a href=UserServlet?mode=delete&id=<%=u.getId()%>>Delete</a>-->
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="OrderServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="idcl">IDClient</label>
    </div>
    <div class="col-75">
      <input type="text" id="idcl" name="IDclient" placeholder="inserisci il tuo id cliente">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idit">Data</label>
    </div>
    <div class="col-75">
      <input type="text" id="idit" name="IDitem" placeholder="inserisci l'id dell'item da ordinare"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="img">Immagine</label>
    </div>
    <div class="col-75">
      <input type="text" id="img" name="immagine" placeholder="inserisci il nome del file dell'immagine da inserire"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="lnk">Link</label>
    </div>
    <div class="col-75">
      <input type="text" id="lnk" name="link" placeholder="inserisci il link del QR Code"> 
    </div>
  </div>
  

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>