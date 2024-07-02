/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

/**
 *
 * @author nafiesa
 */
import com.Model.Sales;
import com.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {

    Connection connection = null;

    private static final String INSERT_SALES_SQL = "INSERT INTO sales (productName, quantity, price, DATE) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SALES_BY_ID = "SELECT * FROM sales WHERE salesId = ?";
    private static final String SELECT_ALL_SALES = "SELECT * FROM sales";
    private static final String DELETE_SALES_SQL = "DELETE FROM sales WHERE salesId = ?";
    private static final String UPDATE_SALES_SQL = "UPDATE sales SET productName = ?, quantity = ?, price = ?, DATE = ? WHERE salesId = ?";

    public SalesDAO() {
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/medistock";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int insertSales(Sales sales) throws SQLException {
        int status  = 0;
        try (Connection connection = SalesDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sales (productName, quantity, price, DATE) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, sales.getProductName());
            preparedStatement.setInt(2, sales.getQuantity());
            preparedStatement.setDouble(3, sales.getPrice());
            preparedStatement.setString(4, sales.getDate());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public Sales selectSales(int salesId) {
        Sales sales = new Sales();
        try (Connection connection = SalesDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sales WHERE salesId = ?")) {
            preparedStatement.setInt(1, salesId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sales.setSalesId(rs.getInt("salesId"));
                sales.setProductName(rs.getString("productName"));
                sales.setQuantity(rs.getInt("quantity"));
                sales.setPrice(rs.getDouble("price"));
                sales.setDate(rs.getString("DATE"));
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
        return sales;
    }

    public List<Sales> selectAllSales() {
        List<Sales> sale = new ArrayList<>();
        try (Connection connection = SalesDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sales")) {
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Sales sales = new Sales();
                sales.setSalesId(rs.getInt("salesId"));
                sales.setProductName(rs.getString("productName"));
                sales.setQuantity(rs.getInt("quantity"));
                sales.setPrice(rs.getDouble("price"));
                sales.setDate(rs.getString("DATE"));
                sale.add(sales);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sale;
    }

    public int deleteSales(int salesId) throws SQLException {
        int result = 0;
        try (Connection connection = SalesDAO.getConnection(); 
                PreparedStatement statement = connection.prepareStatement("DELETE FROM sales WHERE salesId = ?")) {
            statement.setInt(1, salesId);

            result = statement.executeUpdate();
        }
        return result;
    }

    public int updateSales(Sales sales) {
        int status = 0;
        try (Connection connection = SalesDAO.getConnection(); 
            PreparedStatement ps = connection.prepareStatement("UPDATE sales SET productName=?, quantity=?, price=?, DATE=? WHERE salesId=?")) {
            ps.setString(1, sales.getProductName());
            ps.setInt(2, sales.getQuantity());
            ps.setDouble(3, sales.getPrice());
            ps.setString(4, sales.getDate());
            ps.setInt(5, sales.getSalesId());

            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
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

    public static Sales getSelectedSales(int id) {

        Sales e = new Sales();
        try {
            Connection con = SalesDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from sales where salesId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setSalesId(rs.getInt("salesId"));
                e.setProductName(rs.getString("productName"));
                e.setQuantity(rs.getInt("quantity"));
                e.setPrice(rs.getDouble("price"));
                e.setDate(rs.getString("DATE"));
            }   
            con.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return e;

    }

}
