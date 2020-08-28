<%@ page import="it.contrader.dto.UserDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

<div class="navbar">
  <a  href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a  href="/client/getall">Profilo</a>
  <a  href="/item/getall">Articoli</a>
  <a  href="/order/getall?id=0">Ordini</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
  <br>
<div class="main">
	<%
		List<UserDTO> list = (List<UserDTO>) request.getSession().getAttribute("list");
	UserDTO logged=(UserDTO)request.getSession().getAttribute("user");
	String usertype=((UserDTO)request.getSession().getAttribute("user")).getUsertype();    
	long userid=((UserDTO)request.getSession().getAttribute("user")).getId();
	%>

<br>

	<table>
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Usertype</th>
			<%if(usertype.compareTo("ADMIN")==0){ 
	%><th></th>
			<th></th>
		</tr>
			<%
				}
				for (UserDTO u : list) {
			%>
			<tr>
			<%if((u.getId()==userid)||(usertype.compareTo("ADMIN")==0)){ %>
				<td><a href="/user/read?id=<%=u.getId()%>"> <%=u.getUsername()%>
				</a></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getUsertype()%></td>
							<%}%>
			<%if(usertype.compareTo("ADMIN")==0){ 
			%>
				<td><a href="/user/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/user/delete?id=<%=u.getId()%>">Delete</a></td>
						<%}%>

			</tr>
			<%
				}
			%>
		</table>


        <%if(usertype.compareTo("ADMIN")==0){ 
	%>

		<form id="floatright" action="/user/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="username"
						placeholder="inserisci username">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Password</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="password"
						placeholder="inserisci password">
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
			<button type="submit">Insert</button>
		</form>
		<%
		}
%>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>