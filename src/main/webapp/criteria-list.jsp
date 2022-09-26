<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criteria Response Data</title>
</head>
<body>
	<center>
		<h1>Criteria Response</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="cList">Get Data By Criteria</a>
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Mobile No</th>
                <th>Status</th>
                <th>Created By</th>
                <th>Created On</th>
                 <th>Modified By</th>
                <th>Modified On</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.salary}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><c:out value="${user.gender}" /></td>
                    <td><c:out value="${user.mobile}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td><c:out value="${user.createdBy}" /></td>
                    <td><c:out value="${user.createdOn}" /></td>
                    <td><c:out value="${user.modifiedBy}" /></td>
                    <td><c:out value="${user.modifiedOn}" /></td>
                   <%--  <td>
                    	<a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${user.id}' />">Delete</a>                    	
                    </td> --%>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>