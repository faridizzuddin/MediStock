<%-- 
    Document   : editSalesForm
    Created on : 2 Jul 2024, 12:34:04 PM
    Author     : nafiesa
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Sales</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="container-fluid">
            <div class="row">
                <div style="height:70vh">
                    <jsp:include page="SideMenu.jsp"/>
                </div>
                <div class="col-md-9">
                    <div class="card" style="margin-top:30px">
                        <div class="card-header">
                            <h2>Edit Sales</h2>
                        </div>
                        <div class="card-body">
                            <form action="EditSales" method="post">
                                <table class="table table-bordered">
                                    <tr>
                                        <td><input type="hidden" name="salesId" value="${salesId}"></td>
                                    </tr>
                                    <tr>
                                        <td>Product Name :</td>
                                        <td><input type="text" name="productName" value="${productName}" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Quantity :</td>
                                        <td><input type="number" name="quantity" value="${quantity}" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Price :</td>
                                        <td><input type="text" name="price" value="${price}" class="form-control" required></td>
                                    </tr>
                                    <tr>
                                        <td>Sales Date :</td>
                                        <td><input type="date" name="date" value="${DATE}" class="form-control" required></td>
                                    </tr>
                                </table>
                                <div class="text-right">
                                    <input type="submit" value="Update" class="btn btn-primary">
                                    <a href="viewAllSales" class="btn btn-secondary">View Sales</a>
                                    <a href="javascript:history.back()" class="btn btn-secondary">Back</a>
                                </div>
                            </form>
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
