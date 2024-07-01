<%@page import="java.util.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
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
            <p><strong>IC Number:</strong> ${not empty user ? user.getIc_number() : 'N/A'}</p>
            <p><strong>Username:</strong> ${not empty user ? user.getUsername() : 'N/A'}</p>
            <p><strong>Full Name:</strong> ${not empty user ? user.getStaff_fullname() : 'N/A'}</p>
            <p><strong>Password:</strong> ${not empty user ? user.getPassword() : 'N/A'}</p>
            <p><strong>Address:</strong> ${not empty user ? user.getAddress() : 'N/A'}</p>
            <p><strong>Email Address:</strong> ${not empty user ? user.getEmail() : 'N/A'}</p>
            <p><strong>Phone Number:</strong> ${not empty user ? user.getPhone_no() : 'N/A'}</p>
            <p><strong>Gender:</strong> ${not empty user ? user.getGender() : 'N/A'}</p>
            <p><strong>Position:</strong> ${not empty user ? user.getPosition() : 'N/A'}</p>
            <p><strong>Date Of Birth:</strong> ${not empty user ? user.getDate_of_birth() : 'N/A'}</p>


            <form action="editStaffProfile.jsp" method="get">
                <button type="submit">Edit Password</button>
            </form>


        </main>
        <footer>
            <p>&copy; 2024 User Management System</p>
        </footer>
    </body>
</html>
