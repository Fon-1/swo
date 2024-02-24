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
import model.InsurancePerson;

/**
 *
 * @author maian
 */
public class InsurancePersonDAO extends DBContext {

    public List<InsurancePerson> getAllInsurancePerson() {
        List<InsurancePerson> list = new ArrayList<>();
        String sql = "select * from INSURANCE_PERSON";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int insuranID = rs.getInt("InsuranID");
                String fullName = rs.getString("FullName");
                int gender = rs.getInt("Gender");
                String dob = rs.getString("DOB");
                String cccd = rs.getString("CCCD");
                String nationality = rs.getString("Nationality");
                String maritalStatus = rs.getString("MaritalStatus");
                String education = rs.getString("Education");
                String job = rs.getString("Job");
                String address = rs.getString("Address");
                String phoneNumber = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                InsurancePerson insuPerson = new InsurancePerson(insuranID,
                        fullName, gender, dob, cccd, nationality, maritalStatus,
                        education, job, address, phoneNumber, email);
                list.add(insuPerson);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public InsurancePerson getInsurancePersonByID(int insuranID) {
        String sql = "select * from INSURANCE_PERSON where InsuranID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, insuranID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("FullName");
                int gender = rs.getInt("Gender");
                String dob = rs.getString("DOB");
                String cccd = rs.getString("CCCD");
                String nationality = rs.getString("Nationality");
                String maritalStatus = rs.getString("MaritalStatus");
                String education = rs.getString("Education");
                String job = rs.getString("Job");
                String address = rs.getString("Address");
                String phoneNumber = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                InsurancePerson insuPerson = new InsurancePerson(insuranID,
                        fullName, gender, dob, cccd, nationality, maritalStatus,
                        education, job, address, phoneNumber, email);
                return insuPerson;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public InsurancePerson getNewInsurancePerson() {
        String sql = "select top 1 * from INSURANCE_PERSON order by InsuranID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int insuranID = rs.getInt("InsuranID");
                String fullName = rs.getString("FullName");
                int gender = rs.getInt("Gender");
                String dob = rs.getString("DOB");
                String cccd = rs.getString("CCCD");
                String nationality = rs.getString("Nationality");
                String maritalStatus = rs.getString("MaritalStatus");
                String education = rs.getString("Education");
                String job = rs.getString("Job");
                String address = rs.getString("Address");
                String phoneNumber = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                return new InsurancePerson(insuranID, fullName, gender, dob,
                        cccd, nationality, maritalStatus, education,
                        job, address, phoneNumber, email);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void createInsurancePerson(InsurancePerson insuPerson) {
        String sql = "insert into INSURANCE_PERSON (FullName, Gender, DOB, CCCD,"
                + " Nationality, MaritalStatus, Education, Job, [Address], "
                + "PhoneNumber, Email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, insuPerson.getFullName());
            st.setInt(2, insuPerson.getGender());
            st.setString(3, insuPerson.getDob());
            st.setString(4, insuPerson.getCccd());
            st.setString(5, insuPerson.getNationality());
            st.setString(6, insuPerson.getMaritalStatus());
            st.setString(7, insuPerson.getEducation());
            st.setString(8, insuPerson.getJob());
            st.setString(9, insuPerson.getAddress());
            st.setString(10, insuPerson.getPhoneNumber());
            st.setString(11, insuPerson.getEmail());
            st.executeQuery();
        } catch (SQLException e) {
        }
    }

}
