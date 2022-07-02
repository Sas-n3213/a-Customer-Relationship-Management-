<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid black;
	text-align: left;
	vertical-align: middle;
}
th, td {
	padding: 8px;
}
thead {
	background-color: #333;
	color: white;
}
thead th {
	width: 25%;
}
tbody tr:nth-child(odd) {
	background-color: #fff;
}
tbody tr:nth-child(even) {
	background-color: #eee;
}
</style>
</head>
<body>
	<h1>Directory - Registered Customers</h1>
	<table>
		<thead>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registeredCustomers}" var="customer">
				<tr>
					<td>${customer.firstname}</td>
					<td>${customer.lastname}</td>
					<td>${customer.email}</td>
					<td>
						<!-- update customer detail --> <a href="update?id=${customer.id}">update</a>
						<!-- delete customer --> <a href="delete?id=${customer.id}">delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="./..">Back to Home</a>
	</p>
</body>
</html>