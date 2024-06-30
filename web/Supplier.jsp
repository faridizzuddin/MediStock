<%-- 
    Document   : ProductMenu
    Created on : 18 May 2024, 12:11:14 am
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ProductMenu</title>
        <link rel='stylesheet' href='ProductMenu.css'>
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class='content'>
            <div class='side'>
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="boxProductMenuSupp">
                <div class="button">
                    <a href="AddSupplier.jsp"><input type="button" value="Add Supplier" class="btnRegister"></a>
                    <a href="viewAllSupplier"><input type="button" value=" View Supplier " class="btnStock"></a>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
