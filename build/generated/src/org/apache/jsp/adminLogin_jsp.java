package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public final class adminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Admin Login</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styleslogin.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\r\n");
      out.write("    <script>\r\n");
      out.write("        \r\n");
      out.write("        function togglePasswordVisibility() {\r\n");
      out.write("            var password = document.getElementById(\"password\");\r\n");
      out.write("            var eyeIcon = document.getElementById(\"password-eye\");\r\n");
      out.write("            if (password.type === \"password\") {\r\n");
      out.write("                password.type = \"text\";\r\n");
      out.write("                eyeIcon.classList.remove(\"fa-eye\");\r\n");
      out.write("                eyeIcon.classList.add(\"fa-eye-slash\");\r\n");
      out.write("            } else {\r\n");
      out.write("                password.type = \"password\";\r\n");
      out.write("                eyeIcon.classList.remove(\"fa-eye-slash\");\r\n");
      out.write("                eyeIcon.classList.add(\"fa-eye\");\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("        <h1>Admin Login</h1>\r\n");
      out.write("    </header>\r\n");
      out.write("    <nav>\r\n");
      out.write("        <a href=\"adminLogin.jsp\">Login as Admin</a>\r\n");
      out.write("        <a href=\"loginStaff.jsp\">Login as Staff</a>\r\n");
      out.write("        \r\n");
      out.write("    </nav>\r\n");
      out.write("    <main>\r\n");
      out.write("        <form action=\"adminLogin.jsp\" method=\"post\">\r\n");
      out.write("            <label for=\"username\">Username:</label>\r\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" required><br>\r\n");
      out.write("            <label for=\"password\">Password:</label>\r\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required><br>\r\n");
      out.write("            <i id=\"password-eye\" class=\"fa fa-eye\" onclick=\"togglePasswordVisibility('password')\"></i><br>\r\n");
      out.write("            <button type=\"submit\">Login</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");

            if ("post".equalsIgnoreCase(request.getMethod())) {
                String dbURL = "jdbc:mysql://localhost:3306/MediStockNew";
                String dbUser = "root";
                String dbPass = "admin";

                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        response.sendRedirect("adminDashboard.jsp");
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
        
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("       ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
