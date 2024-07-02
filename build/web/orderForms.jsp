<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Form</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <style>
            /* Add any additional styles specific to this page */
            /* Example: */
            /* .card-header h2 { color: #333; } */
        </style>
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="container-fluid">
            <div class="row">
                <div class="side" style="height:70vh;">
                    <jsp:include page="SideMenu.jsp"/>
                </div>
                <div class="col-md-9 mt-5">
                    <div class="card">
                        <div class="card-header">
                            <h2>Order Form</h2>
                        </div>
                        <div class="card-body">
                            <form action="insertOrderrr" method="post">
                                <div class="form-group row">
                                    <label class="col-md-3 col-form-label">Customer ID:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="custId" class="form-control" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-3 col-form-label">Order Date:</label>
                                    <div class="col-md-9">
                                        <input type="date" name="orderDate" class="form-control" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-3 col-form-label">Total Amount:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="totalAmount" class="form-control" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-3 col-form-label">Product Name:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="productName" class="form-control" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-9 offset-md-3">
                                        <input type="submit" value="Save" class="btn btn-primary">
                                        <a href="viewAllOrderr" class="btn btn-secondary">View Order</a>
                                        <a href="javascript:history.back()" class="btn btn-secondary">Back</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
