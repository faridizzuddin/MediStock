<%@page import="java.util.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>View Staff Profile</title>
    <link rel="stylesheet" type="text/css" href="stylesviewprofile.css">

</head>
<body>
    <header>
        <h1>Staff Profile</h1>
    </header>
    <nav>
        <a href="staffDashboard.jsp">Back To Dashboard</a>
    </nav>
    <main>

        <h2>Profile Details</h2>
        <p><strong>IC Number:</strong><c:out value="${user.ic_number}"></p>

            
    </main>
    <footer>
        <p>&copy; 2024 User Management System</p>
    </footer>
</body>
</html>
