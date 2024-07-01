
/**
 *
 * @author Fareed Dinn
 */
import java.util.*;
import java.sql.*;

public class MedicationDB {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medistock", "root", "admin");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static List<Medication> getAllMedications() {
        List<Medication> list = new ArrayList<Medication>();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medication e = new Medication();
                e.setPrID(rs.getInt(1));
                e.setPrName(rs.getString(2));
                e.setPrQty(rs.getInt(3));
                e.setPrExpDate(rs.getString(4));
                e.setPrImage(rs.getBytes(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int save(Supplier supplier) {
        int status = 0;
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into supplier(supplierName,supplierPhNum,supplierEmail,supplierCompanyName,storageLocation) values(?,?,?,?,?)");
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getSupplierPhNum());
            ps.setString(3, supplier.getSupplierEmail());
            ps.setString(4, supplier.getSupplierCompanyName());
            ps.setString(5, supplier.getStorageLocation());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int saveMedication(Medication medic) {
        int status = 0;
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into product(prName,prQty,prExpDate,supplierID) values(?,?,?,?)");
            ps.setString(1, medic.getPrName());
            ps.setInt(2, medic.getPrQty());
            ps.setString(3, medic.getPrExpDate());
            ps.setInt(4, medic.getSupplierID());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<Medication> getSelectedMedications(String name) {
        List<Medication> list = new ArrayList<Medication>();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from product where prName like ?");
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medication e = new Medication();
                e.setPrID(rs.getInt(1));
                e.setPrName(rs.getString(2));
                e.setPrQty(rs.getInt(3));
                e.setPrExpDate(rs.getString(4));
                e.setPrImage(rs.getBytes(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Medication getSelectedMedication(int id) {
        Medication e = new Medication();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select p.prID,p.prName,prQty,prExpDate,s.supplierID,s.supplierName,s.supplierPhNum,s.supplierEmail,s.supplierCompanyName, s.storageLocation from product p join supplier s on s.supplierID=p.supplierID where prID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setPrID(rs.getInt(1));
                e.setPrName(rs.getString(2));
                e.setPrQty(rs.getInt(3));
                e.setPrExpDate(rs.getString(4));
                e.setSupplierID(rs.getInt(5));
                e.setSupplierName(rs.getString(6));
                e.setSupplierPhNum(rs.getString(7));
                e.setSupplierEmail(rs.getString(8));
                e.setSupplierCompanyName(rs.getString(9));
                e.setStorageLocation(rs.getString(10));
            }
            con.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return e;
    }
    public static Medication getASelectedMedication(int id) {
        Medication e = new Medication();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from product where prID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setPrID(rs.getInt(1));
                e.setPrName(rs.getString(2));
                e.setPrQty(rs.getInt(3));
                e.setPrExpDate(rs.getString(4));
                e.setPrImage(rs.getBytes(5));
            }
            con.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return e;
    }

    public static Supplier getSelectedSupplier(int suppId) {
        Supplier e = new Supplier();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from supplier where supplierID=?");
            ps.setInt(1, suppId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setSupplierID(rs.getInt(1));
                e.setSupplierName(rs.getString(2));
                e.setSupplierPhNum(rs.getString(3));
                e.setSupplierEmail(rs.getString(4));
                e.setSupplierCompanyName(rs.getString(5));
                e.setStorageLocation(rs.getString(6));
            }
            con.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return e;
    }

    public static Medication getMedicationById(int id) {
        Medication e = new Medication();
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from users where prID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setPrID(rs.getInt(1));
                e.setPrName(rs.getString(2));
                e.setPrQty(rs.getInt(3));
                e.setPrExpDate(rs.getString(4));
                e.setSupplierID(rs.getInt(5));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public static List<Supplier> getAllSupplier() {
        List<Supplier> list = new ArrayList<Supplier>();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from supplier");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supplier e = new Supplier();
                e.setSupplierID(rs.getInt(1));
                e.setSupplierName(rs.getString(2));
                e.setSupplierPhNum(rs.getString(3));
                e.setSupplierEmail(rs.getString(4));
                e.setSupplierCompanyName(rs.getString(5));
                e.setStorageLocation(rs.getString(6));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Supplier> getAllSuppliers() {
        List<Supplier> list = new ArrayList<Supplier>();

        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from supplier");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supplier e = new Supplier();
                e.setSupplierID(rs.getInt(1));
                e.setSupplierName(rs.getString(2));
                e.setSupplierPhNum(rs.getString(3));
                e.setSupplierEmail(rs.getString(4));
                e.setSupplierCompanyName(rs.getString(5));
                e.setStorageLocation(rs.getString(6));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from product where prID=?");
            ps.setInt(1, id);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteSupplier(int suppid) {
        int status = 0;
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from supplier where supplierID=?");
            ps.setInt(1, suppid);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int update(Medication medic) {
        int status = 0;
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set prName=?,prQty=?,prExpDate=?,supplierID=? where prID=?");
            ps.setString(1, medic.getPrName());
            ps.setInt(2, medic.getPrQty());
            ps.setString(3, medic.getPrExpDate());
            ps.setInt(4, medic.getSupplierID());
            ps.setInt(5, medic.getPrId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int updateSupplier(Supplier supplier) {
        int status = 0;
        try {
            Connection con = MedicationDB.getConnection();
            PreparedStatement ps = con.prepareStatement("update supplier set supplierName=?,supplierPhNum=?,supplierEmail=?, supplierCompanyName=?, storageLocation=? where supplierID=?");
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getSupplierPhNum());
            ps.setString(3, supplier.getSupplierEmail());
            ps.setString(4, supplier.getSupplierCompanyName());
            ps.setString(5, supplier.getStorageLocation());
            ps.setInt(6, supplier.getSupplierID());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
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
