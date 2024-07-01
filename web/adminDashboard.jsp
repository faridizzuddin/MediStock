<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styledashboard.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet"> <!-- Added Google Font -->
</head>
<body>
    <jsp:include page="Header.jsp"/>
    <header>
        <h1>Admin Dashboard</h1>
    </header>
    <main>
        <div class="dashboard">
            <h1>Welcome, Admin!</h1>
            <a href="registerStaff.jsp">Register Staff</a>
            <a href="Sales.jsp">View Sales</a>
            <a href="Products.jsp">View Products</a>
            <a href="viewReports.jsp">View Reports</a>
        </div>
    </main>
    <nav>
        <a href="index.jsp">Logout</a> <!-- Logout button added -->
    </nav>
    <jsp:include page="Footer.jsp"/>
</body>
</html>
