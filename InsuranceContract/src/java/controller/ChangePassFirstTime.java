/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.LoginDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "ChangePassFirstTime", urlPatterns = {"/ChangePassFirstTime"})
public class ChangePassFirstTime extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

       try (PrintWriter out = response.getWriter()) {
    HttpSession session = request.getSession(); // Lấy session từ request
    LoginDBContext dao = new LoginDBContext();
    String customerID = request.getParameter("customerid");
    String password = request.getParameter("confirm");
    String repassword = request.getParameter("reconfirm");
    
    if (password.isEmpty() || repassword.isEmpty()) {
        String errorMessage = "mật khẩu mới và nhập lại mật khẩu mới không được để trống. Vui lòng thử lại.";
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("ChangePasswordFirstTime.jsp").forward(request, response);
    } else if (!password.equals(repassword)) {
        String errorMessage = "Mật khẩu không khớp. Vui lòng thử lại.";
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("ChangePasswordFirstTime.jsp").forward(request, response);
    } else {
        dao.updatePass(customerID, password);
        out.print("Cập nhật mật khẩu thành công");
    }
}

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
