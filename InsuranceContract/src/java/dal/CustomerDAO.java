/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author dell
 */
public class CustomerDAO extends DBContext {

    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        String sql = "select * from Customer";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String customerID = rs.getString(1);
                String password = rs.getString(2);
                String fullName = rs.getString(3);
                String cccd = rs.getString(4);
                int gender = rs.getInt(5);
                String dob = rs.getString(6);
                String nationality = rs.getString(7);
                String issuedDate = rs.getString(8);
                String expiredDate = rs.getString(9);
                String issuedPlace = rs.getString(10);
                String maritialStatus = rs.getString(11);
                String education = rs.getString(12);
                String job = rs.getString(13);
                String address = rs.getString(14);
                String phoneNumber = rs.getString(15);
                String email = rs.getString(16);                
                Customer customer = new Customer(customerID, password, fullName,
                        cccd, gender, dob, nationality, issuedDate, expiredDate,
                        issuedPlace, maritialStatus, education, job, address,
                        phoneNumber, email);                                                                
                list.add(customer);
            }
        } catch (SQLException e) {
        }
        return list;
    }


    public void createCustomer(Customer customer) {
        String sql = "insert into CUSTOMER (CustomerID, Password, FirstName, LastName, "
                + "Gender, DOB, CCCD, Nationality, MaritalStatus, Education, "
                + "Job, Address, PhoneNumber, Email) \n"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer.getCustomerID());
            st.setString(2, customer.getPassword());
             st.setString(3, customer.getFullName());
            st.setInt(5, customer.getGender());
            st.setString(6, customer.getDOB());
            st.setString(7, customer.getCCCD());
            st.setString(8, customer.getNationality());
            st.setString(9, customer.getMaritalStatus());
            st.setString(10, customer.getEducation());
            st.setString(11, customer.getJob());
            st.setString(12, customer.getAddress());
            st.setString(13, customer.getPhoneNumber());
            st.setString(14, customer.getEmail());
            st.executeQuery();
        } catch (SQLException e) {
        }
    }



    public Customer getCustomerByID(String customerID) {
        String sql = "select * from CUSTOMER where CustomerID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customerID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String password = rs.getString(2);
                String fullName = rs.getString(3);
                String cccd = rs.getString(4);
                int gender = rs.getInt(5);
                String dob = rs.getString(6);
                String nationality = rs.getString(7);
                String issuedDate = rs.getString(8);
                String expiredDate = rs.getString(9);
                String issuedPlace = rs.getString(10);
                String maritialStatus = rs.getString(11);
                String education = rs.getString(12);
                String job = rs.getString(13);
                String address = rs.getString(14);
                String phoneNumber = rs.getString(15);
                String email = rs.getString(16);
                Customer customer = new Customer(customerID, password, fullName,
                        cccd, gender, dob, nationality, issuedDate, expiredDate,
                        issuedPlace, maritialStatus, education, job, address,
                        phoneNumber, email);
                return customer;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateCustomerInfo(Customer customer) {
        String sql = "UPDATE [dbo].[CUSTOMER]\n"
                + "   SET [FullName] = ?\n"
                + "      ,[CCCD] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[DOB] = ?\n"
                + "      ,[Nationality] = ?\n"
                + "      ,[IssuedDate] = ?\n"
                + "      ,[ExpiredDate] = ?\n"
                + "      ,[IssuedPlace] = ?\n"
                + "      ,[MaritalStatus] = ?\n"
                + "      ,[Education] = ?\n"
                + "      ,[Job] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + "      ,[Email] = ?\n"
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer.getFullName());
            st.setString(2, customer.getCCCD());
            st.setInt(3, customer.getGender());
            st.setString(4, customer.getDOB());
            st.setString(5, customer.getNationality());
            st.setString(6, customer.getIssuedDate());
            st.setString(7, customer.getExpiredDate());
            st.setString(8, customer.getIssuedPlace());
            st.setString(9, customer.getMaritalStatus());
            st.setString(10, customer.getEducation());
            st.setString(11, customer.getJob());
            st.setString(12, customer.getAddress());
            st.setString(13, customer.getPhoneNumber());
            st.setString(14, customer.getEmail());
            st.setString(15, customer.getCustomerID());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
//        List<Customer> list = dao.getAllCustomer();
//        for(Customer c : list){
//            System.out.println(c.getCustomerID());
//        }
//        dao.createCustomer(new Customer("CUS002", "Nguyễn", "Mai Anh", 0, "2003-12-27", "0123456789", "VietNam", "Độc thân", "Đại học", "Sinh viên", "87 Lĩnh Nam", "0386224488", "ngmaianh@gmail.com"));
//        Customer customer = dao.getCustomerByID("CUS001");
//        System.out.println(customer.getLastName());
//        dao.updateCustomerInfo("hon nhan", "hoc van", "trader", "0000000000", "Hai Phong", "haiphong@gmai.com", "C002");
    }

}
