<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 

			
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>New Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-dark bg-light mt-5 p-3">
		<div class="main form-group row mt-5">
			<h2>New Dojo</h2>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
	    		<!-- select a person from a drop-down of all persons -->
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="name">Name:</form:label>
			        <form:errors class="text-danger" path="name"/>
			        <form:input type="text" class="form-control" path="name"/>
			    </p>  
				<input type="submit" value="Create" class="m-3"/>
			</form:form>
		</div>
		<nav class="navbar mt-3">
			<div class="container-fluid">
				<a href="/ninjas/add" class="nav-link text-end">Add a ninja</a>
			</div>
		</nav>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>