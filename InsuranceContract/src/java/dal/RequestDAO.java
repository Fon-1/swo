/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.RequestChangeInfo;

/**
 *
 * @author dell
 */
public class RequestDAO extends DBContext {

    public List<RequestChangeInfo> getAllRequestChangeInfo() {
        List<RequestChangeInfo> list = new ArrayList<>();
        String sql = "select * from REQUEST_CHANGEINFO order by requestID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int requestID = rs.getInt(1);
                String customerID = rs.getString(2);
                String fullName = rs.getString(3);
                String CCCD_imgFront = rs.getString(4);
                String CCCD_imgBack = rs.getString(5);
                String CCCD = rs.getString(6);
                int gender = rs.getInt(7);
                String dob = rs.getString(8);
                String nationality = rs.getString(9);
                String issuedDate = rs.getString(10);
                String expiredDate = rs.getString(11);
                String issuedPlace = rs.getString(12);
                String marital_img = rs.getString(13);
                String maritalStatus = rs.getString(14);
                String education_img = rs.getString(15);
                String education = rs.getString(16);
                String job = rs.getString(17);
                String address = rs.getString(18);
                String phoneNumber = rs.getString(19);
                String email = rs.getString(20);
                String timeCreate = rs.getString(21);
                String status = rs.getString(22);
                RequestChangeInfo req = new RequestChangeInfo(requestID, customerID,
                        fullName, CCCD_imgFront, CCCD_imgBack, CCCD, gender, dob,
                        nationality, issuedDate, expiredDate, issuedPlace, marital_img,
                        maritalStatus, education_img, education, job, address,
                        phoneNumber, email, timeCreate, status);
                list.add(req);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public RequestChangeInfo getRequestUpdateProfileByRequestID(int requestID) {
        String sql = "select * from REQUEST_CHANGEINFO where requestID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, requestID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String customerID = rs.getString(2);
                String fullName = rs.getString(3);
                String CCCD_imgFront = rs.getString(4);
                String CCCD_imgBack = rs.getString(5);
                String CCCD = rs.getString(6);
                int gender = rs.getInt(7);
                String dob = rs.getString(8);
                String nationality = rs.getString(9);
                String issuedDate = rs.getString(10);
                String expiredDate = rs.getString(11);
                String issuedPlace = rs.getString(12);
                String marital_img = rs.getString(13);
                String maritalStatus = rs.getString(14);
                String education_img = rs.getString(15);
                String education = rs.getString(16);
                String job = rs.getString(17);
                String address = rs.getString(18);
                String phoneNumber = rs.getString(19);
                String email = rs.getString(20);
                String timeCreate = rs.getString(21);
                String status = rs.getString(22);
                RequestChangeInfo req = new RequestChangeInfo(requestID, customerID,
                        fullName, CCCD_imgFront, CCCD_imgBack, CCCD, gender, dob,
                        nationality, issuedDate, expiredDate, issuedPlace, marital_img,
                        maritalStatus, education_img, education, job, address,
                        phoneNumber, email, timeCreate, status);
                return req;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addRequestUpdateProfile(RequestChangeInfo request) {
        String sql = "INSERT INTO [dbo].[REQUEST_CHANGEINFO]\n"
                + "           ([CustomerID]\n"
                + "           ,[FullName]\n"
                + "           ,[CCCD_imgFront]\n"
                + "           ,[CCCD_imgBack]\n"
                + "           ,[CCCD]\n"
                + "           ,[Gender]\n"
                + "           ,[DOB]\n"
                + "           ,[Nationality]\n"
                + "           ,[IssuedDate]\n"
                + "           ,[ExpiredDate]\n"
                + "           ,[IssuedPlace]\n"
                + "           ,[Marital_img]\n"
                + "           ,[MaritalStatus]\n"
                + "           ,[Education_img]\n"
                + "           ,[Education]\n"
                + "           ,[Job]\n"
                + "           ,[Address]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Email]\n"
                + "           ,[TimeCreate]\n"
                + "           ,[Status])\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, request.getCustomerID());
            st.setString(2, request.getFullName());
            st.setString(3, request.getCCCD_imgFront());
            st.setString(4, request.getCCCD_imgBack());
            st.setString(5, request.getCCCD());
            st.setInt(6, request.getGender());
            st.setString(7, request.getDob());
            st.setString(8, request.getNationality());
            st.setString(9, request.getIssuedDate());
            st.setString(10, request.getExpiredDate());
            st.setString(11, request.getIssuedPlace());
            st.setString(12, request.getMarital_img());
            st.setString(13, request.getMaritalStatus());
            st.setString(14, request.getEducation_img());
            st.setString(15, request.getEducation());
            st.setString(16, request.getJob());
            st.setString(17, request.getAddress());
            st.setString(18, request.getPhoneNumber());
            st.setString(19, request.getEmail());
            st.setString(20, request.getTimeCreate());
            st.setString(21, request.getStatus());
            st.executeQuery();
        } catch (Exception e) {
            System.out.println("Error roi!");
        }
    }

    public static void main(String[] args) {
        RequestDAO redao = new RequestDAO();
//        RequestChangeInfo request = new RequestChangeInfo("kekkon", "fpt", "sv", "fptu", "324564812", "thinh@jfia.com", "C001");
//        redao.addRequestChangeInfo(request);
        RequestChangeInfo req = redao.getRequestUpdateProfileByRequestID(2);
        System.out.println(req.getFullName());
    }
}
