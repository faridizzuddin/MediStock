<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Staff Login</title>
    <link rel="stylesheet" type="text/css" href="styleslogin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script>
        function presetICNumber() {
            var icInput = document.getElementById("ic_number");
            if (icInput.value.length === 6 || icInput.value.length === 9) {
                icInput.value += '-';
            }
        }
         function togglePasswordVisibility() {
            var password = document.getElementById("password");
            var eyeIcon = document.getElementById("password-eye");
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
           <jsp:include page="Header.jsp"/>
    <header>
        <h1>Staff Login</h1>
    </header>
    <nav>
        <a href="adminLogin.jsp">Login as Admin</a>
        <a href="loginStaff.jsp">Login as Staff</a>
       
    </nav>
    <main>
        <form action="loginStaff.jsp" method="post">
            <label for="ic_number">IC Number:</label>
            <input type="text" id="ic_number" name="ic_number" required oninput="presetICNumber()" pattern="\d{6}-\d{2}-\d{4}" title="IC Number must be in the format 021122-11-0033"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <i id="password-eye" class="fa fa-eye" onclick="togglePasswordVisibility('password')"></i><br>
            
            <button type="submit">Login</button>
        </form>
        <%
            if ("post".equalsIgnoreCase(request.getMethod())) {
                String dbURL = "jdbc:mysql://localhost:3306/medistocknew";
                String dbUser = "root";
                String dbPass = "admin";

                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    String icNumber = request.getParameter("ic_number");
                    String password = request.getParameter("password");
                    

                    String query = "SELECT * FROM registerstaff WHERE ic_number = ? AND password = ?";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, icNumber);
                    ps.setString(2, password);
            
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        request.setAttribute("ic", icNumber);
                        request.getRequestDispatcher("staffDashboard.jsp").forward(request, response);
                    } else {
                        out.println("<p>Invalid username or password.</p>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        %>
    </main>
           <jsp:include page="Footer.jsp"/>
</body>
</html>
