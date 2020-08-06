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
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ClientServlet?mode=clientlist">Profilo</a>
  <a  href="ItemServlet?mode=itemlist">Articoli</a>
  <a  href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  </div>
<div class="main">

	<%
		List<ClientDTO> list = (List<ClientDTO>) request.getAttribute("list");
	    String usertype=((UserDTO)request.getSession().getAttribute("user")).getUsertype();
	    int userid=((UserDTO)request.getSession().getAttribute("user")).getId();
	    

	%>

<br>

	<table>
		<tr>
		    <th>User ID</th>
			<th>nome</th>
			<th>cognome</th>
			<th>indirizzo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ClientDTO u : list) {
		%>
		<tr>
			<td><a href=ClientServlet?mode=read&idclient=<%=u.getIdclient() %>>
			<%=u.getUserId() %>
				
			</a></td>
			<td> <%=u.getName()%></td>
			<td><%=u.getSurname()%></td>
			<td><%=u.getAddress()%></td>
			<td><a href=ClientServlet?mode=read&update=true&idclient=<%=u.getIdclient()%>>Edit</a>
			</td>
			<td><a href=ClientServlet?mode=delete&idclient=<%=u.getIdclient()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ClientServlet?mode=insert" method="post">

<%if(usertype.compareTo("ADMIN")==0){ 
	%>

 <div class="row">
    <div class="col-25">
      <label for="userID">userID</label>
    </div>
    <div class="col-75">
      <input type="text" id="userID" name="userID" value=""><br />
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