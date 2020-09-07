<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.OrdersDTO"
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
  <a  href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a  href="/client/getall">Profilo</a>
  <a  href="/item/getall">Articoli</a>
  <a class="active" href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
  <br>
<div class="main">
	<%
		List<OrdersDTO> list = (List<OrdersDTO>) request.getSession().getAttribute("list");
		List<ClientDTO> clist = (List<ClientDTO>) request.getSession().getAttribute("clist");
		ItemDTO artscelto=(ItemDTO)request.getSession().getAttribute("artscelto");
		request.getSession().setAttribute("uploaded",false);
		//if(artscelto==null) artscelto.setId(0);
		
		
		%>

<br>

	<table>
		<tr>
			<th>Spedizione</th>
			<th>Articolo</th>
			<th>Data</th>
			<th>Prezzo</th>
			<th></th>
		</tr>
		<%
			int i=0;
			for (OrdersDTO u : list) {
				
				i++;
				
		%>
		<tr>
			<td><a href="/client/read?id=<%=u.getClient().getId() %>">
					Dettaglio
			</a></td>
			<td><a href="/item/read?id=<%=u.getItem().getId() %>"><%=u.getItem().getNome()%>
			</a></td>
			<td><%=u.getData()%></td>
			<td><%=u.getPrezzo()%></td>
			<td><a href=/item/precustom?id=<%=u.getItem().getId()%>>Personalizza</a></td>
			

		</tr>
		<%
			}
			if(i==0){
		%>
		<td colspan="6">Nessun ordine effettuato.</tr>
		<%
		}
		%>
	</table>



<form id="floatright" action="/order/insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="idcl">Indirizzo</label>
    </div>
   		 <div class="col-75">
 			
 			<%if(!clist.isEmpty()){%>
 			<select id="client" name="client">
 			<%
 			
 				for (ClientDTO c: clist){
 				
 			%>
  				<option value=<%=c.getId() %>><%=c.getNome() %> , <%=c.getIndirizzo() %></option>
  			<% 
 			}
 			%>
 			</select>
 			<%
 			}else
 			{
 			%>
 			
 			<div class="col-75">
 			<a href="/client/getall">Devi prima creare un indirizzo!</a>
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
       if(artscelto.getId()==0){
       %>
       <a href="/item/getall">Devi prima scegliere l'articolo!</a>
        <%
       }else{
       %>
       <input type="hidden" id="item" name="item" value=<%=artscelto.getId()%>>
       <input type="hidden" id="nome" name="nome" value=<%=artscelto.getNome()%>>
       <input type="hidden" id="descrizione" name="descrizione" value=<%=artscelto.getDescrizione()%>>
       <input type="hidden" id="tipo" name="tipo" value=<%=artscelto.getTipo()%>>
       <input type="hidden" id="colore" name="colore" value=<%=artscelto.getColore()%>>
       <input type="hidden" id="taglia" name="taglia" value=<%=artscelto.getTaglia()%>>
       
       <%= artscelto.getNome() %>, <%=artscelto.getTipo() %> 
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
      <%if(artscelto.getId()!=0 &&(!clist.isEmpty())){
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