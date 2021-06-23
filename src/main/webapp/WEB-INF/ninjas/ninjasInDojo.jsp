<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Show Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-dark bg-light mt-5 p-3">
		<div class="main form-group row mt-5">
			<form:form action="/dojos/${id}" modelAttribute="ninjaByDojo">
			<h3><c:out value="${dojo.name}"/> ninjas!</h3>
				<table class="table table-striped">
					<thead>
						<th>First name</th>
						<th>Last name</th>
						<th>Age</th>
						<th>Dojo</th>
					</thead>
		    		<tbody>
		        		<c:forEach items="${ninjaList}" var="nl">
		        			<tr>
		        				<td><c:out value="${nl.firstName}"/></td>
		            			<td><c:out value="${nl.lastName}"/></td>
		            			<td><c:out value="${nl.age}"/></td>
		            			<td><c:out value="${nl.dojo.name}"/></td>
		        			</tr>
		        		</c:forEach>
		    		</tbody>
				</table>
			</form:form>
			<nav class="navbar mt-3">
				<div class="container-fluid">
					<a href="/dojos/add" class="nav-link text-end">Add a dojo</a>
					<a href="/ninjas/add" class="nav-link text-end">Add a ninja</a>
				</div>
			</nav>
		</div>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>