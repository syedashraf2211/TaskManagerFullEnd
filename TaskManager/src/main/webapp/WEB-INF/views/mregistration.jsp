<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manager Registration</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="center">
		<h1>Manager Registration</h1>
		<form method="post" action="mcreate">
			<div class="txt_field">
				<input type="text" name="mname" required/>
				<label>Name</label>
			</div>
			<div class="txt_field">
				<input type="email" name="email" required/>
				<label>Email</label>
			</div>
			<div class="txt_field">
				<input type="password" name="password" id="pass" required/>
				<label>Password</label>
			</div>
			<div class="txt_field">
				<input type="password" name="mcpass" id="cpass" required/>
				<label>Confirm password</label>
			</div> 
			<input type="submit" value="SUBMIT" onclick="Validate()"/>
			<div class="signup_link">
				<a href="mlogin">Already have an account? Login here</a>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
        function Validate() {
            var password = document.getElementById("pass").value;
            var confirmPassword = document.getElementById("cpass").value;
            if (password != confirmPassword) {
                alert("Password doesn't match");
                document.getElementById('pass').value= null;
                document.getElementById('cpass').value= null;
                return false;
            }
            return true;
        }
    </script>
</body>
</html>