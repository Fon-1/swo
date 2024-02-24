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
import model.BeneficiaryPerson;

/**
 *
 * @author maian
 */
public class BeneficiaryPersonDAO extends DBContext {
    
    public List<BeneficiaryPerson> getAllBeneficiaryPerson() {
        List<BeneficiaryPerson> list = new ArrayList<>();
        String sql = "select * from BENEFICIARY_PERSON";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int beneID = rs.getInt("BeneID");
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
                String relationship = rs.getString("Relationship");
                BeneficiaryPerson benePerson = new BeneficiaryPerson(beneID, 
                        fullName, gender, dob, cccd, nationality, maritalStatus,
                        education, job, address, phoneNumber, email, relationship);
                list.add(benePerson);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public BeneficiaryPerson getNewBeneficiaryPerson() {        
        String sql = "select top 1 * from BENEFICIARY_PERSON order by BeneID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int beneID = rs.getInt("BeneID");
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
                String relationship = rs.getString("Relationship");
                return new BeneficiaryPerson(beneID, fullName, gender, dob, 
                        cccd, nationality, maritalStatus, education,
                        job, address, phoneNumber, email, relationship);
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void createBeneficiaryPerson(BeneficiaryPerson benePerson) {
        String sql = "insert into BENEFICIARY_PERSON (FullName, Gender, DOB, CCCD, "
                + "Nationality, MaritalStatus, Education, Job, [Address], PhoneNumber, "
                + "Email, Relationship) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, benePerson.getFullName());
            st.setInt(2, benePerson.getGender());
            st.setString(3, benePerson.getDob());
            st.setString(4, benePerson.getCccd());
            st.setString(5, benePerson.getNationality());
            st.setString(6, benePerson.getMaritalStatus());
            st.setString(7, benePerson.getEducation());
            st.setString(8, benePerson.getJob());
            st.setString(9, benePerson.getAddress());
            st.setString(10, benePerson.getPhoneNumber());
            st.setString(11, benePerson.getEmail());
            st.setString(12, benePerson.getRelationship());
            st.executeQuery();
        } catch (SQLException e) {
        }
    }
}
