<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Update Task</title>
	<link rel="stylesheet" href="/ctask.css">
</head>
<body style="background: linear-gradient(120deg,#2980b9, #2980b9)">
	
	<div class="center">
			
			
			<input type="button" class="close" value="&times;" onclick="window.location='/mvalidate'"/>	
			<h1>UPDATE TASK</h1>

			<form method="post" action="/mng/createtask">
				<div class="txt_field">
					<input type="text" name="TaskId" class="inputClass" value="${tinfo.getTaskId()}" required/>
					<label>Task Id</label>
				</div>
				
				<div class="txt_field">
					<input type="text" name="TaskName" class="inputClass" value="${tinfo.getTaskName()}" required/>
					<label>Task Name</label>
				</div>
				
				<div class="txt_field">
					<!-- <input type="text" name="Description" required/>
					<label>Task Description</label> -->
					
					<textarea name="Description" rows="4" cols="70" placeholder="Task Description" required style="margin: 0px; width: 318px; height: 70px;">${tinfo.getDescription()}</textarea>
					
				</div>
								
				<div class="txt_field" >
					 
					<input type="text" name="email" class="inputClass" value="${tinfo.getEmpinf().getEmail()}" required/>	
					<label>Assigned To</label>
					  
				</div>
				
				<div class="txt_field">
					<input type="date" name="Enddate" required />
					<label>End Date</label>
				</div>
				<div class="txt_field">
					<input type="text" class="inputClass" name="AssignedBy" value = "${mmail}"/>
					<label>Assigned By</label>
				</div>
				<input type="submit" value="Update"/>
			</form>
	</div>

</body>
</html>