/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.LoginController;

import dal.LoginDBContext;
import dal.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author dell
 */
@WebServlet(name="SignupControl", urlPatterns={"/SignupControl"})
public class SignupControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("newuser");
        String email = request.getParameter("email");
        String newpass = request.getParameter("newpass");
        
        LoginDBContext dao = new LoginDBContext();
        Customer checkCustomer = dao.checkAccount(user);
        
        Customer checkEmail = dao.getEmail(email);
        if(checkCustomer != null || checkEmail != null ){
              String alertMessage = "Sign up failed, Email and password exist!";
              request.setAttribute("alertMessage", alertMessage);
             request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else{
        SendEmail sm = new SendEmail();
        String code = sm.getRandom();
        Customer c = new Customer(user, code, email, newpass);
        boolean test = sm.sendEmail(c);
        
        
        if (test) {
            HttpSession session = request.getSession();

            session.setAttribute("authcode", c);
            response.sendRedirect("verify.jsp");
        } else {
            response.sendRedirect("Login.jsp");
        }
        }
//       String gender=request.getParameter("gender");
//       String dob=request.getParameter("dob");
//       String phone=request.getParameter("phone");
//       else{
//            LoginDBContext dao = new LoginDBContext();
//           Account a=dao.checkAccount(user);
//           if(a==null){
//               dao.signup(user, pass,email);
//               response.sendRedirect("Login.jsp");
//           }
//           else{
//               response.sendRedirect("Login.jsp");
//           }
//       }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
