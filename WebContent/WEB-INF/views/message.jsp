<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Note</title>
</head>
<body>
	<div>
		<c:if test="${message != null }">
			<h2><c:out value="${message}"/></h2>
		</c:if>
	</div>
	<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>