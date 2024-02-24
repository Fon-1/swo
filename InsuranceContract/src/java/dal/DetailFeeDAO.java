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
import model.DetailFee;

/**
 *
 * @author maian
 */
public class DetailFeeDAO extends DBContext {

    public void insertDetailFee(DetailFee detailFee) {
        String sql = "insert into DETAIL_FEE (ContractID, PaymentDueDate, PremiumPayment, [Status]) values (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, detailFee.getContractID());
            st.setString(2, detailFee.getPaymentDueDate());
            st.setLong(3, detailFee.getPremiumPayment());
            st.setString(4, detailFee.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<DetailFee> getAllDetailFee() {
        List<DetailFee> list = new ArrayList<>();
        String sql = "select * from DETAIL_FEE";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String contractID = rs.getString("ContractID");
                String premiumDueDate = formatDate(rs.getString("PaymentDueDate"));
                long premiumPayment = rs.getLong("PremiumPayment");
                String status = rs.getString("Status");
                DetailFee detailFee = new DetailFee(contractID, premiumDueDate, premiumPayment, status);
                list.add(detailFee);
            }
        } catch (SQLException e) {
        }
        return list;
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