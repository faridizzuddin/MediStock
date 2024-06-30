//
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
///**
// *
// * @author Fareed Dinn
// */
//import java.util.*;
//import java.sql.*;
//
//public class MedicDB {
//
//    public static Connection getConnection() {
//        Connection con = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medistock", "root", "admin");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return con;
//    }
//
////    public static int save(Medication e) {
////        int status = 0;
////        try {
////            Connection con = MediDB.getConnection();
////            PreparedStatement ps = con.prepareStatement("insert into users(username,password,roles) values(?,?,?)");
////            ps.setString(1, e.getUsername());
////            ps.setString(2, e.getPassword());
////            ps.setString(3, e.getRole());
////
////            status = ps.executeUpdate();
////
////            con.close();
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////        return status;
////    }
//
////    public static int update(User e) {
////        int status = 0;
////        try {
////            Connection con = UserDao.getConnection();
////            PreparedStatement ps = con.prepareStatement("update users set username=?,password=?,roles=? where id=?");
////            ps.setString(1, e.getUsername());
////            ps.setString(2, e.getPassword());
////            ps.setString(3, e.getRole());
////            ps.setInt(4, e.getId());
////
////            status = ps.executeUpdate();
////
////            con.close();
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////        return status;
////    }
////
////    public static int delete(int id) {
////        int status = 0;
////        try {
////            Connection con = UserDao.getConnection();
////            PreparedStatement ps = con.prepareStatement("delete from users where id=?");
////            ps.setInt(1, id);
////
////            status = ps.executeUpdate();
////
////            con.close();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return status;
////    }
////
////    public static Medication getUserById(int id) {
////        Medication e = new Medication();
////        try {
////            Connection con = MediDB.getConnection();
////            PreparedStatement ps = con.prepareStatement("select * from users where id=?");
////            ps.setInt(1, id);
////            ResultSet rs = ps.executeQuery();
////            if (rs.next()) {
////                e.setPrID(rs.getInt(1));
////                e.setPrName(rs.getString(2));
////                e.setPrQty(rs.getInt(3));
////                e.setPrExpDate(rs.getString(4));
////            }
////            con.close();
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////        return e;
////    }
////    public static Medication getProductIDById(int id) {
////        Medication e = new Medication();
////        try {
////            Connection con = MediDB.getConnection();
////            PreparedStatement ps = con.prepareStatement("select * from products where id=?");
////            ResultSet rs = ps.executeQuery();
////            if (rs.next()) {
////                e.setPrID(rs.getInt(1));
////                e.setPrName(rs.getString(2));
////                e.setPrQty(rs.getInt(3));
////                e.setPrExpDate(rs.getString(4));
////            }
////            con.close();
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////        return e;
////    }
//
//    public static List<Medication> getAllMedications() {
//        List<Medication> list = new ArrayList<Medication>();
//
//        try {
//            Connection con = MedicDB.getConnection();
//            PreparedStatement ps = con.prepareStatement("select * from product");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Medication e = new Medication();
//                e.setPrID(rs.getInt(1));
//                e.setPrName(rs.getString(2));
//                e.setPrQty(rs.getInt(3));
//                e.setPrExpDate(rs.getDate(4));
//                list.add(e);
//
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//}
