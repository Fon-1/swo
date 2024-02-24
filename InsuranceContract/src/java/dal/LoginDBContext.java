/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;
import model.Staff;

public class LoginDBContext extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Staff loginStaff(String staff, String password) {
       
         String query = "SELECT * FROM STAFF WHERE StaffID = ? AND Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, staff);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Staff(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)
                );
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Customer login(String user, String pass) {
      String query = "select * from Customer where CustomerID = ?  and Password = ? and Status = 1";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)
                       // rs.getString(17)
                );
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Customer checkAccount(String user) {
        String query = "select * from Customer where CustomerID =? and Status = 1";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Customer getEmail(String email) {
        String query = "select * from Customer where Email =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void updatePassword(String email, String password) {
        String query = "update Customer set password = ?  where Email =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, email);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public void signup(String CustomerID, String FullName, String CCCD,String Gender,String DOB,String Nationality,String IssuedDate,String ExpiredDate,String IssuedPlace,String MaritalStatus,String Education,String Job,String Address,String PhoneNumber,String Email) {
        //String query = "insert into Customer values(?,?,?, ?,?,?,?,'5',?,'')";
        String query = "insert into CUSTOMER(CustomerID,FullName,CCCD,Gender,DOB,Nationality,IssuedDate,ExpiredDate,IssuedPlace,MaritalStatus,Education,Job,Address,PhoneNumber,Email,Status)\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, CustomerID);
            ps.setString(2, FullName);
            ps.setString(3, CCCD);
            
             ps.setString(4, Gender);
            ps.setString(5, DOB);
            ps.setString(6, Nationality);
            
             ps.setString(7, IssuedDate);
            ps.setString(8, ExpiredDate);
            ps.setString(9, IssuedPlace);
            
             ps.setString(10, MaritalStatus);
            ps.setString(11, Education);
            ps.setString(12, Job);
            
             ps.setString(13, Address);
            ps.setString(14, PhoneNumber);
            ps.setString(15, Email);
            

            rs = ps.executeQuery();

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void updatePass(String customerid, String pass) {
        //String query = "insert into Customer values(?,?,?, ?,?,?,?,'5',?,'')";
        String query = "UPDATE CUSTOMER \n"
                + "SET password = ? \n"
                + "WHERE CustomerID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, customerid);
            rs = ps.executeQuery();

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        LoginDBContext lg = new LoginDBContext();
        Customer a = lg.getEmail("hoangngoclong2001@gmail.com");
        System.out.print(a.getCustomerID());
    }
}
