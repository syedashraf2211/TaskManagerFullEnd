<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Employee Login</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="center">
		<h1>Employee Login</h1>
		<form action="evalidate" method="post">
			<div class="txt_field">
				 <input type="email" name="email" required/>
				 <label>Email</label>
			</div>
			<div class="txt_field">
				<input type="password" name="epass" required/>
				<label>Password</label>
			</div>
			<div class="pass"> Forget password? </div>
			<input type="submit" value="SUBMIT"/><br/><br/>
			<div class="signup_link">
				<a href="eregister">New User? Register here</a>
			</div>
			<div class="signup_link">
				<a href="mlogin">Manager Login</a>
			</div>
		</form>
	</div>
</body>
</html>