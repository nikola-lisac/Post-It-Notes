<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save note</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath}/savenote" commandName="note" method="post">
		<label>Date</label>	
		<sf:input path="date" name="date"/>
		<label>Text</label>	
		<sf:input path="text" name="text"/>
		<sf:hidden name="id" path="id"/>
		<sf:button type="submit" >Save</sf:button>
	</sf:form>
</body>
</html>