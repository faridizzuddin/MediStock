/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author aqila
 */
import com.dao.*;
import com.Model.Order;
import com.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    Connection connection = null;
//    private String jdbcURL = "jdbc:mysql://localhost:3306/meddi";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "admin";

    private static final String INSERT_ORDER_SQL = "INSERT INTO orders (orderId, custId, orderDate, totalAmount, productName) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ORDER_BY_ID = "SELECT orderId, custId, orderDate, totalAmount, productName FROM orders WHERE orderId = ?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String DELETE_ORDER_SQL = "DELETE FROM orders WHERE orderId = ?";
    private static final String UPDATE_ORDER_SQL = "UPDATE orders SET custId = ?, orderDate = ?, totalAmount = ?, productName = ? WHERE orderId = ?";

    public OrderDao() {
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/medistock";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medistock", "root", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int insertOrder(Order order) throws SQLException {

        int status = 0;

        Connection connection = OrderDao.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (custId, orderDate, totalAmount, productName) VALUES (?, ?, ?, ?)");
        preparedStatement.setInt(1, order.getCustId());
        preparedStatement.setString(2, order.getOrderDate());
        preparedStatement.setDouble(3, order.getTotalAmount());
        preparedStatement.setString(4, order.getProductName());
        
        status = preparedStatement.executeUpdate();

        return status;
    }

    public Order selectOrder(int orderId) {
        Order order = new Order();
        try (Connection connection = DBConnectionUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE orderId = ?")) {
            preparedStatement.setInt(1, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                order.setOrderId(rs.getInt("orderId"));
                order.setCustId(rs.getInt("custId"));
                order.setOrderDate(rs.getString("orderDate"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setProductName(rs.getString("productName"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order;
    }

    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBConnectionUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders")) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setCustId(rs.getInt("custId"));
                order.setOrderDate(rs.getString("orderDate"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setProductName(rs.getString("productName"));
                orders.add(order);

//                int orderId = rs.getInt("orderId");
//                int custId = rs.getInt("custId");
//                java.util.Date orderDate = new java.util.Date(rs.getDate("orderDate").getTime());
//                double totalAmount = rs.getDouble("totalAmount");
//                String productName = rs.getString("productName");
//                orders.add(new Order(orderId, custId, orderDate, totalAmount, productName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orders;
    }

    public int deleteOrder(int orderId) throws SQLException {
        int result = 0;                                                                                                //DELETE FROM orders WHERE orderId = ?"
        try (Connection connection = DBConnectionUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_SQL)) {
            statement.setInt(1, orderId);

            result = statement.executeUpdate();
        }
        return result;
    }

    public boolean updateOrder(Order order) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnectionUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setInt(1, order.getCustId());
            statement.setString(2, order.getOrderDate());
            statement.setDouble(3, order.getTotalAmount());
            statement.setString(4, order.getProductName());
            statement.setInt(5, order.getOrderId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static Order getSelectedOrder(int id) {

        Order e = new Order();
        try {
            Connection con = OrderDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from orders where orderId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setOrderId(rs.getInt("orderId"));
                e.setCustId(rs.getInt("custId"));
                e.setOrderDate(rs.getString("orderDate"));
                e.setTotalAmount(rs.getDouble("totalAmount"));
                e.setProductName(rs.getString("productName"));
            }
            con.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return e;

    }

    public int update(Order order) {
        int status = 0;
        try {
            Connection con = OrderDao.getConnection();
            PreparedStatement ps = con.prepareStatement("update orders set custId=?,orderDate=?,totalAmount=?,productName=? where orderId=?");
            ps.setInt(1, order.getCustId());
            ps.setString(2, order.getOrderDate());
            ps.setDouble(3, order.getTotalAmount());
            ps.setString(4, order.getProductName());
            ps.setInt(5, order.getOrderId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
