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
import model.InsurancePackage;

/**
 *
 * @author maian
 */
public class InsurancePackageDAO extends DBContext {

    public List<InsurancePackage> getAllInsurancePackage() {
        List<InsurancePackage> list = new ArrayList<>();
        String sql = "select * from INSURANCE_PACKAGE";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int packageID = rs.getInt("PackageID");
                String packageName = rs.getString("PackageName").toUpperCase();
                InsurancePackage insuPackage = new InsurancePackage(packageID, packageName);
                list.add(insuPackage);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
