<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<p>register</p>
	
	
	<sf:form action="${pageContext.request.contextPath}/adduser" method="post" commandName="user">
		<label>Username</label>
		<sf:input path="username" name="username"/>
		<br>
		<div>
		<sf:errors path="username"></sf:errors>
		</div>
		<br>
		<label>Name</label>
		<sf:input path="name" name="name"/>
		<label>Email</label>
		<sf:input path="email" name="email"/>
		<label>Password</label>
		<sf:password path="password" name="password" id="password"/>
		<label>Confirm password</label>
		<input type="password" name="confirmpass" id="confirmpass">
		<div class="matchpass">
		</div>
		<input value="Create" type="submit" />
	</sf:form>
</body>
</html>