package servlet;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.UserDao;
import model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NUR FARISHA
 */
public class viewSelectedStaffServlett extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ic = request.getParameter("ic");
        User user = UserDao.getSelectedStaffDetail(ic);
        
        System.out.println(user.getAddress());

        request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("viewStaffProfile.jsp");
        rd.forward(request, response);
    }
}
