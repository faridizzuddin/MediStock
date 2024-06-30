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
        <style>
            table{
                font-family: helvetica;
            }
        </style>
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
                    <form action="addProduct" method="post" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <td><label for="prID">Product ID - Name</label></td>
                                <td>
                                    <select name="prID" class="input1">
                                        <c:forEach var="item" items="${medic}">
                                            <option value="${item.prId}">${item.prId} - ${item.prName}</option>
                                        </c:forEach>                                    
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Product Image</label></td>
                                <td><input type="file" name="prImage" required placeholder="Enter product image" class="input1"></td>
                            </tr>
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
