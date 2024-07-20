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
			<h1 class="navbar-brand my-2 py-2">Add New Customer</h1>
		</div>
	</nav>

	<hr />

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-body">
				<form action="cutomer" method="post">
					<div class="form-group mb-3">
						<label>First Name</label> <input type="email" class="form-control"
							name="customer-fname" placeholder="Enter email" required />
					</div>

					<div class="form-group mb-3">
						<label>Last Name</label> <input type="email" class="form-control"
							name="customer-lname" placeholder="Enter email" required />
					</div>

					<div class="form-group mb-3">
						<label>Email Address</label> <input type="email"
							class="form-control" name="customer-email" placeholder="Enter email"
							required />
					</div>

					<div class="form-group mb-3">
						<label>Password</label> <input type="password"
							class="form-control" name="customer-password"
							placeholder="Enter password" required />
					</div>

					<div class="form-group row mt-4">
						<div class="col text-center">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
						<div class="col text-center">
							<button type="submit" class="btn btn-secondary" name="action"
								value="cancel">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>