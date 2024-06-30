/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fareed Dinn
 */
public class UpdateMedication extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        
//        
//            String prName = request.getParameter("prName");
//            int prQty = Integer.parseInt(request.getParameter("quantity"));
//
//            Date prExpDate = null;
//            try {
//                prExpDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expiredDate"));
//            } catch (ParseException ex) {
//                out.println("Error Catched");
//            }
//
//            String sid = request.getParameter("prID");
//            int id = Integer.parseInt(sid);
//            int supplierID = Integer.parseInt(request.getParameter("supplierID"));
//
//            Medication medic = MedicationDB.getMedicationById(id);
//            medic.setPrName(prName);
//            medic.setPrQty(prQty);
//            medic.setPrExpDate(prExpDate);
//            medic.setSupplierID(supplierID);
//
//            int status = MedicationDB.update(medic);
//            if (status > 0) {
//                out.println("<script type=\"text/javascript\">");
//                out.println("alert('Product successfully added');");
//                out.println("</script>");
//            } else {
//                out.println("Sorry! unable to save record");
//            }
//
//            out.close();
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
