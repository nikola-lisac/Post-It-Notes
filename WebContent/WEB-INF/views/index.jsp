<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css" />
	<link href='https://fonts.googleapis.com/css?family=Satisfy'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post-it Notes</title>
</head>
<body>
	<h1>Welcome</h1>

	<a href='<c:url value="/login"/>'>Login</a>
	<a href='<c:url value="/register"/>'>Sign Up</a>
	<sec:authorize access="isAuthenticated()">
		<a href="${pageContext.request.contextPath}/newnote">add note</a>
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<div class="container">
		<c:forEach var="note" items="${notes}">
			<div class="note-container">
				<div class="note">
				<p>
					date:
					<fmt:formatDate value="${note.date}" pattern="dd.MM.yyyy."/>
<%-- 					<c:out value="${note.date}" /> --%>
				</p>

				<p>
					text:
					<c:out value="${note.text}" />
				</p>
				<form action="${pageContext.request.contextPath}/edit" method="post">
					<input type="hidden" name="id" value="${note.id}"> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" name="edit" value="edit">
				</form>
				<form action="${pageContext.request.contextPath}/delete"
					method="post">
					<input type="hidden" name="id" value="${note.id}"> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" name="delete" value="delete">
				</form>
				</div>
			</div>
		</c:forEach>
</div>
	</sec:authorize>
</body>
</html>