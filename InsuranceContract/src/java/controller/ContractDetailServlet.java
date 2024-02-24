/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BeneficiaryPersonDAO;
import dal.ContractDAO;
import dal.DetailFeeDAO;
import dal.InsurancePackageDAO;
import dal.InsurancePersonDAO;
import dal.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.BeneficiaryPerson;
import model.Customer;
import model.DetailFee;
import model.InsuranceContract;
import model.InsurancePackage;
import model.InsurancePerson;
import model.Staff;

/**
 *
 * @author DUong
 */
@WebServlet(name = "ContractDetailServlet", urlPatterns = {"/contractDetail"})
public class ContractDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateContractServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateContractServlet at " + request.getContextPath() + "</h1>");
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
        Customer customer = (Customer) session.getAttribute("authcode");
        if (customer == null) {
            response.sendRedirect("Login.jsp");
        }
        String contractID = request.getParameter("contractID");

        ContractDAO contractDAO = new ContractDAO();
        InsuranceContract contract = contractDAO.getContractByID(contractID);
        request.setAttribute("contract", contract);

        InsurancePackageDAO insuPackageDAO = new InsurancePackageDAO();
        List<InsurancePackage> insuPackage = insuPackageDAO.getAllInsurancePackage();
        request.setAttribute("insuPackage", insuPackage);

        InsurancePersonDAO insuPersonDAO = new InsurancePersonDAO();
        List<InsurancePerson> insuPerson = insuPersonDAO.getAllInsurancePerson();
        request.setAttribute("insuPerson", insuPerson);

        BeneficiaryPersonDAO benePersonDAO = new BeneficiaryPersonDAO();
        List<BeneficiaryPerson> benePerson = benePersonDAO.getAllBeneficiaryPerson();
        request.setAttribute("benePerson", benePerson);

        DetailFeeDAO detailFeeDAO = new DetailFeeDAO();
        List<DetailFee> detailFee = detailFeeDAO.getAllDetailFee();
        request.setAttribute("detailFee", detailFee);

        StaffDAO staffDAO = new StaffDAO();
        List<Staff> staff = staffDAO.getAllStaff();
        request.setAttribute("staff", staff);

        request.getRequestDispatcher("ViewContractDetailCustomer.jsp").forward(request, response);
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