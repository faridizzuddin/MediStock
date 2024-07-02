<%-- 
    Document   : orderForm
    Created on : 1 Jul 2024, 3:07:22 pm
    Author     : aqila
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Form</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-9 mt-5">
                    <div class="card">
                        <div class="card-header">
                            <h2>Order Form</h2>
                        </div>
                        <div class="card-body">
                            <form action="insertOrderrr" method="post">

                                <table class="table table-bordered">
                                    <tr>
                                        <td>Customer ID:</td>
                                        <td><input type="text" name="custId" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Order Date:</td>
                                        <td><input type="date" name="orderDate" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Total Amount:</td>
                                        <td><input type="text" name="totalAmount" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Product Name:</td>
                                        <td><input type="text" name="productName" class="form-control" required></td>
                                    </tr>
                                </table>
                                <div class="text-right">
                                    <input type="submit" value="Save" class="btn btn-primary">
                                </div>
                            </form>
                        </div>
                        <a href="viewAllOrderr">View Order</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
