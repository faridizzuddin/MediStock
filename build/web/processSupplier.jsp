<%-- 
    Document   : Supplier
    Created on : 27 May 2024, 8:07:38 pm
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Supplier</title>
        <link rel="stylesheet" href="processSupplier.css"> 
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="content">
            <div class="side">
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="box-menu2">
                <div class="text">
                    <h2>Supplier</h2>
                    <table border="1" width="100%">
                        <tr>
                            <th>Supplier ID</th>
                            <th>Supplier Name</th>
                            <th>Phone Number</th>
                            <th>Email</th>
                            <th>Company Name</th>
                            <th>Storage Location</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="listsupp" items="${listSupplier}">
                            <tr>
                                <td>${listsupp.supplierID}</td>
                                <td>${listsupp.supplierName}</td>
                                <td>${listsupp.supplierPhNum}</td>
                                <td>${listsupp.supplierEmail}</td>
                                <td>${listsupp.supplierCompanyName}</td>
                                <td>${listsupp.storageLocation}</td>
                                <td><a href="editSupplier?supplierId=${listsupp.supplierID}">Edit</a></td>
                                <td><a href="deleteSupplier?supplierId=${listsupp.supplierID}">Delete</a></td>
                            </tr>
                        </c:forEach> 
                    </table>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
