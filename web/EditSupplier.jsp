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
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="content">
            <div class="side">
                <jsp:include page="SideMenu.jsp"/>
            </div>
            <div class="box-menu">
                <div class="text">
                    <h2>Edit Supplier</h2>
                    <form action="editSupplierServlet" method="post">
                        <input type="hidden" value="${supplier.getSupplierID()}" name="supplierId"> 
                        <table>
                            <tr>
                                <td>Supplier Name</td>
                                <td><input type="text" name="supplierName" placeholder="Enter supplier name" class="input" value="${supplier.getSupplierName()}"></td>
                            </tr>
                            <tr>
                                <td>Phone Number</td>
                                <td><input type="text" name="phoneNumber" placeholder="Enter phone number" class="input1" value="${supplier.getSupplierPhNum()}"></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><input type="email" name="email" placeholder="Enter email" class="input" value="${supplier.getSupplierEmail()}"></td>
                            </tr>
                            <tr>
                                <td>Company Name</td>
                                <td><input type="text" name="companyName" placeholder="Enter company name" class="input" value="${supplier.getSupplierCompanyName()}"></td>
                            </tr>
                            <tr>
                                <td>Storage Location</td>
                                <td><input type="text" name="storageLocation" placeholder="Enter storage location" class="input" value="${supplier.getStorageLocation()}"></td>
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
