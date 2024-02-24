/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.InsuranceContract;

/**
 *
 * @author dell
 */
public class ContractDAO extends DBContext {

    public List<InsuranceContract> getAllContract() {
        List<InsuranceContract> list = new ArrayList<>();
        String sql = "select * from INSURANCE_CONTRACT";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String contractID = rs.getString("ContractID");
                String customerID = rs.getString("CustomerID");
                int packageID = rs.getInt("PackageID");
                int insuranID = rs.getInt("InsuranID");
                int beneID = rs.getInt("BeneID");
                String staff = rs.getString("StaffID");
                String status = rs.getString("Status");
                long sumAssured = rs.getLong("SumAssured");
                String effectiveDate = formatDate(rs.getString("EffectiveDate"));
                String maturityDate = formatDate(rs.getString("MaturityDate"));
                String expiryDate = formatDate(rs.getString("ExpiryDate"));
                int insuranceTime = rs.getInt("InsuranceTime");
                String premiumMode = rs.getString("PremiumMode");
                String contract_pdf = rs.getString("Contract_pdf");
                InsuranceContract contract = new InsuranceContract(contractID,
                        customerID, packageID, insuranID, beneID, staff, status,
                        sumAssured, effectiveDate, maturityDate, expiryDate,
                        insuranceTime, premiumMode, contract_pdf);
                list.add(contract);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<InsuranceContract> getContractByCustomerID(String customerID) {
        List<InsuranceContract> list = new ArrayList<>();
        String sql = "select * from INSURANCE_CONTRACT where CustomerID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customerID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String contractID = rs.getString("ContractID");
                int packageID = rs.getInt("PackageID");
                int insuranID = rs.getInt("InsuranID");
                int beneID = rs.getInt("BeneID");
                String staff = rs.getString("StaffID");
                String status = rs.getString("Status");
                long sumAssured = rs.getLong("SumAssured");
                String effectiveDate = formatDate(rs.getString("EffectiveDate"));
                String maturityDate = formatDate(rs.getString("MaturityDate"));
                String expiryDate = formatDate(rs.getString("ExpiryDate"));
                int insuranceTime = rs.getInt("InsuranceTime");
                String premiumMode = rs.getString("PremiumMode");
                String contract_pdf = rs.getString("Contract_pdf");
                InsuranceContract contract = new InsuranceContract(contractID,
                        customerID, packageID, insuranID, beneID, staff, status,
                        sumAssured, effectiveDate, maturityDate, expiryDate,
                        insuranceTime, premiumMode, contract_pdf);
                list.add(contract);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public InsuranceContract getContractByID(String contractID) {
        String sql = "select * from INSURANCE_CONTRACT where ContractID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, contractID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String customerID = rs.getString("CustomerID");
                int packageID = rs.getInt("PackageID");
                int insuranID = rs.getInt("InsuranID");
                int beneID = rs.getInt("BeneID");
                String staff = rs.getString("StaffID");
                String status = rs.getString("Status");
                long sumAssured = rs.getLong("SumAssured");
                String effectiveDate = formatDate(rs.getString("EffectiveDate"));
                String maturityDate = formatDate(rs.getString("MaturityDate"));
                String expiryDate = formatDate(rs.getString("ExpiryDate"));
                int insuranceTime = rs.getInt("InsuranceTime");
                String premiumMode = rs.getString("PremiumMode");
                String contract_pdf = rs.getString("Contract_pdf");
                InsuranceContract contract = new InsuranceContract(contractID,
                        customerID, packageID, insuranID, beneID, staff, status,
                        sumAssured, effectiveDate, maturityDate, expiryDate,
                        insuranceTime, premiumMode, contract_pdf);
                return contract;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void createContract(InsuranceContract contract) {
        String sql = "insert into INSURANCE_CONTRACT values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, contract.getContractID());
            st.setInt(2, contract.getPackageID());
            st.setInt(3, contract.getInsuranID());
            st.setInt(4, contract.getBeneID());
            st.setString(5, contract.getCustomerID());
            st.setString(6, contract.getStaffID());
            st.setString(7, contract.getStatus());
            st.setLong(8, contract.getSumAssured());
            st.setString(9, contract.getEffectiveDate());
            st.setString(10, contract.getMaturityDate());
            st.setString(11, contract.getExpiryDate());
            st.setInt(12, contract.getInsuranceTime());
            st.setString(13, contract.getPremiumMode());
            st.setString(14, contract.getContract_pdf());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private static String formatDate(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
        }
        return null;
    }
}