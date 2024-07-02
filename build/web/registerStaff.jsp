<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Staff</title>
    <link rel="stylesheet" type="text/css" href="styleslogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script>
        function redirectToHome() {
            alert("Staff registered successfully!");
            window.location.href = "adminDashboard.jsp";
        }

        function validateForm() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirm_password").value;
            var passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*?]).{8,}$/;
            if (!password.match(passwordPattern)) {
                alert("Password must contain at least one capital letter, one number, one special character, and be at least 8 characters long.");
                return false;
            }
            if (password !== confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
        }

        function presetICNumber() {
            var icInput = document.getElementById("ic_number");
            if (icInput.value.length === 6 || icInput.value.length === 9) {
                icInput.value += '-';
            }
        }
        function togglePasswordVisibility(id) {
            var password = document.getElementById(id);
            var eyeIcon = document.getElementById(id + "-eye");
            if (password.type === "password") {
                password.type = "text";
                eyeIcon.classList.remove("fa-eye");
                eyeIcon.classList.add("fa-eye-slash");
            } else {
                password.type = "password";
                eyeIcon.classList.remove("fa-eye-slash");
                eyeIcon.classList.add("fa-eye");
            }
        }
    </script>
</head>
<body>
    <jsp:include page="HeaderAdmin.jsp"/>
    <header>
        <h1>Register Staff</h1>
    </header>
    <nav>
        <a href="adminDashboard.jsp">Dashboard</a>
    </nav>
    <main>
        <form action="registerStaff.jsp" method="post" onsubmit="return validateForm()">
            <label for="ic_number">IC Number:</label>
            <input type="text" id="ic_number" name="ic_number" required oninput="presetICNumber()" pattern="\d{6}-\d{2}-\d{4}" title="IC Number must be in the format 021122-11-0033"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required><br>
            <i id="password-eye" class="fa fa-eye" onclick="togglePasswordVisibility('password')"></i><br>
            <label for="staff_fullname">Full Name:</label>
            <input type="text" id="staff_fullname" name="staff_fullname" required><br>
            <label for="username">Username *</label>
            <input type="text" id="username" name="username" size="15" placeholder="Enter  username" required>
            <label for="address">Address *</label>
            <input type="text" id="address" name="address" size="100" placeholder="Enter address" required>
            <label for="email">Email address *</label>
            <input type="email" id="email" name="email" size="15" placeholder="Enter email address" required>
            <label for="phoneNo">Phone Number*</label>
            <input type="tel" id="phoneNo" name="phoneNo" size="15" placeholder="Enter phone number" required>
            <label for="gender">Gender*</label>
            <select name="gender" id="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            <label for="position">Position*</label>
            <select name="position" id="position" required>
                <option value="Inventory Manager">Inventory Manager</option>
                <option value="Pharmacy Technician">Pharmacy Technician</option>
                <option value="Pharmacist">Pharmacist</option>
            </select>
            <label for="dob">Date of Birth *</label>
            <input type="date" id="dob" name="dob" required>
            <br><br>
            <input type="submit" id="btnSubmit" value="Register">
            <br><br>
            <input type="reset" id="btnReset" value="Cancel">
            <br><!-- <br> -->
        </form>
        <%
            if ("post".equalsIgnoreCase(request.getMethod())) {
                String dbURL = "jdbc:mysql://localhost:3306/medistocknew";
                String dbUser = "root";
                String dbPass = "admin";

                Connection conn = null;
                PreparedStatement psCheck = null;
                PreparedStatement psInsert = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    String icNumber = request.getParameter("ic_number");
                    String password = request.getParameter("password");
                    String staffFullname = request.getParameter("staff_fullname");
                    String username = request.getParameter("username");
                    String address = request.getParameter("address");
                    String emailAddress = request.getParameter("email");
                    String phoneNo = request.getParameter("phoneNo");
                    String gender = request.getParameter("gender");
                    String position = request.getParameter("position");
                    Date dateOfBirth = Date.valueOf(request.getParameter("dob"));

                    // Debugging output
                    out.println("IC Number: " + icNumber + "<br>");
                    out.println("Password: " + password + "<br>");
                    out.println("Full Name: " + staffFullname + "<br>");
                    out.println("Username: " + username + "<br>");
                    out.println("Address: " + address + "<br>");
                    out.println("Email: " + emailAddress + "<br>");
                    out.println("Phone No: " + phoneNo + "<br>");
                    out.println("Gender: " + gender + "<br>");
                    out.println("Position: " + position + "<br>");
                    out.println("Date of Birth: " + dateOfBirth + "<br>");

                    // Check if IC Number already exists
                    String checkQuery = "SELECT COUNT(*) FROM registerStaff WHERE ic_number = ?";
                    psCheck = conn.prepareStatement(checkQuery);
                    psCheck.setString(1, icNumber);
                    rs = psCheck.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        out.println("<p>IC Number already exists. Please use a different IC Number.</p>");
                    } else {
                        // Validate IC Number format on server side
                        String icPattern = "\\d{6}-\\d{2}-\\d{4}";
                        if (!icNumber.matches(icPattern)) {
                            out.println("<p>Invalid IC Number format. It must be in the format 021122-11-0033</p>");
                        } else {
                            // Validate password format on server side
                            String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$";
                            if (!password.matches(passwordPattern)) {
                                out.println("<p>Password must contain at least one capital letter, one number, one special character, and be at least 8 characters long.</p>");
                            } else {
                                String insertQuery = "INSERT INTO registerStaff (ic_number, password, staff_fullname, username, address, email, phone_no, gender, position, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                                psInsert = conn.prepareStatement(insertQuery);
                                psInsert.setString(1, icNumber);
                                psInsert.setString(2, password);
                                psInsert.setString(3, staffFullname);
                                psInsert.setString(4, username);
                                psInsert.setString(5, address);
                                psInsert.setString(6, emailAddress);
                                psInsert.setString(7, phoneNo);
                                psInsert.setString(8, gender);
                                psInsert.setString(9, position);
                                psInsert.setDate(10, dateOfBirth);

                                int result = psInsert.executeUpdate();

                                if (result > 0) {
                                    out.println("<script>redirectToHome();</script>");
                                } else {
                                    out.println("<p>Error registering staff.</p>");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (psCheck != null) try { psCheck.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (psInsert != null) try { psInsert.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        %>
    </main>
    <jsp:include page="Footer.jsp"/>
</html>
