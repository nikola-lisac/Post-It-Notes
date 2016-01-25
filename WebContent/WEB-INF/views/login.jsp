<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
</head>
<body>
	<p>Login</p>
	<c:if test="${param.error != null}">
		<p>Login failed, wrong username or password!</p>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/login" method="post">
		<label>Username:</label>
		<input type="text" name="username">
		<label>Password:</label>
		<input type="password" name="password">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<label><input type="checkbox" name="remember-me" checked="checked">Remember me</label>
		<input type="submit" value="login">
	</form>
</body>
</html>