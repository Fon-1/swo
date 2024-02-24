/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CustomerDAO;
import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.RequestChangeInfo;

/**
 *
 * @author dell
 */
@WebServlet(name="UpdateCustomerProfileServlet", urlPatterns={"/updateCustomerProfile"})
public class UpdateCustomerProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
        int requestID = Integer.parseInt(request.getParameter("requestID"));
        RequestDAO redao = new RequestDAO();
        RequestChangeInfo req = redao.getRequestUpdateProfileByRequestID(requestID);
        request.setAttribute("requestUpdate", req);
        request.getRequestDispatcher("UpdateCustomerProfile.jsp").forward(request, response);
        } catch (Exception e) {
        }     
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
        request.setCharacterEncoding("UTF-8");
        try {
//            String customerID = request.getParameter("customerID");
//            String CCCD = request.getParameter("cccd");
//            String fullName = request.getParameter("fullName");
//            String dob = request.getParameter("dob");
//            int gender = Integer.parseInt(request.getParameter("gender"));
//            String nationality = request.getParameter("nationality");
//            String issuedDate = request.getParameter("issuedDate");
//            String expiredDate = request.getParameter("expiredDate");
//            String issuedPlace = request.getParameter("issuedPlace");
//            String maritalStatus = request.getParameter("maritalStatus");
//            String education = request.getParameter("education");
//            String job = request.getParameter("job");
//            String phoneNumber = request.getParameter("phoneNumber");
//            String address = request.getParameter("address");
//            String email = request.getParameter("email");
            int requestID = Integer.parseInt(request.getParameter("requestID"));
            RequestDAO redao = new RequestDAO();
            RequestChangeInfo req = redao.getRequestUpdateProfileByRequestID(requestID);
            Customer updateCustomer = new Customer(req.getCustomerID(), req.getFullName(), req.getCCCD(), req.getGender(), 
                    req.getDob(), req.getNationality(), req.getIssuedDate(), req.getExpiredDate(), req.getIssuedPlace(), req.getMaritalStatus(), 
                    req.getEducation(), req.getJob(), req.getAddress(), req.getPhoneNumber(), req.getEmail());
            CustomerDAO cusdao = new CustomerDAO();
            cusdao.updateCustomerInfo(updateCustomer);
            request.getRequestDispatcher("staffHomepage").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
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
