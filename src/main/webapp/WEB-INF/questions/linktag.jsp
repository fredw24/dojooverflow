<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Link Tag</title>

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Link Tag</h1>

<h2>${question.name}</h2>
	<form:form action="/questions/link" method="post" modelAttribute="question">
	
	<form:input path="id" type="hidden" value="${question.id}"/>
			
	        <form:label path="tags">List of Tags:</form:label>
	        <form:errors path="tags"/>
	        <form:select path="tags">
		        <c:forEach var="notList" items="${notTag}">
		            <option value="${notList.id}">${notList.name}</option>
		        </c:forEach>
	        </form:select><br><br>
	        <button>Link</button>
	</form:form>

</body>
</html>