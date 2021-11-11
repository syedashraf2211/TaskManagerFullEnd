<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="ctask.css">
	
	<title>Create Task</title>
</head>
<body style="background: linear-gradient(120deg,#2980b9, #2980b9)">
	<%-- <c:out value = "${email}"/>  --%>
	
	
	<div class="center"> 
			<h1>CREATE TASK</h1>
			<form method="post" action="createtask">
				<div class="txt_field">
					<input type="text" name="TaskName"/>
					<label>Task Name</label>
				</div>
				
				<div class="txt_field">
					<!-- <input type="text" name="Description" required/>
					<label>Task Description</label> -->
					
					<textarea name="description" rows="4" cols="70" placeholder="Task Description" style="margin: 0px; width: 318px; height: 168px;"></textarea>
					
				</div>
								
				<div class="txt_field" >
					 
					<select name="email">
						<option value="add employee">ADD EMPLOYEE</option>
						
						<c:forEach  items="${empdata}" var="emp">
							<option value="${emp.getEmail()}">${emp.getEmail()}</option>    
						</c:forEach> 	 
					</select>
					
					  
				</div>
				
				<div class="txt_field">
					<input type="date" name="Enddate" />
					<label>End Date</label>
				</div>
				<div class="txt_field">
					<input type="text" class="inputClass" name="AssignedBy" value="${email}" />
					<label>Assigned By</label>
				</div>
					
					<input type="submit" value="Save"/>
					<input type="submit" value="Cancel"/>
			</form>
	</div>
</body>
</html>