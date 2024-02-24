/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ContractDAO;
import dal.InsurancePackageDAO;
import dal.InsurancePersonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.InsuranceContract;
import model.InsurancePackage;
import model.InsurancePerson;

/**
 *
 * @author maian
 */
@WebServlet(name="ListContract", urlPatterns={"/listcontract"})
public class ListContractServlet extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListContract</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListContract at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        ContractDAO contractDAO = new ContractDAO();
        InsurancePackageDAO insuPackageDAO = new InsurancePackageDAO();
        InsurancePersonDAO insuPersonDAO = new InsurancePersonDAO();
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("authcode");
        List<InsuranceContract> contract = contractDAO.getContractByCustomerID(customer.getCustomerID());
        List<InsurancePackage> insuPackage = insuPackageDAO.getAllInsurancePackage();
        List<InsurancePerson> insuPerson = new ArrayList<>();
        for (InsuranceContract insuranceContract : contract) {
            InsurancePerson insu = insuPersonDAO.getInsurancePersonByID(insuranceContract.getInsuranID());
            insuPerson.add(insu);
        }
        request.setAttribute("contract", contract);
        request.setAttribute("insuPackage", insuPackage);
        request.setAttribute("insuPerson", insuPerson);
        request.setAttribute("size", contract.size());
        request.getRequestDispatcher("CustomerHomepage.jsp").forward(request, response);
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
