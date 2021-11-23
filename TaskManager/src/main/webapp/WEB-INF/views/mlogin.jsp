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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="center">
		<h1>Manager Login</h1>
		
		<c:if test = "${SPRING_SECURITY_LAST_EXCEPTION.message != null }">
			<div class="alert alert-danger" style="margin: auto;margin-bottom:5px;width: fit-content;height: fit-content;">
				<strong> ${SPRING_SECURITY_LAST_EXCEPTION.message} </strong>
			</div>
		</c:if>
		
		<c:if test = "${message != null }">
			<div class="alert alert-warning" style="margin: auto;margin-bottom:5px;width: fit-content;height: fit-content;">
				<strong> ${message} </strong>
			</div>
		</c:if>
		
		
		<form action="/mng/mlogin" method="post">
			
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
			
			<input type="submit" value="SUBMIT"/><br/><br/>
			<div class="signup_link">
				<a href="/mregister">New User? Register here</a>
			</div>
		</form>
	</div>
</body>
</html>