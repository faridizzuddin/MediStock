<%-- 
    Document   : ProductRegister
    Created on : 27 May 2024, 12:23:50 pm
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Registration</title>
        <link rel="stylesheet" href="ProductRegister.css">
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="content">
            <div class="side">
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="box-menu">
                <div class="text">
                    <h2>Product Registration</h2>
                    <form action="EditMedication" method="post">
                        <input type="hidden" name="prID" value="${prID}">
                        <table>
                            <tr>
                                <td>Supplier Name</td>
                                <td>
                                    <select class="input1" name="supplierId">
                                        <option value="${medic.getSupplierID()}"> ${medic.getSupplierName()}</option>
                                        <c:forEach var="item" items="${list}">
                                            <option value="${item.supplierID}">${item.supplierName}</option>
                                        </c:forEach>                                    
                                    </select>
                                    <a href="AddSupplier.jsp" class="link">add supplier</a>
                                </td>
                            </tr>
                            <tr>
                                <td>Product Name  </td>
                                <td><input type="text" name="prName" placeholder="Enter product name" class="input" value="${medic.getPrName()}"></td>
                            </tr>
                            <tr>
                                <td>Quantity </td>
                                <td><input type="text" name="quantity" placeholder="Quantity" class="input1" value="${medic.getPrQty()}"></td>
                            </tr>
                            <tr>
                                <td>Expired Date </td>
                                <td><input type="date" name="expiredDate" placeholder="Expired Date" class="input1" value="${medic.getPrExpDate()}"></td>
                            </tr>

                            <tr>
                        </table>
                        <div class="btn">
                            <button type="submit" class="btnSubmit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
