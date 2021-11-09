<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manager Home Page</title>
	<link rel="stylesheet" href="chome.css">

</head>

<body>
	<div class="topnav">
	  <a class="active" href="#home">Home</a>
	  <a href="#news">News</a>
	  <a href="#contact">Contact</a>
	  <a href="#about">About</a>
	</div>
	
	
     
    		<!-- 	 Task Details 	 -->
    		
    <table>
	  <thead>
	    <tr>
	      <th>Task Id</th>
	      <th>Task Name</th>
	      <th>End Date</th>
	      <th>Manager Name</th>
	      <th>Employee Name</th>
	      <th>Progress</th>
	      <th>Action</th>
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
	    <a href="tregister">
	    <tr>
	      <td>1</td>
	      <td>analysis</td>
	      <td>09-09-2021</td>
	      <td>A</td>
	      <td>B</td>
	      <td>0</td>
	      <td>
	    <button id="button">Updation</button>
      </td>
	    </tr>
	    </a>
	    
	    <tr>
	      <td>1</td>
	      <td>analysis</td>
	      <td>09-09-2021</td>
	      <td>A</td>
	      <td>B</td>
	      <td>0</td>
	    </tr>
	    
	    <tr>
	      <td>1</td>
	      <td>analysis</td>
	      <td>09-09-2021</td>
	      <td>A</td>
	      <td>B</td>
	      <td>0</td>
	    </tr>
	  </tbody>
	</table> 
	
<!-- Popup View -->
	
<div class="bg-modal">
	<div class="modal-contents">

		<div class="close">+</div>
		<img src="" alt="Analysis">
			
	</div>
</div>
<script>
document.getElementById('button').addEventListener("click", function() {
	document.querySelector('.bg-modal').style.display = "flex";
});

document.querySelector('.close').addEventListener("click", function() {
	document.querySelector('.bg-modal').style.display = "none";
});
</script>
<!-- Popup View -->
</body>
</html>