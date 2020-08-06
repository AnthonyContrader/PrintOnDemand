<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.OrderDTO"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.ClientDTO"
	import="it.contrader.dto.ItemDTO"%>
	
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
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="ClientServlet?mode=clientlist">Profilo</a>
  <a  href="ItemServlet?mode=itemlist">Articoli</a>
  <a class="active" href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<OrderDTO> list = (List<OrderDTO>) request.getAttribute("list");
		List<ClientDTO> clist = (List<ClientDTO>) request.getAttribute("clist");
		int artscelto;
		if(request.getAttribute("artscelto")==null) artscelto=0;
		else artscelto=((ItemDTO)request.getAttribute("artscelto")).getId();
		
		%>

<br>

	<table>
		<tr>
			<th>Spedizione</th>
			<th>Articolo</th>
			<th>Data</th>
			<th>Prezzo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (OrderDTO u : list) {
		%>
		<tr>
			<td><a href=ClientServlet?mode=read&idclient=<%=u.getClientId() %>>
					Dettaglio
			</a></td>
			<td><a href=ItemServlet?mode=read&iditem=<%=u.getItemId() %>><%=u.getItemId()%>
			</a></td>
			<td><%=u.getDate()%></td>
			<td><%=u.getPrezzo()%></td>
			<td><a href=OrderServlet?mode=readitem&update=true&iditem=<%=u.getItemId()%>>Personalizza</a>
			</td>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="OrderServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="idcl">Indirizzo</label>
    </div>
   		 <div class="col-75">
 			
 			<%if(!clist.isEmpty()){%>
 			<select id="idcl" name="IDclient">
 			<%
 				for (ClientDTO c: clist){
 			
 			%>
  				<option value=<%=c.getIdclient() %>><%=c.getName() %> , <%=c.getAddress() %></option>
  			<% 
 			}
 			%>
 			</select>
 			<%
 			}else
 			{
 			%>
 			
 			<div class="col-75">
 			<a href="ClientServlet?mode=clientlist">Devi prima creare un indirizzo!</a>
 			</div>
 			
 			<%
 			}
 			%>
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idit">Articolo</label>
    </div>
    <div class="col-75">
       <%
       if(artscelto==0){
       %>
       <a href="ItemServlet?mode=itemlist">Devi prima scegliere l'articolo!</a>
        <%
       }else{
       %>
       <input type="hidden" id="idit" name="IDitem" value=<%=artscelto%>>
       <%=((ItemDTO)request.getAttribute("artscelto")).getName() %>, <%=((ItemDTO)request.getAttribute("artscelto")).getTipo() %> 
       <%}
       %>
    </div>
  </div>
 <!-- 
 <input type="text" id="idit" name="IDitem" placeholder="inserisci l'id dell'item da inserire"> 
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
  </div>--> 
      <%if(artscelto!=0 &&(!clist.isEmpty())){
      %>
      <button type="submit" >Insert</button>
      <%
      }
      %>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>