<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Update Task</title>
	<link rel="stylesheet" href="/ctask.css">
	
</head>
<body>
	
	<div class="center">
			
			
			<input type="button" class="close" value="&times;" onclick="window.location='/mng/mvalidate'"/>	
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
				<!--
				<div class="txt_field">
					<p style="color: #2691d9;">Progress</p>
					<div class="progress">
					  <div class="progress-bar" class="inputClass" role="progressbar" name="Progress" value="${tinfo.getProgress()}" style="width: ${tinfo.getProgress()}%;" aria-valuenow="${tinfo.getProgress()}" aria-valuemin="0" aria-valuemax="100">${tinfo.getProgress()}%</div>
					  
					</div>
					
				</div>
				-->
				<div class="txt_field" style="display:none;">
					<input type="text" class="inputClass" name="Progress" value = "${tinfo.getProgress()}"/>
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