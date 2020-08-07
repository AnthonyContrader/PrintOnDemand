<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PrintOnDemand</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  href="ClientServlet?mode=clientlist">Profilo</a>
  <a  href="ItemServlet?mode=itemlist">Articoli</a>
  <a  href="OrderServlet?mode=orderlist">Ordini</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>
</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>