<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order List</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add any additional styles specific to this page */
        /* Example: */
        /* .card-header h2 { color: #333; } */
    </style>
</head>
<body>
    <jsp:include page="HeaderAdmin.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <div class="side" style="height:70vh;padding:0;margin-top:0">
                <jsp:include page="SideMenuAdmin.jsp"/>
            </div>
            <div class="col-md-9">
                <div class="card" style="margin-top:30px;">
                    <div class="card-header">
                        <h2>Order List</h2>
                        <div class="float-right">
                            <a href="adminDashboard.jsp" class="btn btn-primary">Home</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <!-- Table headers -->
                            <tr>
                                <th>Order ID</th>
                                <th>Customer ID</th>
                                <th>Order Date</th>
                                <th>Total Amount</th>
                                <th>Product Name</th>
                            </tr>
                            <!-- Iterate over orders -->
                            <c:forEach var="order" items="${orderList1}">
                                <tr>
                                    <td>${order.orderId}</td>
                                    <td>${order.custId}</td>
                                    <td>${order.orderDate}</td>
                                    <td>${order.totalAmount}</td>
                                    <td>${order.productName}</td>
                                </tr>
                            </c:forEach>
                        </table>
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
