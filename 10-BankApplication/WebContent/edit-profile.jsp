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
<title>Edit Profile</title>
</head>
<body>
<div class="container mt-3">
  <div class="row justify-content-center">
    <div class="col-12">
      <div class="p-4 border bg-secondary text-center">
        <h1>Edit Profile</h1>
      </div>
    </div>
  </div>
  <div class="row justify-content-center mt-3">
    <div class="col-lg-6">
      <div class="p-4 border bg-light text-center">
        <form action="user" method="get">
          <input type="hidden" name="UserController" value="editProfile">
          <div class="form-group mb-4"> 
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" placeholder="Enter First Name" value="${data.first_name}" name="first_name"> 
          </div>
          <div class="form-group mb-4"> 
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" placeholder="Enter Last Name" value="${data.last_name}" name="last_name">
          </div>
          <div class="form-group mb-4"> 
            <label for="password">Password</label>
            <input type="text" class="form-control" id="password" placeholder="Enter Password" value="${data.password}" name="password">
          </div>
          <div class="form-group mt-4"> <!-- Added margin-top for more space -->
            <button type="submit" class="btn btn-primary mr-2">Update</button>
            <button type="reset" class="btn btn-secondary">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
