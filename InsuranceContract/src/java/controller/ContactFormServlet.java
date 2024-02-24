/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ContactFormDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.ContactForm;
import model.InsurancePackage;
import model.Staff;

/**
 *
 * @author DUong
 */
@WebServlet(name = "ContactFormServlet", urlPatterns = {"/contactForm"})
public class ContactFormServlet extends HttpServlet {

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

        //response.setContentType("text/html;charset=UTF-8");
        //HttpSession session = request.getSession();
        //Staff staff = (Staff) session.getAttribute("authcode");
        //String statusFilter = request.getParameter("statusFilter");
        //String searchKeyword = request.getParameter("searchKeyword");
        //if (staff == null) {
        //response.sendRedirect("Login.jsp");
        //return;
        //}
        //ContactFormDAO cf = new ContactFormDAO();
        //List<ContactForm> listCf = cf.getAll();
        //request.setAttribute("contactFormList", listCf);
        //request.getRequestDispatcher("ContactForm.jsp").forward(request, response);
        doPost(request, response);
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //String value = request.getParameter("actions");
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("authcode");

        if (staff == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        //if ("Gửi thông tin".equals(value) == false && "update".equals(value) == false && "Filter".equals(value) == false && "search".equals(value) == false) {
        ContactFormDAO cf = new ContactFormDAO();
        List<ContactForm> listCf = cf.getAll();
        //request.setAttribute("contactFormList", listCf);
        //request.getRequestDispatcher("ContactForm.jsp").forward(request, response);
        //}
        //String statusFilter1 = request.getParameter("statusFilter");
        //String searchKeyword1 = request.getParameter("searchKeyword");
        //session1.setAttribute("statusFilterCF", statusFilter1);
        //session1.setAttribute("searchKeywordCF", searchKeyword1);
        //session1.setMaxInactiveInterval(600);
        String statusFilter = (String) session.getAttribute("statusFilterCF");
        String searchKeyword = (String) session.getAttribute("searchKeywordCF");
        if (statusFilter == null) {
            statusFilter = "";
        }
        if (searchKeyword == null) {
            searchKeyword = "";
        }
        List<ContactForm> resultList = cf.getAllByEmailOrPhoneNumber(searchKeyword);
        List<ContactForm> filteredList = new ArrayList<>();
        if (statusFilter.isEmpty() && searchKeyword.isEmpty()) {
            filteredList = cf.getAll();
            //filteredList = cf.getAllByEmailOrPhoneNumber("a");
            request.setAttribute("contactFormList", filteredList);
        }
        if (statusFilter.isEmpty() == false && searchKeyword.isEmpty()) {
            filteredList = cf.getAllByStatus(statusFilter);
            request.setAttribute("contactFormList", filteredList);
        }
        if (statusFilter.isEmpty() && searchKeyword.isEmpty() == false) {
            resultList = cf.getAllByEmailOrPhoneNumber(searchKeyword);
            request.setAttribute("contactFormList", resultList);
        }
        if (statusFilter.isEmpty() == false && searchKeyword.isEmpty() == false) {
            for (ContactForm contactForm : resultList) {
                if (contactForm.getStatus().equals(statusFilter)) {
                    filteredList.add(contactForm);
                }
            }
            request.setAttribute("contactFormList", filteredList);
        }
        request.setAttribute("statusFilterValue", statusFilter);
        request.setAttribute("searchKeywordValue", searchKeyword);
        request.getRequestDispatcher("ContactForm.jsp").forward(request, response);
        
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String value = request.getParameter("actions");
        HttpSession session = request.getSession();

        if ("Gửi thông tin".equals(value)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("ph-no");
            String supportMessage = request.getParameter("content");
            ContactFormDAO cf = new ContactFormDAO();
            List<ContactForm> listCf;
            cf.addContactForm(name, email, phoneNumber, supportMessage, "Đang chờ");
            response.sendRedirect("index.html");
            //PrintWriter out = response.getWriter();
            //out.println("<script type=\"text/javascript\">");
            //out.println("alert('Đã gửi thành công!');");
            //out.println("window.location.href = 'index.html';");
            //out.println("</script>");
            //}
        }
        if ("update".equals(value)) {
            String guestIDParam = request.getParameter("guestID");
            int guestID = Integer.parseInt(guestIDParam);
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            ContactFormDAO cf = new ContactFormDAO();
            List<ContactForm> listCf;
            cf.updateContactForm(guestID, "Đã trả lời", currentTimestamp);
            listCf = cf.getAll();
            request.setAttribute("contactFormList", listCf);
            request.getRequestDispatcher("ContactForm.jsp").forward(request, response);
        }
        if ("Filter".equals(value) || "search".equals(value)) {
            String statusFilter1 = request.getParameter("statusFilter");
            String searchKeyword1 = request.getParameter("searchKeyword");
            session.setAttribute("statusFilterCF", statusFilter1);
            session.setAttribute("searchKeywordCF", searchKeyword1);
            session.setMaxInactiveInterval(600);
            String statusFilter = (String) session.getAttribute("statusFilterCF");
            String searchKeyword = (String) session.getAttribute("searchKeywordCF");
            if (statusFilter == null) {
                statusFilter = "";
            }
            if (searchKeyword == null) {
                searchKeyword = "";
            }
            ContactFormDAO cf = new ContactFormDAO();
            List<ContactForm> resultList = cf.getAllByEmailOrPhoneNumber(searchKeyword);
            List<ContactForm> filteredList = new ArrayList<>();
            if (statusFilter.isEmpty() && searchKeyword.isEmpty()) {
                filteredList = cf.getAll();
                //filteredList = cf.getAllByEmailOrPhoneNumber("a");
                request.setAttribute("contactFormList", filteredList);
            }
            if (statusFilter.isEmpty() == false && searchKeyword.isEmpty()) {
                filteredList = cf.getAllByStatus(statusFilter);
                request.setAttribute("contactFormList", filteredList);
            }
            if (statusFilter.isEmpty() && searchKeyword.isEmpty() == false) {
                resultList = cf.getAllByEmailOrPhoneNumber(searchKeyword);
                request.setAttribute("contactFormList", resultList);
            }
            if (statusFilter.isEmpty() == false && searchKeyword.isEmpty() == false) {
                for (ContactForm contactForm : resultList) {
                    if (contactForm.getStatus().equals(statusFilter)) {
                        filteredList.add(contactForm);
                    }
                }
                request.setAttribute("contactFormList", filteredList);
            }

            request.setAttribute("statusFilterValue", statusFilter);
            request.setAttribute("searchKeywordValue", searchKeyword);
            request.getRequestDispatcher("ContactForm.jsp").forward(request, response);
        }
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
