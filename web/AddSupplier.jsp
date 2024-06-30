<%-- 
    Document   : AddServlet
    Created on : 27 May 2024, 8:07:38 pm
    Author     : Fareed Dinn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Supplier</title>
        <link rel="stylesheet" href="AddSupplier.css">
        <style>
            .btnback{
                padding:0.7vw;
                font-family: helvetica;
                font-size:17px;
                border-radius: 8px;
                box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
                margin-top:1vw;
                margin-bottom:1.3vw;
                width:242px;
                border:0;
                background-color:#FFFADD;
                color:black;
                font-weight:700;
            }
            .btnback:hover{
                box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
                background-color:#4682A9;
                color:white;
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
                    <h2>Add Supplier</h2>
                    <a href="viewSupplier"><p class="btnback">Back to Product Registration</p></a>
                    <form action="addSuppliers" method="post">
                        <table>
                            <tr>
                                <td>Supplier Name</td>
                                <td><input type="text" name="supplierID" placeholder="Enter supplier name" class="input"></td>
                            </tr>
                            <tr>
                                <td>Phone Number</td>
                                <td><input type="text" name="phoneNumber" placeholder="Enter phone number" class="input1" required></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><input type="email" name="email" placeholder="Enter email" class="input1" required></td>
                            </tr>
                            <tr>
                                <td>Company Name</td>
                                <td><input type="text" name="companyName" placeholder="Enter company name" class="input" required></td>
                            </tr>
                            <tr>
                                <td>Storage Location</td>
                                <td><input type="text" name="storageLocation" placeholder="Enter storage location" class="input" required></td>
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
