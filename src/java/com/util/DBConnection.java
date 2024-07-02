/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;

/**
 *
 * @author aqila
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection myConnection = null;
    private static String jdbcURL = "jdbc:mysql://localhost:3306/medistock";

    public DBConnection() {
    }

    public static Connection getConnection() throws ClassNotFoundException {
        if (myConnection != null) {
            return myConnection;
        } else {
            try {
                // Establish and open MySQL database connection....
                Class.forName("com.mysql.jdbc.Driver");
                myConnection = DriverManager.getConnection(jdbcURL, "root", "admin");
            } catch (SQLException e) {
                System.out.println(e);
            }
            return myConnection;
        }
    }

    public void closeConnection() {
        try {
            if (myConnection != null) {
                myConnection.close();
            }
        } catch (SQLException e) {
           System.out.println(e);
        }
    }
}
