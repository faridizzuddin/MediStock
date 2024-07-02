/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.Controller.OrderServlet;
import com.Model.Order;
import com.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * update order
 */
public class EditOrderr extends HttpServlet {

    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int custId = Integer.parseInt(request.getParameter("custId"));
            String dateString = request.getParameter("orderDate");
            double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
            String productName = request.getParameter("productName");
            
            Order order = orderDAO.selectOrder(orderId);
            order.setCustId(custId);
            order.setOrderDate(dateString);
            order.setProductName(productName);
            order.setTotalAmount(totalAmount);
            
            int status  = orderDAO.update(order);
            
            if(status>0){
//                request.getRequestDispatcher("viewAllOrder").forward(request, response);
                response.sendRedirect("viewAllOrderr");
            }
            
            

//            Order updatedOrder = new Order(orderId, custId, dateString, totalAmount, productName);
//            orderDAO.updateOrder(updatedOrder);
        } catch (NumberFormatException e) {

        }
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
