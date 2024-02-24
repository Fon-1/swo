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
import model.Staff;

/**
 *
 * @author maian
 */
public class StaffDAO extends DBContext {

    public List<Staff> getAllStaff() {
        List<Staff> list = new ArrayList<>();
        String sql = "select * from Staff";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff(rs.getString("StaffID"), 
                        rs.getString("Password"), rs.getString("FullName"), 
                        rs.getString("DOB"), rs.getString("PhoneNumber"), 
                        rs.getString("CCCD"), rs.getInt("Gender"), rs.getString("Email"));
                list.add(staff);
            }
        } catch (SQLException e) {
        }
        return list;
    }

}
