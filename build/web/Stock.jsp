<%-- 
    Document   : Stock
    Created on : 18 May 2024, 12:10:56 am
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock</title>
        <link rel="stylesheet" href="Stock.css">
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="content">
            <div class="side">
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="box-menu">
                <div class="stockintf">
                    <form action="viewSelectedMedication" method="post">
                        <table>
                            <tr>
                                <td>
                                    <label for="medication" class="fontPr">Product Name : </label>
                                    <input type="text" name="medication" placeholder="Search by product name " class="inpPr">
                                    <input type="submit" value="Search" class="btnPr">
                                </td>
                            </tr>
                            <tr>
                                <td><a href="viewAllMedication"><input type="submit" value="View All" class="btnPr1"></a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
