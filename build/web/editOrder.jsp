<%-- 
    Document   : editOrder
    Created on : 1 Jul 2024, 2:00:00 pm
    Author     : aqila
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Order</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <div class="card">
                <div class="card-header">
                    <h2>Edit Order</h2>
                </div>
                <div class="card-body">
                    <form action="EditOrderr" method="post">
                        <table class="table table-bordered">
                            <tr>
                                <td><input type="hidden" name="orderId" value="${orderid}"></td>
                            </tr>
                            <tr>
                                <td>Customer ID:</td>
                                <td><input type="text" name="custId" value="${custid}" class="form-control" required></td>
                            </tr>
                            <tr>
                                <td>Order Date:</td>
                                <td><input type="date" name="orderDate" value="${orderDate}" class="form-control" required></td>
                            </tr>
                            <tr>
                                <td>Total Amount:</td>
                                <td><input type="text" name="totalAmount" value="${totalAmount}" class="form-control" required></td>
                            </tr>
                            <tr>
                                <td>Product Name:</td>
                                <td><input type="text" name="productName" value="${productName}" class="form-control" required></td>
                            </tr>
                        </table>
                        <div class="text-right">
                            <input type="submit" value="Update" class="btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
