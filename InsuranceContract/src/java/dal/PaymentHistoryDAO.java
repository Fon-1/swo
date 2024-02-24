/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import java.math.BigInteger;
import model.EventDetail;

/**
 *
 * @author Asus
 */
public class PaymentHistoryDAO extends DBContext{
    public List<Bill> getAll() {
        List<Bill> list=new ArrayList<>();
        String sql = "select * from Bill";
        try {
            PreparedStatement st =connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Bill s = new Bill(rs.getString("BillID"),rs.getString("ContractID"),rs.getString("CreatedDate"),rs.getString("Status"),rs.getLong("Amount"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Bill> getAllPaymentByCustomerID(String CustomerID) {
        List<Bill> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    b.BillID,\n" +
"    b.ContractID,\n" +
"    CONVERT (varchar, CreatedDate, 103) as CreatedDateF,\n" +
"    b.Status,\n" +
"    b.Amount\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Bill b ON ic.ContractID = b.ContractID\n" +
"WHERE c.CustomerID = ? "+
"ORDER BY CreatedDate DESC";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, CustomerID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Bill s = new Bill(rs.getString("BillID"),rs.getString("ContractID"),rs.getString("CreatedDateF"),rs.getString("Status"),rs.getLong("Amount"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        PaymentHistoryDAO st=new PaymentHistoryDAO();
        List<Bill> list = st.getAllPaymentByCustomerID("CUS001");
        System.out.println(list.size());
    }
    
}
