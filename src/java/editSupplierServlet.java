/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fareed Dinn
 */
public class editSupplierServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        int supplierID = Integer.parseInt(request.getParameter("supplierId"));
        String supplierName = request.getParameter("supplierName");
        String supplierPhNum = request.getParameter("phoneNumber");
        String storageLocation = request.getParameter("storageLocation");
        String companyName = request.getParameter("companyName");
        String email = request.getParameter("email");

        Supplier e = MedicationDB.getSelectedSupplier(supplierID);
        e.setSupplierName(supplierName);
        e.setSupplierPhNum(supplierPhNum);
        e.setStorageLocation(storageLocation);
        e.setSupplierEmail(email);
        e.setSupplierCompanyName(companyName);

        int status = MedicationDB.updateSupplier(e);
        if (status > 0) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Supplier successfully edited');");
            out.println("window.location.href='viewAllSupplier';");
            out.println("</script>");
        } else {
            out.println("Sorry! unable to save record");
        }
//        request.getRequestDispatcher("Supplier.jsp").forward(request, response);
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
