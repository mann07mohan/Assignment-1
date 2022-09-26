<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criteria Form</title>
</head>
<body>
	<div align="center">
		<form action="getCList" method="post">
			<label for="criteria">Choose Criteria :</label>
  			<select name="criteria" id="criteria">
    			<!-- <option value="id">Id</option> -->
   				<option value="name">Name</option>
    			<option value="salary">Salary</option>
    			<option value="gender">Gender</option>
    			<option value="age">Age</option>
    			<option value="status">Status</option>
  			</select>
  			<input type="text" size="45" name="cValue">
  			<br><br>
  			<input type="submit" value="Submit">
		</form>
	</div>
	
</body>
</html>