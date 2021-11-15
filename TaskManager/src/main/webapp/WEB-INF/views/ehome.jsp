<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employee Home Page</title>
	<link rel="stylesheet" href="chome.css">
</head>
<body>
	<!-- 	 Task Details 	 -->
    <c:set var = "email" value = "${mmail}" scope = "session" />
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
				      <td> <button id="button" name="taskid" onclick="window.location='updatetask/${task.getTaskId()}'">Update</button> </td>
			    </tr>
		   	</c:if>
	    </c:forEach>
	  </tbody>
	</table> 
</body>
</html>