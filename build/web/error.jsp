<%-- 
    Document   : error
    Created on : 1 Jul 2024, 3:52:53 pm
    Author     : aqila
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h2>Error</h2>
        </div>
        <div class="card-body">
            <div class="alert alert-danger" role="alert">
                <h4 class="alert-heading">An error occurred!</h4>
                <p>${errorMessage}</p>
                <hr>
                <p class="mb-0">Please go back and try again or contact the system administrator.</p>
            </div>
            <div class="text-right">
                <a href="orderList.jsp" class="btn btn-primary">Back to Order List</a>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
