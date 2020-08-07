<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link href="css/vittoriostyle.css" rel="stylesheet">

<title>Registrati</title>
</head>
<body class="bg">

<form class="login" id="floatright" action="RegistrationServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="username" placeholder="inserisci username">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="password" placeholder="inserisci password"> 
    </div>
  </div>

         <div>
			<button type="submit" value="Registrati" name="pulsante">Registrati</button>
			<input type="button" value="Indietro"onClick="javascript:history.back()" name="button">
		</div>
		</form>


</body>
</html>