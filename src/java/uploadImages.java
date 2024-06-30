 
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "uploadImages", urlPatterns = {"/uploadImages"})
@MultipartConfig(maxFileSize = 161772162)//15mb
public class uploadImages extends HttpServlet {

    PrintWriter out;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        int result = 0;
        Part part = request.getPart("prImage");
        int id = Integer.parseInt(request.getParameter("prID"));
        if (part != null) {
            try {
                Connection con = MedicationDB.getConnection();
                PreparedStatement ps = con.prepareStatement("UPDATE product SET prImage = ? WHERE prID = ?;");
                InputStream is = part.getInputStream();
                ps.setBlob(1, is);
                ps.setInt(2, id);
                result = ps.executeUpdate();
                if (result > 0) {
                    //Boleh tambah alert gambar added kat sini
                    response.sendRedirect("viewAllMedication");
                } else {
                    response.sendRedirect("ProductRegister.jsp?message=Some+Error+Occurred");
                }
            } catch (Exception e) {
                out.println(e);
            }
        }
    }

}