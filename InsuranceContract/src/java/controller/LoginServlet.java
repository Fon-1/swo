/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.LoginController;

import dal.LoginDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Staff;

/**
 *
 * @author dell
 */
@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {

            for (Cookie c : cookies) {
                if (c.getName().equals("userC")) {
                    request.setAttribute("username", c.getValue());
                }
                if (c.getName().equals("passC")) {
                    request.setAttribute("password", c.getValue());
                }
            }
        }
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        LoginDBContext dao = new LoginDBContext();
        Staff staff = dao.loginStaff(user, pass);
        Customer customer = dao.login(user, pass);
        if (customer == null && staff == null) {
            String errorMessage = "Mã tài khoản và mật khẩu không hợp lệ! Vui lòng thử lại.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (staff == null && customer != null) {
            String remember = request.getParameter("remember");

            HttpSession session = request.getSession();
            session.setAttribute("authcode", customer);
            session.setMaxInactiveInterval(3600);
            Cookie u = new Cookie("userC", user);
            Cookie p = new Cookie("passC", pass);
            u.setMaxAge(60);
            if (remember != null) {
                p.setMaxAge(60);
            } else {
                p.setMaxAge(0);
            }
            response.addCookie(u);
            response.addCookie(p);
            request.getRequestDispatcher("customerHomepage").forward(request, response);
        } else if (staff != null && customer == null) {
            String remember = request.getParameter("remember");

            HttpSession session = request.getSession();
            session.setAttribute("authcode", staff);
            session.setMaxInactiveInterval(3600);
            Cookie u = new Cookie("userC", user);
            Cookie p = new Cookie("passC", pass);
            u.setMaxAge(60);
            if (remember != null) {
                p.setMaxAge(60);
            } else {
                p.setMaxAge(0);
            }
            response.addCookie(u);
            response.addCookie(p);
            request.getRequestDispatcher("staffHomepage").forward(request, response);
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
