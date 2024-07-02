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
        <link href="NavFoot.css" rel="stylesheet">
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
                            <h2>Sales Form</h2>
                        </div>
                        <div class="card-body">
                            <form action="InsertSales" method="post">
                                <table class="table table-bordered">
                                    <tr>
                                        <td>Product Name :</td>
                                        <td><input type="text" name="productName" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Quantity:</td>
                                        <td><input type="number" name="quantity" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Price:</td>
                                        <td><input type="text" name="price" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Sales Date:</td>
                                        <td><input type="date" name="date" class="form-control" required></td>
                                    </tr>
                                </table>
                                <div class="text-right">
                                    <input type="submit" value="Save" class="btn btn-primary">
                                    <a href="viewAllSales" class="btn btn-secondary">View Sales</a>
                                    <a href="javascript:history.back()" class="btn btn-secondary">Back</a>
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
