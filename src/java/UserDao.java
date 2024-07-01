
import java.sql.*;

public class UserDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medistocknew", "root", "admin");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    public static User getSelectedStaffDetail(String ic){
    
        User e = new User();
        try {
            Connection con = UserDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from registerstaff where ic_number = ?");
            ps.setString(1,ic);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setIc_number(rs.getString("ic_number"));
                e.setPassword(rs.getString("password"));
                e.setStaff_fullname(rs.getString("staff_fullname"));
                e.setUsername(rs.getString("username"));
                e.setAddress(rs.getString("address"));
                e.setEmail(rs.getString("email"));
                e.setPhone_no(rs.getString("phone_no"));
                e.setGender(rs.getString("gender"));
                e.setPosition(rs.getString("position"));
                e.setDate_of_birth(rs.getString("date_of_birth"));
            }
            
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    
}
