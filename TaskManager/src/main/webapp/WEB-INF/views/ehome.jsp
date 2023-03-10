<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Employee Home Page</title>
	<link rel="stylesheet" href="/chome.css">
	<script src="https://kit.fontawesome.com/56cd219aa6.js" crossorigin="anonymous"></script>
</head>
<body>


			<!--    NAVIGATION BAR   -->
			
		 <div class="navbar" style="margin-bottom:10px;">
		  <a href="#home">Task Manager</a>
		  <div class="dropdown float-right" style="float: right;">
		    <button class="dropbtn">Welcome, <c:out value="${empmail}"/> </button>
		    <div class="dropdown-content">
		      <a href="/emp/logout" >Logout</a>
		    </div>
		  </div>
		  </div>
	
				<!-- 	 Task Details 	 -->
    <c:set var = "email" value = "${mmail}" scope = "session" />
    <div style="overflow:auto">
	    <table>
		  <thead>
		    <tr>
		      <th>Task Id</th>
		      <th>Task Name</th>
		      <th>End Date</th>
		      <th>Manager Name</th>
		      <th>Progress</th>
		      <th>Update</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${tinfo}" var="task">
		    	 <c:if test="${task.getEmpinf().getEmail() == empmail}">
				    <tr>
					      <td>${task.getTaskId()}</td>
					      <td>${task.getTaskName()}</td>
					      <td>${task.getEndDate()}</td>
					      <td>${task.getMnginf().getEmail()}</td>
					      <td>${task.getProgress()}</td>
					      <td> <button id="btn1" name="taskid" onclick="window.location='eupdatetask/${task.getTaskId()}'"><i class="fa fa-pen-square"></i></button> </td>
				    </tr>
			   	</c:if>
		    </c:forEach>
		  </tbody>
		</table>
	</div> 

</body>
</html>
