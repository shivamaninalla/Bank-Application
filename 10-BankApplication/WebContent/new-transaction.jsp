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
<body>
  <div class="container mt-3">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="p-4 border bg-secondary text-center">
          <h1>New Transaction</h1>
        </div>
      </div>
    </div>
    <div class="row justify-content-center mt-3">
      <div class="col-lg-6">
        <div class="p-4 border bg-light text-center">
          <h2 class="mb-4">TRANSFER</h2> <!-- Added margin-bottom for more space -->
          <form action="user" method="get">
            <input type="hidden" name="UserController" value="newTransaction">
            <div class="form-group mb-4"> <!-- Added margin-bottom for more space -->
              <label for="accountNumber">Account Number</label>
              <input type="text" class="form-control" id="accountNumber" name="receiver_account_number" placeholder="Enter account number" >
            </div>
            <div class="form-group mb-4"> <!-- Added margin-bottom for more space -->
              <label for="amount">Amount</label>
              <input type="text" class="form-control" id="amount" placeholder="Enter amount" name="amount">
            </div>
            <div class="form-group mt-4"> <!-- Added margin-top for more space -->
              <button type="submit" class="btn btn-primary mr-2">Submit</button>
              <button type="reset" class="btn btn-secondary">Cancel</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
