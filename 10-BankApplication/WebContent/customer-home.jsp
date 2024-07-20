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
<title>Customer Home</title>
</head>
<body>
  <div class="container mt-3">
    <div class="row justify-content-center">
      <div class="col-lg-12">
        <div class="border rounded border-secondary bg-secondary text-center p-4">
          <h1>Customer Home</h1>
        </div>
      </div>
    </div>
    <div class="row justify-content-center mt-3">
      <div class="col-lg-12">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid justify-content-center">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link fs-5" href="passbook.jsp" style="margin-right: 10rem;">Passbook</a>
              </li>
              <li class="nav-item">
                <a class="nav-link fs-5" href="new-transaction.jsp" style="margin-right: 10rem;">Transaction</a>
              </li>
              <li class="nav-item">
                <a class="nav-link fs-5 mx-5 mr-5" href="edit-profile.jsp">Edit Profile</a>
              </li>
            </ul>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          </div>
        </nav>
      </div>
    </div>
  </div>
</body>
</html>
