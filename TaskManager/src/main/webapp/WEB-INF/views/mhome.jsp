<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manager Home Page</title>
	<link rel="stylesheet" href="chome.css">

</head>

<body>
     
    		<!-- 	 Task Details 	 -->
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
	  	<tr>
		  	<td colspan="7">
			    <form method="POST" action="tregister">  
		       		<input type="submit" value="Create Task" style="color:black"/>  
		   		</form>
	   		</td>
	    </tr>
	    <c:forEach items="${tinfo}" var="task">
	    	 <c:if test="${task.getMnginf().getEmail() == mmail}">
			    <tr>
				      <td>${task.getTaskId()}</td>
				      <td>${task.getTaskName()}</td>
				      <td>${task.getEndDate()}</td>
				      <td>${task.getEmpinf().getEmail()}</td>
				      <td>${task.getProgress()}</td>
				      <td> <button id="button" name="taskid" onclick="window.location='updatetask/${task.getTaskId()}'">Update</button> </td>
				      <td> <button id="button" onclick="window.location='deletetask/${task.getTaskId()}'">Delete</button> </td>
			    </tr>
		   	</c:if>
	    </c:forEach>
	  </tbody>
	</table> 
</body>
</html>