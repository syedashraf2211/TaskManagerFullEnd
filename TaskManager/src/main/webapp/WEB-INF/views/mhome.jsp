<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manager Home Page</title>
	
	<link rel="stylesheet" href="/chome.css">
	<script src="https://kit.fontawesome.com/56cd219aa6.js" crossorigin="anonymous"></script>
</head>

<body>

			<!--    NAVIGATION BAR   -->
	<div class="navbar">
	  <a href="#home">Task Manager</a>
	  <div class="dropdown" style="float: right;">
	    <button class="dropbtn">Welcome, <c:out value="${mmail}"/>
	      
	    </button>
	    <div class="dropdown-content">
	      <a href="/mng/logout" >Logout</a>
	    </div>
	  </div> 
	</div>
     
    		<!-- 	 Task Details 	 -->
   	<div style="overflow:auto">
	   	<div class="container">
			<form method="POST" action="tregister">  
				<input type="submit" value="Create Task" style="color:black"/>  
			</form>
		</div>
	    <table>
		  <thead>
		    <tr>
		      <th>Task Id</th>
		      <th>Task Name</th>
		      <th>End Date</th>
		      <th>Employee Name</th>
		      <th>Progress</th>
		      <th>Update</th>
		      <th>Delete</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${tinfo}" var="task">
		    	 <c:if test="${task.getMnginf().getEmail() == mmail}">
				    <tr>
					      <td>${task.getTaskId()}</td>
					      <td>${task.getTaskName()}</td>
					      <td>${task.getEndDate()}</td>
					      <td>${task.getEmpinf().getEmail()}</td>
					      <td>${task.getProgress()}</td>
					      <td> <button id="btn1" name="taskid" onclick="window.location='updatetask/${task.getTaskId()}'"><i class="fa fa-pen-square"></i></button> </td>
					      <td> <button id="btn1"  onclick="window.location='deletetask/${task.getTaskId()}'"><i class="fas fa-trash"></i></button> </td>
				    </tr>
			   	</c:if>
		    </c:forEach>
		  </tbody>
		</table> 
	</div>
</body>
</html>
