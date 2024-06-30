<%-- 
    Document   : ProcessStock
    Created on : 20 May 2024, 8:22:32 pm
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Stock</title>
        <link rel="stylesheet" href="ProcessStock.css">
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="content">
            <div class="side">
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="contentbox">
                <div class="box-menu">
                    <h2 class="tajuk">Product</h2>
                    <div class="stockintf">
                        <table border="1">
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Expired Date</th>
                                <th>Edit</th>
                                <th>Delete</th>
                                <th>Order</th>
                            </tr>
                            <c:forEach var="listpr" items="${list}">
                                <tr>
                                    <td>${listpr.prId}</td>
                                    <td>${listpr.prName}</td>
                                    <td>${listpr.prQty}</td>
                                    <td>${listpr.prExpDate}</td>
                                    <td><a href="EditMedicationRet?prId=${listpr.prId}" class="btnedit">Edit</a></td>
                                    <td><a href="deleteProduct?prId=${listpr.prId}" class="btndel">Delete</a></td>
                                    <td><a href="orderProductRet?prId=${listpr.prId}" class="btnodr">Order</a></td>
                                </tr>
                            </c:forEach> 
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
