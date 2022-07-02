<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
<style type="text/css">
label {
	display: inline-block;
	width: 80px;
	font-size: 18px;
	margin-right: 20px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<h1>Register a new customer!</h1>
	<h>Enter the details below.</h2>
	<form action="save" method="post">
		<input type="hidden" name="id" value="${customer.id}">
		<label for="firstname">FirstName:</label> <input type="text" name="firstname"
			value="${student.firstname}"><br> <label for="lastname">Lastname:</label>
		<input type="text" name="lastname" value="${student.lastname}"><br>
		<label for="email">Email:</label> <input type="text"
			name="email" value="${customer.email}"><br> <input
			type="submit" value="Submit">
	</form>
	<p>
		<a href="registeredCustomers">Back to Customer List</a>
	</p>
</body>
</html>