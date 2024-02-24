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
import model.EventDetail;

/**
 *
 * @author Asus
 */
public class AccidentHistoryDAO extends DBContext{
    public List<EventDetail> getAll() {
        List<EventDetail> list=new ArrayList<>();
        String sql = "select * from Event_Detail";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EventDetail s = new EventDetail(rs.getString("EventID"),rs.getString("Address"), rs.getString("HospitalName"),rs.getString("EventDate"), rs.getString("ToDate"),rs.getString("FromDate"),rs.getString("InjuryType"), rs.getString("Diagnosis"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<EventDetail> getAllAccidentByCustomerID(String CustomerID) {
        List<EventDetail> list=new ArrayList<>();
        String sql = "SELECT\n" +
"    e.EventID,\n" +
"    e.Address,\n" +
"    e.HospitalName,\n" +
"    CONVERT (varchar, EventDate, 103) as EventDateF,\n" +
"    CONVERT (varchar, ToDate, 103) as ToDateF,\n" +     
"    CONVERT (varchar, FromDate, 103) as FromDateF,\n" +
"    e.InjuryType,\n" +
"    e.Diagnosis\n" +
"FROM\n" +
"    Insurance_contract ic\n" +
"    INNER JOIN Customer c ON ic.CustomerID = c.CustomerID\n" +
"    INNER JOIN Claim cl ON ic.ContractID = cl.ContractID\n" +
"    INNER JOIN Event_Detail e ON cl.EventID = e.EventID\n" +
"WHERE c.CustomerID = ? "+
"ORDER BY EventDate DESC";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, CustomerID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EventDetail s = new EventDetail(rs.getString("EventID"),rs.getString("Address"), rs.getString("HospitalName"),rs.getString("EventDateF"), rs.getString("FromDateF"), rs.getString("ToDateF"),rs.getString("InjuryType"), rs.getString("Diagnosis"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        AccidentHistoryDAO st=new AccidentHistoryDAO();
        List<EventDetail> list = st.getAllAccidentByCustomerID("CUS001");
        System.out.println(list.size());
    }
}
