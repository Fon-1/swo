/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.Customer;
import model.RequestChangeInfo;

/**
 *
 * @author dell
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
@WebServlet(name="UpdateProfileServlet", urlPatterns={"/updateProfile"})
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("authcode");
        if (customer == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("authcode");
        String path = "D:\\FPTU\\Spring2024\\SWP391\\Git_Insurance\\SWP391\\InsuranceContract\\web\\imgFile\\";
        try {
            String customerID = customer.getCustomerID();
            Part imgCCCDFront = request.getPart("imgCCCDFront");
            String fileImgCCCDFront = imgCCCDFront.getSubmittedFileName();
            imgCCCDFront.write(path + fileImgCCCDFront);
            Part imgCCCDBack = request.getPart("imgCCCDBack");
            String fileImgCCCDBack = imgCCCDBack.getSubmittedFileName();
            imgCCCDBack.write(path + fileImgCCCDBack);
            String CCCD = request.getParameter("txtCCCD");
            String fullName = request.getParameter("txtFullName");
            String dob = request.getParameter("dob");
            int gender = Integer.parseInt(request.getParameter("intGender"));
            String nationality = request.getParameter("txtNationality");
            String issuedDate = request.getParameter("issuedDate");
            String expiredDate = request.getParameter("expiredDate");
            String issuedPlace = request.getParameter("txtIssuedPlace");
            Part imgMartial = request.getPart("imgMartial");
            String fileImgMartial = imgMartial.getSubmittedFileName();
            imgMartial.write(path + imgMartial);
            String maritalStatus = request.getParameter("txtMaritalStatus");
            Part imgEducation = request.getPart("imgEducation");
            String fileImgEducation = imgEducation.getSubmittedFileName();
            imgEducation.write(path + imgEducation);
            String education = request.getParameter("txtEducation");
            String job = request.getParameter("txtJob");
            String phoneNumber = request.getParameter("txtPhoneNumber");
            String address = request.getParameter("txtAddress");
            String email = request.getParameter("email");
            String timeCreate = getCurrentDate();
            String status = "Chưa xác minh";
            if (!checkDOB(dob)) {
                request.setAttribute("dobError", "Người thụ hưởng phải đủ 18 tuổi trở lên.");
                request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
            }
            if (!CCCD.isEmpty() && CCCD.length() != 12) {
                request.setAttribute("cccdError", "CCCD phải bao gồm 12 chữ số.");
                request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
            }
            if (!phoneNumber.isEmpty() && !checkPhoneNumber(phoneNumber)) {
                request.setAttribute("phoneError", "Số điện thoại phải có dạng 0xxxxxxxxx. (10 chữ số)");
                request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
            }
            RequestChangeInfo updateProfile = new RequestChangeInfo(customerID, fullName,
                    fileImgCCCDFront, fileImgCCCDBack, CCCD, gender, dob, nationality,
                    issuedDate, expiredDate, issuedPlace, fileImgMartial, maritalStatus, fileImgEducation,
                    education, job, address, phoneNumber, email, timeCreate, status);
            RequestDAO redao = new RequestDAO();
            redao.addRequestUpdateProfile(updateProfile);
            request.setAttribute("updateMessage", "Gửi yêu cầu thay đổi thành công.");
            request.getRequestDispatcher("customerHomepage").forward(request, response);
        } catch (Exception e) {
            System.out.println();
        }
    }

    public String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentTime = dateFormat.format(date);
        return currentTime;
    }
    
    boolean checkDOB(String dob) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        try {
            Date DOB = dateFormat.parse(dob);
            if (DOB.before(calendar.getTime())) {
                return true;
            }
        } catch (ParseException e) {
        }
        return false;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        String phoneRegex = "^(0\\d{9}|[1-9]\\d{9})$";
        if (phoneNumber.matches(phoneRegex)) {
            return true;
        }
        return false;
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
