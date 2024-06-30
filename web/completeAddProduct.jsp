<%-- 
    Document   : completeAddSupplier
    Created on : 30 May 2024, 10:57:33 pm
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Complete Add Product</title>
        <link rel="stylesheet" href="completeAddSupplier.css">
        <style>
            tr{
                text-align: center;
                justify-content: center;
                align-items: center;
            }
            p{
                font-family: helvetica;
                font-size: 1.8vw;
                margin:10px;
            }
            .regis{
                font-size: 1.3vw;
            }
            a{
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class='content'>
            <div class='side'>
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="boxProductMenu">
                <table>
                    <tr>
                        <td><p>${stat}</p></td>
                    </tr>
                    <tr>
                        <td><a href="viewSupplier"><p class="regis">Continue Registration</p></a></td>
                    </tr>
                </table>

            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
