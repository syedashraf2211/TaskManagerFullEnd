<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manager Login</title>
	<link rel="stylesheet" href="/style.css">
</head>
<body>
	<div class="center">
		<h1>Manager Login</h1>
		${SPRING_SECURITY_LAST_EXCEPTION.message}
		<form action="/mng/mlogin" method="post">
			${message}
			<div class="txt_field">
				 <!--<input type="email" name="mmail" required/>-->
				 <input type = "email" name = "username" required />
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
				<a href="/mregister">New User? Register here</a>
			</div>
		</form>
	</div>
</body>
</html>