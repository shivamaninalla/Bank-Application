<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<nav class="navbar bg-secondary">
    <div
      class="container-fluid d-flex justify-content-center align-items-center">
      <h1 class="navbar-brand my-2">Bank Management System</h1>
    </div>
  </nav>
	<hr />

	<nav class="navbar bg-body-tertiary">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2 py-2">Add New Account</h1>
		</div>
	</nav>

	<hr />

	<form>
		<div class="container">
			<div class="mb-3">
				<input type="number" class="form-control" name="customer-id"
					placeholder="Enter Customer ID to Search" />
			</div>
			<div class="d-grid gap-2 col-3 mx-auto">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</div>
	</form>

	<div class="container my-5">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email ID</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="customer" items="${theCustomersList}">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.emailId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="d-grid gap-2 col-3 mx-auto mt-2">
			<button class="btn btn-outline-secondary" type="button">Generate
				Account Number</button>
		</div>
	</div>


</body>
</html>