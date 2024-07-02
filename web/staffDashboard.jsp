
<%@ page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Staff Dashboard</title>
        <link rel="stylesheet" type="text/css" href="styledashboard.css">

    </head>
    <body>
        <%
            String ic = (String) session.getAttribute("ic");
        %>        
        <jsp:include page="Header.jsp"/>
        <header>
            <h1>Staff Dashboard</h1>
        </header>

        <main>
            <div class="dashboard">
                <h1>Welcome, Staff!</h1>
                <a href="ProductMenu.jsp">Product Menu</a>
                <a href="Stock.jsp">Stock Menu</a>
                <!--            <a href="viewStaffProfile.jsp">Staff Profile</a>-->
                <a href="viewSelectedStaffServlett?ic=${ic}">Staff Profile</a>
                <a href="Supplier.jsp">Supplier</a>
            </div>
        </main>
        <nav>
            <a href="Homepage.jsp">Logout</a> <!-- Logout button added -->
        </nav>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
