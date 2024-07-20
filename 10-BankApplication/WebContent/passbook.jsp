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

<div class="container mt-3">
    <div class="row justify-content-center">
      <div class="col-12">
        <div class="p-4 border bg-secondary text-center">
          <h1>Passbook</h1>
        </div>
        <table class="table table-striped table-bordered mt-3">
          <thead>
            <tr>
              <th>Sender Account Number</th>
              <th>Receiver Account Number</th>
              <th>Type of Transaction</th>
              <th>Amount</th>
              <th>Date</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="d" items="${data}">
              <tr>
                <td>${d.sender_account_number}</td>
                <td>${d.receiver_account_number}</td>
                <td>${d.transaction_type}</td>
                <td>${d.transaction_amount}</td>
                <td>${d.date_of_transaction}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</body>
</html>