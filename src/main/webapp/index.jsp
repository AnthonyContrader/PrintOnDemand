<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Login PRINT ON DEMAND</title>
</head>
<body>

		<form class="login" action="LoginServlet" method="post">

				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username">
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password">
		<div>
			<button type="submit" value="Login" name="pulsante">Login</button>
			<a href="register.jsp"><input type="button" value="Registrati" name="pulsante"></a>
		</div>
		</form>

	
</body>
</html>