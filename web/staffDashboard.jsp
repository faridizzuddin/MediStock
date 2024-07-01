<!DOCTYPE html>
<html>
<head>
    <title>Staff Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styledashboard.css">

</head>
<body>
           <jsp:include page="Header.jsp"/>
    <header>
        <h1>Staff Dashboard</h1>
    </header>
    
    <main>
        <div class="dashboard">
            <h1>Welcome, Staff!</h1>
            <a href="HomePage.jsp">Home page</a>
            <a href="ProductMenu.jsp">Product Menu</a>
            <a href="viewSelectedStaffServlet?icNo=${ic}">Staff Profile</a>
        </div>
    </main>
    <nav>
        <a href="index.jsp">Logout</a> <!-- Logout button added -->
    </nav>
           <jsp:include page="Footer.jsp"/>

</body>
</html>
