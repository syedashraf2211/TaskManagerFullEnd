<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/ctask.css">
	
	<title>Create Task</title>
</head>
<body>
	
	<div class="center">
			
			<input type="button" class="close" value="&times;" onclick="window.location='/mng/mvalidate'"/>
			<h1>CREATE TASK</h1>
			
			<form method="post" action="createtask">
				<div class="txt_field">
					<input type="text" name="TaskName" required/>
					<label>Task Name</label>
				</div>
				
				<div class="txt_field">
					
					<textarea name="description" rows="4" cols="70" placeholder="Task Description" required style="margin: 0px; width: 318px; height: 70px;"></textarea>
					
				</div>
								
				<div class="txt_field" >
					 
					<select name="email" required>
						<option value="add employee">ADD EMPLOYEE</option>
						
						<c:forEach  items="${empdata}" var="emp">
							<option value="${emp.getEmail()}">${emp.getEmail()}</option>    
						</c:forEach> 	 
					</select>
					
					  
				</div>
				
				<div class="txt_field">
					<input type="date" name="Enddate" required />
					<label>End Date</label>
				</div>
				<div class="txt_field">
					<input type="text" class="inputClass" name="AssignedBy" value = "${mmail}"/>
					<label>Assigned By</label>
				</div>
				<input type="submit" value="Save"/>
			</form>
	</div>

</body>
</html>