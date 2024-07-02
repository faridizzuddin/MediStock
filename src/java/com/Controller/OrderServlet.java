/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Controller;

/**
 *
 * @author aqila
 */
import com.dao.OrderDAO;
import com.Model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//@WebServlet("/")
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO(); // Initialize your DAO class
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Forward to doGet for processing
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertOrder(request, response);
                    break;
                case "/delete":
                    deleteOrder(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateOrder(request, response);
                    break;
                case "/insertOrderrr":
                    Print(request, response);
                    break;

//                default:
////                    listOrders(request, response);
////                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex); // Handle SQL exceptions
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> orderList = orderDAO.selectAllOrders();
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order existingOrder = orderDAO.selectOrder(orderId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editOrder.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            int custId = Integer.parseInt(request.getParameter("custId"));
            String dateString = request.getParameter("orderDate");
            double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
            String productName = request.getParameter("productName");

            Order newOrder = new Order(custId, dateString, totalAmount, productName);
            orderDAO.insertOrder(newOrder);
            response.sendRedirect("orderList.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid input. Please check your form.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int custId = Integer.parseInt(request.getParameter("custId"));
            String dateString = request.getParameter("orderDate");
            double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
            String productName = request.getParameter("productName");

            Order updatedOrder = new Order(orderId, custId, dateString, totalAmount, productName);
            orderDAO.updateOrder(updatedOrder);
            response.sendRedirect("list");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid input. Please check your form.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderDAO.deleteOrder(orderId);
        response.sendRedirect("list");
    }

    private void Print(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        
        PrintWriter out = response.getWriter();
        try {
            int custid = Integer.parseInt(request.getParameter("custId"));
            String date = request.getParameter("orderDate");
            double amount = Double.parseDouble(request.getParameter("totalAmount"));
            String name = request.getParameter("productName");

            Order order = new Order();
            order.setCustId(custid);
            order.setOrderDate(date);
            order.setTotalAmount(amount);
            order.setProductName(name);

            int status = OrderDAO.insertOrder(order);
            
            if (status > 0) {
                response.sendRedirect("viewAllOrderr");
            } else {
                out.println("Tak Berjaya");
            }
        } catch (SQLException ex) {

            out.print("Padan Muka");
        }
    }
}
