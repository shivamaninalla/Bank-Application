<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Login</title>
</head>
<body>
	<nav class="navbar bg-secondary">
		<div class="container-fluid d-flex justify-content-center align-items-center">
			<h1 class="navbar-brand my-2">Bank Management System</h1>
		</div>
	</nav>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Login</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="form-group mb-3">
						<label>Email Address</label>
						<input type="email" class="form-control" name="login-email" placeholder="Enter email" required />
					</div>

					<div class="form-group mb-3">
						<label>Password</label>
						<input type="password" class="form-control" name="login-password" placeholder="Enter password" required />
					</div>

					<div class="form-group mb-3 text-center">
						<label>Login as:</label>
						<div class="form-check form-check-inline ms-3">
							<input class="form-check-input" type="radio" name="userRole" id="admin" value="Admin" required />
							<label class="form-check-label" for="admin">Admin</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="userRole" id="user" value="User" required />
							<label class="form-check-label" for="user">User</label>
						</div>
					</div>

					<div class="form-group row mt-4">
						<div class="col text-center">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
						<div class="col text-center">
							<button type="submit" class="btn btn-secondary" name="action" value="cancel">Cancel</button>
						</div>
					</div>
					<c:if test="${param.error == 'true'}">
						<div class="alert alert-danger text-center mt-3">
							Invalid email or password. Please try again.
						</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
