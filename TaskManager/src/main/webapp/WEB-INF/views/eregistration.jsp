<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Employee Registration</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="center">
		<h1>Employee Registration</h1>
		<form method="post" action="/ecreate">
			<div class="txt_field">
				<input type="text" name="ename" required/>
				<label>Name</label>
			</div>
			<div class="txt_field">
				<input type="email" name="email" required/>
				<label>Email</label>
			</div>
			<div class="txt_field">
				<input type="password" name="password" required/>
				<label>Password</label>
			</div>
			<div class="txt_field">
				<input type="password" name="ecpass" required/>
				<label>Confirm password</label>
			</div>
			<div class="txt_field">
				<input type="text" name="designation" required/>
				<label>Designation</label>
			</div>
			<input type="submit" value="SUBMIT"/>
			<div class="signup_link">
				<a href="/">Already have an account? Login here</a>
			</div>
		</form>
	</div>
</body>
</html>