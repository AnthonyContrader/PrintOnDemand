<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ClientDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Client Manager</title>
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

	<%
		List<ClientDTO> list = (List<ClientDTO>) request.getSession().getAttribute("list");
	    String usertype=((UserDTO)request.getSession().getAttribute("user")).getUsertype();
	    long userid=((UserDTO)request.getSession().getAttribute("user")).getId();
	    

	%>

<br>

	<table>
		<tr>
		    <th>Username</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Indirizzo</th>
			<th></th>
			<th></th>
		</tr>
		<%
		int i=0;
			for (ClientDTO u : list) {
				i++;
		%>
		<tr>
			<td><a href="/client/read?id=<%=u.getId() %>">
			<%=u.getUser().getUsername() %>
				
			</a></td>
			<td> <%=u.getNome()%></td>
			<td><%=u.getCognome()%></td>
			<td><%=u.getIndirizzo()%></td>
			<td><a href="/client/preupdate?id=<%=u.getId()%>">Edit</a>
			</td>
			<td><a href="/client/delete?id=<%=u.getId()%>">Delete</a>
			</td>

		</tr>
		<%
			}
			if(i==0){
		%>
		<td colspan="6">Nessun indirizzo inserito.</tr>
		<%
		}
		%>
	</table>



<form id="floatright" action="/client/insert" method="post">

<%if(usertype.compareTo("ADMIN")==0){ 
	%>

 <div class="row">
    <div class="col-25">
      <label for="userID">userID</label>
    </div>
    <div class="col-75">
      <input type="text" id="userID" name="userID" placeholder="inserisci userID"><br />
    </div>
   </div>
   <%}
else { 
   %>
   <input type="hidden" id="userID" name="userID" value="<%=userid %>" ><br />
   <%}
   %>
  <div class="row">
    <div class="col-25">
      <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="cognome">Cognome</label>
    </div>
    <div class="col-75">
      <input type="text" id="cognome" name="cognome" placeholder="inserisci cognome"> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="indirizzo">Indirizzo</label>
    </div>
    <div class="col-75">
      <input type="text" id="indirizzo" name="indirizzo" placeholder="inserisci indirizzo"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>