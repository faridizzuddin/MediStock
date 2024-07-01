package dao;


import model.User;
import java.sql.*;

public class UserDao {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/medistock";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "admin";

//    private static final String INSERT_USERS_SQL = "INSERT INTO users (userId, fullName, username, password, address, emailAddress, phoneNo, gender, position, dateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static User getSelectedStaffDetail(String ic){
    
        User e = new User();

        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from registerstaff where ic_number= ?");
            ps.setString(1,ic);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setIc_number(rs.getString(1));
                e.setPassword(rs.getString(2));
                e.setStaff_fullname(rs.getString(3));
                e.setUsername(rs.getString(4));
                e.setAddress(rs.getString(5));
                e.setEmail(rs.getString(6));
                e.setPhone_no(rs.getString(7));
                e.setGender(rs.getString(8));
                e.setPosition(rs.getString(9));
                e.setDate_of_birth(rs.getString(10));
                
            }
            
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    
}
