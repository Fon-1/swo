/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.ContactForm;
import model.InsurancePackage;

/**
 *
 * @author DUong
 */
public class ContactFormDAO extends DBContext {

    public List<ContactForm> getAll() {
        List<ContactForm> list = new ArrayList<>();
        String sql = "SELECT * FROM ContactForm ORDER BY submissionTime DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContactForm cf = new ContactForm(rs.getInt("guestID"), rs.getString("fullName"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getString("supportContent"),
                        rs.getTimestamp("submissionTime"), rs.getString("status"), rs.getTimestamp("responseTime"));
                list.add(cf);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void addContactForm(String fullName, String email, String phoneNumber, String supportContent, String status) {
        String sql = "INSERT INTO ContactForm (FullName, Email, PhoneNumber, SupportContent, [Status]) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, fullName);
            st.setString(2, email);
            st.setString(3, phoneNumber);
            st.setString(4, supportContent);
            st.setString(5, status);
            st.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public void updateContactForm(int guestID, String status, Timestamp responseTime) {
        String sql = "update ContactForm set status=?, ResponseTime=? where GuestID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            st.setTimestamp(2, responseTime);
            st.setInt(3, guestID);
            st.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public List<ContactForm> getAllByStatus(String status) {
        List<ContactForm> list = new ArrayList<>();
        String sql = "SELECT * FROM ContactForm where Status like ? ORDER BY submissionTime DESC ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContactForm cf = new ContactForm(rs.getInt("guestID"), rs.getString("fullName"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getString("supportContent"),
                        rs.getTimestamp("submissionTime"), rs.getString("status"), rs.getTimestamp("responseTime"));
                list.add(cf);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ContactForm> getAllByEmailOrPhoneNumber(String keyword) {
        List<ContactForm> list = new ArrayList<>();
        String sql = "SELECT * FROM ContactForm WHERE Email LIKE ? OR PhoneNumber LIKE ? ORDER BY submissionTime DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, keyword);
            st.setString(2, keyword); // Đặt giá trị tham số cho PhoneNumber
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContactForm cf = new ContactForm(rs.getInt("guestID"), rs.getString("fullName"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getString("supportContent"), rs.getTimestamp("submissionTime"),
                        rs.getString("status"), rs.getTimestamp("responseTime"));
                list.add(cf);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        ContactFormDAO st = new ContactFormDAO();
        //Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        //ContactFormDAO st=new ContactFormDAO();
        //st.addContactForm("duong", "duong@gmail.com", "0987654321", "dương đẹp trai", "Processing");
        //List<InsurancePackage> list = st.getAllInsurancePackage();
        List<ContactForm> list = st.getAllByEmailOrPhoneNumber("duong@gmail.com");
        //st.updateContactForm(1, "Đã trả lời",currentTimestamp);
        System.out.println(list.size());

    }
}
