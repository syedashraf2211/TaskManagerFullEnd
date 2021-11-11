<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manager Login</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="center">
		<h1>Manager Login</h1>
		<form action="mvalidate" method="post">
			<div class="txt_field">
				 <!--<input type="email" name="mmail" required/>-->
				 <input type = "email" name = "email" required />
				 <label>Email</label>
			</div>
			<div class="txt_field">
				<!--<input type="password" name="mpass" required/>-->
				<input type="password" name="password" required/>
				<label>Password</label>
			</div>
			<div class="pass"> Forget password? </div>
			<input type="submit" value="SUBMIT"/><br/><br/>
			<div class="signup_link">
				<a href="mregister">New User? Register here</a>
			</div>
		</form>
	</div>
</body>
</html>