/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.InsurancePerson;
import model.Staff;

/**
 *
 * @author maian
 */
@WebServlet(name = "CreateInsurancePersonServlet", urlPatterns = {"/createinsuperson"})
public class CreateInsurancePersonServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateInsurancePersonServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateInsurancePersonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("authcode");
        String action = request.getParameter("action");
        if (staff == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (action == null) {
            request.getRequestDispatcher("CreateInsurancePerson.jsp").forward(request, response);
        } else {
            try {
                String fullName = request.getParameter("fullName");
                int gender = Integer.parseInt(request.getParameter("gender"));
                String dob = request.getParameter("dob");
                String cccd = request.getParameter("cccd");
                String nationality = request.getParameter("nationality");
                String maritalStatus = request.getParameter("maritalStatus");
                String education = request.getParameter("education");
                String job = request.getParameter("job");
                String address = request.getParameter("address");
                String phoneNumber = request.getParameter("phoneNumber");
                String email = request.getParameter("email");
                InsurancePerson insuPerson = new InsurancePerson(fullName, gender,
                        dob, cccd, nationality, maritalStatus, education, job,
                        address, phoneNumber, email);
                session.setAttribute("insuPerson", insuPerson);
                if (!checkDOB(dob)) {
                    request.setAttribute("dobError", "Người được bảo hiểm phải trên 30 ngày tuổi.");
                    request.getRequestDispatcher("CreateInsurancePerson.jsp").forward(request, response);
                }
                if (!checkCCCD(cccd)) {
                    request.setAttribute("cccdError", "CCCD phải bao gồm 12 chữ số.");
                    request.getRequestDispatcher("CreateInsurancePerson.jsp").forward(request, response);
                }
                if (!checkPhoneNumber(phoneNumber)) {
                    request.setAttribute("phoneError", "Số điện thoại phải có dạng 0xxxxxxxxx.");
                    request.getRequestDispatcher("CreateInsurancePerson.jsp").forward(request, response);
                }
                request.getRequestDispatcher("CreateBeneficiaryPerson.jsp").forward(request, response);
            } catch (NumberFormatException e) {
            }
        }
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

    boolean checkCCCD(String cccd) {
        String regex = "\\d{12}";
        if (cccd.isEmpty()) {
            return true;
        } else if (cccd.matches(regex)) {
            return true;
        }
        return false;
    }

    boolean checkDOB(String dob) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -30);
        try {
            Date DOB = dateFormat.parse(dob);
            if (DOB.before(calendar.getTime())) {
                return true;
            }
        } catch (ParseException e) {
        }
        return false;
    }

    boolean checkPhoneNumber(String phoneNumber) {
        String phoneRegex = "^(0\\d{9}|[1-9]\\d{9})$";
        if (phoneNumber.isEmpty()) {
            return true;
        } else if (phoneNumber.matches(phoneRegex)) {
            return true;
        }
        return false;
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
