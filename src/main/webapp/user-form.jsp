<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="cList">Get Data By Criteria</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			Edit User
            		</c:if>
            		<c:if test="${user == null}">
            			Add New User
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        		</c:if>            
            <tr>
                <th> Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Salary: </th>
                <td>
                	<input type="text" name="salary" size="45"
                			value="<c:out value='${user.salary}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td>
                	<input type="text" name="age" size="15"
                			value="<c:out value='${user.age}' />"
                	/>
                </td>
            </tr>
            
            <tr>
                <th>Gender: </th>
                <td>
                	<input type="text" name="gender" size="45"
                			value="<c:out value='${user.gender}' />"
                	/>
                </td>
            </tr>
                        
            <tr>
                <th>Mobile No: </th>
                <td>
                	<input type="text" name="mobile" size="45"
                			value="<c:out value='${user.mobile}' />"
                	/>
                	<input type="hidden" name="status" size="45"
                			value="<c:out value='${user.status}' />"
                	/>
                	<input type="hidden" name="createdBy" size="45"
                			value="<c:out value='${user.createdBy}' />"
                	/>
                	<input type="hidden" name="createdOn" size="45"
                			value="<c:out value='${user.createdOn}' />"
                	/>
                	<input type="hidden" name="modifiedBy" size="45"
                			value="<c:out value='${user.modifiedBy}' />"
                	/>
                	<input type="hidden" name="modifiedOn" size="45"
                			value="<c:out value='${user.modifiedOn}' />"
                	/>
                </td>
            </tr>
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
