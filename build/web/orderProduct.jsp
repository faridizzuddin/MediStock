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
        <title>Order Product</title>
        <link rel="stylesheet" href="ProductRegister.css">
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="contentOrder">
            <div class="side">
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="box-menuOrder">
                <div class="text">
                    <h2>Order Product</h2>
                    <form action="SendEmail" method="post">
                        <input type="hidden" name="prID" value="${prId}">
                        <table>
                            <tr>
                                <td>Product Name  </td>
                                <td><input type="text" name="prName" class="input" value="${medic.getPrName()}"></td>
                            </tr>
                            <tr>
                                <td>Quantity </td>
                                <td><input type="text" name="quantity" placeholder="Enter quantity" class="input1" required></td>
                            </tr>
                            <tr>
                                <td>Supplier Name</td>
                                <td><input type="text" name="suppName" class="input" value="${medic.getSupplierName()}"></td>
                            </tr>
                            <tr>
                                <td>Company Name </td>
                                <td><input type="text" name="company" class="input1" value="${medic.getSupplierCompanyName()}"></td>
                            </tr>
                            <tr>
                                <td>Email </td>
                                <td><input type="text" name="email" class="input1" value="${medic.getSupplierEmail()}"></td>
                            </tr>
                        </table>
                        <div class="btn">
                            <button type="submit" class="btnSubmit">Submit Order</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
