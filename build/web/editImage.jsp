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
        <title>Edit Image</title>
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
            <div class="box-menu1">
                <div class="text">
                    <h2 style="font-family: helvetica;">Edit Image</h2>
                    <form action="uploadImages" method="post" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <td><input type="hidden" name="prID" value="${medic.getPrId()}"></td>
                            </tr>
                            <tr>
                                <td>Current Image</td>
                                <c:if test="${empty medic.getPrImage()}">
                                    <td><img src="image/imagePlaceholder.jpg" class="gambar-display"></td>
                                    </c:if>
                                    <c:if test="${not empty medic.getPrImageString()}">
                                    <td><img src="data:image/jpeg;base64,${medic.getPrImageString()}" class="gambar-display"></td>
                                    </c:if>                            
                            </tr>
                            <tr>
                                <td><label>New Image</label></td>
                                <td><input type="file" name="prImage" required placeholder="Enter product image" class="input1"></td>
                            </tr>
                        </table>
                        <div class="btn1">
                            <button type="submit" class="btnSubmit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
