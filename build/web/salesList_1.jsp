<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sales List</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp"/>
        <div class="container-fluid">
            <div class="row">
                <div class="side" style="height:70vh">
                    <jsp:include page="SideMenuAdmin.jsp"/>
                </div>
                <div class="col-md-9">
                    <div class="card" style="margin-top:30px">
                        <div class="card-header">
                            <h2>Sales List</h2>
                            <div class="float-right">
                                <a href="adminDashboard.jsp" class="btn btn-primary">Home</a>
                            </div>
                        </div>
                        <div class="card-body">
                            <table class="table table-bordered">
                                <!-- Table headers -->
                                <tr>
                                    <th>Sales ID</th>
                                    <th>Product Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Date</th>
                                </tr>
                                <c:forEach var="sales" items="${salesList1}">
                                    <tr>
                                        <td>${sales.salesId}</td>
                                        <td>${sales.productName}</td>
                                        <td>${sales.quantity}</td>
                                        <td>${sales.price}</td>
                                        <td>${sales.date}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
