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
import model.ContractDetails;

/**
 *
 * @author DUong
 */
public class ContractDetailDAO extends DBContext{
    public List<ContractDetails> getAll() {
        List<ContractDetails> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    ic.ContractID,\n" +
"    ip.PackageName,\n" +
"    ic.SumAssured,\n" +
"    ic.PremiumMode,\n" +
"    iper.FullName AS InsurancePersonFullName,\n" +
"    bper.FullName AS BeneficiaryPersonFullName,\n" +
"    c.FullName AS CustomerFullName,\n" +
"    s.FullName AS StaffFullName,\n" +
"    s.PhoneNumber AS StaffPhoneNumber,\n" +
"    ic.EffectiveDate,\n" +
"    ic.MaturityDate,\n" +
"    ic.ExpiryDate\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Insurance_Package ip ON ic.PackageID = ip.PackageID\n" +
"    INNER JOIN Package_Detail pd ON ip.PackageDetailID = pd.PackageDetailID\n" +
"    INNER JOIN Insurance_Person iper ON ic.InsuranID = iper.InsuranID\n" +
"    INNER JOIN Beneficiary_Person bper ON ic.BeneID = bper.BeneID\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Staff s ON ic.StaffID = s.StaffID;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContractDetails s = new ContractDetails(rs.getString("contractID"),rs.getString("packageName"),rs.getString("insurancePersonFullName")
                        ,rs.getString("beneficiaryPersonFullName"),rs.getString("customerFullName"),rs.getString("staffFullName")
                        ,rs.getString("staffPhoneNumber"), rs.getLong("sumAssured"), rs.getDate("effectiveDate"),rs.getDate("maturityDate")
                        ,rs.getDate("expiryDate"), rs.getString("premiumMode")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<ContractDetails> getAllByCustomerID(String CustomerID) {
        List<ContractDetails> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    ic.ContractID,\n" +
"    ip.PackageName,\n" +
"    ic.SumAssured,\n" +
"    ic.PremiumMode,\n" +
"    iper.FullName AS InsurancePersonFullName,\n" +
"    bper.FullName AS BeneficiaryPersonFullName,\n" +
"    c.FullName AS CustomerFullName,\n" +
"    s.FullName AS StaffFullName,\n" +
"    s.PhoneNumber AS StaffPhoneNumber,\n" +
"    ic.EffectiveDate,\n" +
"    ic.MaturityDate,\n" +
"    ic.ExpiryDate\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Insurance_Package ip ON ic.PackageID = ip.PackageID\n" +
"    INNER JOIN Package_Detail pd ON ip.PackageDetailID = pd.PackageDetailID\n" +
"    INNER JOIN Insurance_Person iper ON ic.InsuranID = iper.InsuranID\n" +
"    INNER JOIN Beneficiary_Person bper ON ic.BeneID = bper.BeneID\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Staff s ON ic.StaffID = s.StaffID\n" +
        "WHERE c.CustomerID = ?;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, CustomerID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContractDetails s = new ContractDetails(rs.getString("contractID"),rs.getString("packageName"),rs.getString("insurancePersonFullName")
                        ,rs.getString("beneficiaryPersonFullName"),rs.getString("customerFullName"),rs.getString("staffFullName")
                        ,rs.getString("staffPhoneNumber"), rs.getLong("sumAssured"), rs.getDate("effectiveDate"),rs.getDate("maturityDate")
                        ,rs.getDate("expiryDate"), rs.getString("premiumMode")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<ContractDetails> getAllByStaffID(String StaffID) {
        List<ContractDetails> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    ic.ContractID,\n" +
"    ip.PackageName,\n" +
"    ic.SumAssured,\n" +
"    ic.PremiumMode,\n" +
"    iper.FullName AS InsurancePersonFullName,\n" +
"    bper.FullName AS BeneficiaryPersonFullName,\n" +
"    c.FullName AS CustomerFullName,\n" +
"    s.FullName AS StaffFullName,\n" +
"    s.PhoneNumber AS StaffPhoneNumber,\n" +
"    ic.EffectiveDate,\n" +
"    ic.MaturityDate,\n" +
"    ic.ExpiryDate\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Insurance_Package ip ON ic.PackageID = ip.PackageID\n" +
"    INNER JOIN Package_Detail pd ON ip.PackageDetailID = pd.PackageDetailID\n" +
"    INNER JOIN Insurance_Person iper ON ic.InsuranID = iper.InsuranID\n" +
"    INNER JOIN Beneficiary_Person bper ON ic.BeneID = bper.BeneID\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Staff s ON ic.StaffID = s.StaffID\n" +
        "WHERE s.StaffID = ?;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, StaffID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContractDetails s = new ContractDetails(rs.getString("contractID"),rs.getString("packageName"),rs.getString("insurancePersonFullName")
                        ,rs.getString("beneficiaryPersonFullName"),rs.getString("customerFullName"),rs.getString("staffFullName")
                        ,rs.getString("staffPhoneNumber"), rs.getLong("sumAssured"), rs.getDate("effectiveDate"),rs.getDate("maturityDate")
                        ,rs.getDate("expiryDate"), rs.getString("premiumMode")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<ContractDetails> getAllContractsByContractID(String PartOfName) {
        List<ContractDetails> list = getAll();
        List<ContractDetails> listSearch = new ArrayList<>();
        for (ContractDetails o : list) {
            if (o.getContractID().toUpperCase().contains(PartOfName.toUpperCase())) {
                listSearch.add(new ContractDetails(o.getContractID(), o.getPackageName(), o.getInsurancePersonFullName(), o.getInsurancePersonFullName()
                , o.getCustomerFullName(), o.getStaffFullName(), o.getStaffPhoneNumber(), o.getSumAssured()
                , o.getEffectiveDate(), o.getMaturityDate(), o.getExpiryDate(), o.getPremiumMode()));
            }
        }
        return listSearch;
    }
    public List<ContractDetails> getAllByCustomerIDAndContractID(String CustomerID,String contracID) {
        List<ContractDetails> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    ic.ContractID,\n" +
"    ip.PackageName,\n" +
"    ic.SumAssured,\n" +
"    ic.PremiumMode,\n" +
"    iper.FullName AS InsurancePersonFullName,\n" +
"    bper.FullName AS BeneficiaryPersonFullName,\n" +
"    c.FullName AS CustomerFullName,\n" +
"    s.FullName AS StaffFullName,\n" +
"    s.PhoneNumber AS StaffPhoneNumber,\n" +
"    ic.EffectiveDate,\n" +
"    ic.MaturityDate,\n" +
"    ic.ExpiryDate\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Insurance_Package ip ON ic.PackageID = ip.PackageID\n" +
"    INNER JOIN Package_Detail pd ON ip.PackageDetailID = pd.PackageDetailID\n" +
"    INNER JOIN Insurance_Person iper ON ic.InsuranID = iper.InsuranID\n" +
"    INNER JOIN Beneficiary_Person bper ON ic.BeneID = bper.BeneID\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Staff s ON ic.StaffID = s.StaffID\n" +
        "WHERE c.CustomerID = ? and ic.ContractID=?;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, CustomerID);
            st.setString(2, contracID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContractDetails s = new ContractDetails(rs.getString("contractID"),rs.getString("packageName"),rs.getString("insurancePersonFullName")
                        ,rs.getString("beneficiaryPersonFullName"),rs.getString("customerFullName"),rs.getString("staffFullName")
                        ,rs.getString("staffPhoneNumber"), rs.getLong("sumAssured"), rs.getDate("effectiveDate"),rs.getDate("maturityDate")
                        ,rs.getDate("expiryDate"), rs.getString("premiumMode")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
public List<ContractDetails> getAllByStaffIDAndContractID(String StaffID,String contracID) {
        List<ContractDetails> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    ic.ContractID,\n" +
"    ip.PackageName,\n" +
"    ic.SumAssured,\n" +
"    ic.PremiumMode,\n" +
"    iper.FullName AS InsurancePersonFullName,\n" +
"    bper.FullName AS BeneficiaryPersonFullName,\n" +
"    c.FullName AS CustomerFullName,\n" +
"    s.FullName AS StaffFullName,\n" +
"    s.PhoneNumber AS StaffPhoneNumber,\n" +
"    ic.EffectiveDate,\n" +
"    ic.MaturityDate,\n" +
"    ic.ExpiryDate\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Insurance_Package ip ON ic.PackageID = ip.PackageID\n" +
"    INNER JOIN Package_Detail pd ON ip.PackageDetailID = pd.PackageDetailID\n" +
"    INNER JOIN Insurance_Person iper ON ic.InsuranID = iper.InsuranID\n" +
"    INNER JOIN Beneficiary_Person bper ON ic.BeneID = bper.BeneID\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Staff s ON ic.StaffID = s.StaffID\n" +
        "WHERE s.StaffID = ? and ic.ContractID=?;";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, StaffID);
            st.setString(2, contracID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ContractDetails s = new ContractDetails(rs.getString("contractID"),rs.getString("packageName"),rs.getString("insurancePersonFullName")
                        ,rs.getString("beneficiaryPersonFullName"),rs.getString("customerFullName"),rs.getString("staffFullName")
                        ,rs.getString("staffPhoneNumber"), rs.getLong("sumAssured"), rs.getDate("effectiveDate"),rs.getDate("maturityDate")
                        ,rs.getDate("expiryDate"), rs.getString("premiumMode")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        ContractDetailDAO st=new ContractDetailDAO();
        //List<ContractDetails> list = st.getAllByStaffIDAndContractID("STA001", "CON001");
        //List<ContractDetails> list1=st.getAllContractsByName("CON001");
        List<ContractDetails> list1 = st.getAllByCustomerID("CUS001");
        //List<ContractDetails> list2 = st.getAllByCustomerIDAndContractID("C001","CON001");
        
        System.out.println(list1.size());
        
    }
}
 