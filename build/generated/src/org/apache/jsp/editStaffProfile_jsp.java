package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class editStaffProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Edit Staff Profile</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styleseditprofile.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <header>\n");
      out.write("        <h1>Edit Profile</h1>\n");
      out.write("    </header>\n");
      out.write("    <nav>\n");
      out.write("        <a href=\"viewStaffProfile.jsp\">Back to Profile</a>\n");
      out.write("    </nav>\n");
      out.write("    <main>\n");
      out.write("        ");

            String dbURL = "jdbc:mysql://localhost:3306/medistock";
            String dbUser = "root";
            String dbPass = "admin";
            
            Connection conn = null;
            PreparedStatement ps = null;

            String currentICNumber = (String) session.getAttribute("ic_number");
            String newPassword = request.getParameter("newPassword");
            String message = null;

            if (request.getParameter("update") != null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    String updateQuery = "UPDATE registerStaff SET password = ? WHERE ic_number = ?";
                    ps = conn.prepareStatement(updateQuery);
                    ps.setString(1, newPassword);
                    ps.setString(2, currentICNumber);
                    
                    int result = ps.executeUpdate();
                    
                    if (result > 0) {
                        message = "Password updated successfully.";
                    } else {
                        message = "Error updating password.";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <h2>Change Password</h2>\n");
      out.write("        <form method=\"post\" action=\"editStaffProfile.jsp\">\n");
      out.write("            <label for=\"newPassword\">New Password:</label>\n");
      out.write("            <input type=\"password\" id=\"newPassword\" name=\"newPassword\" required>\n");
      out.write("            <button type=\"submit\" name=\"update\">Update Password</button>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <p>");
      out.print( message != null ? message : "" );
      out.write("</p>\n");
      out.write("    </main>\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
