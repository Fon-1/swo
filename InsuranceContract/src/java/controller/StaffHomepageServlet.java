/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CustomerDAO;
import dal.ContractDAO;
import dal.InsurancePackageDAO;
import dal.InsurancePersonDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Customer;
import model.InsuranceContract;
import model.InsurancePackage;
import model.InsurancePerson;
import model.Staff;

/**
 *
 * @author dell
 */
@WebServlet(name="StaffHomepageServlet", urlPatterns={"/staffHomepage"})
public class StaffHomepageServlet extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("authcode");
        if (staff == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> listCustomer = customerDAO.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);

        // Lấy danh sách hợp đồng cho từng khách hàng
        Map<Customer, List<InsuranceContract>> contractsByCustomer = new HashMap<>();
        ContractDAO contractDAO = new ContractDAO();
        for (Customer customer : listCustomer) {
            List<InsuranceContract> contracts = contractDAO.getContractByCustomerID(customer.getCustomerID());
            contractsByCustomer.put(customer, contracts);
        }
        
        
        ContractDAO cf = new ContractDAO();
        List<InsuranceContract> contractList = cf.getAllContract();
        request.setAttribute("contractList", contractList);
        
        InsurancePackageDAO insuPackageDAO = new InsurancePackageDAO();
        List<InsurancePackage> insuPackage = insuPackageDAO.getAllInsurancePackage();
        request.setAttribute("insuPackage", insuPackage);
        
        InsurancePersonDAO insuPersonDAO = new InsurancePersonDAO();
        List<InsurancePerson> insuPerson = insuPersonDAO.getAllInsurancePerson();
        request.setAttribute("insuPerson", insuPerson);
        
        request.getRequestDispatcher("StaffHomepage.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("authcode");
        if (staff == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }        
//        CustomerDAO staffdao = new CustomerDAO();
//        List<Customer> listCustomer = staffdao.getAllCustomer();        
//        request.setAttribute("listCustomer", listCustomer);
        
         // Lấy danh sách khách hàng và hợp đồng tương ứng
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> listCustomer = customerDAO.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);

        // Lấy danh sách hợp đồng cho từng khách hàng
        Map<Customer, List<InsuranceContract>> contractsByCustomer = new HashMap<>();
        ContractDAO contractDAO = new ContractDAO();
        for (Customer customer : listCustomer) {
            List<InsuranceContract> contracts = contractDAO.getContractByCustomerID(customer.getCustomerID());
            contractsByCustomer.put(customer, contracts);
        }
        
        
        ContractDAO cf = new ContractDAO();
        List<InsuranceContract> contractList = cf.getAllContract();
        request.setAttribute("contractList", contractList);
        
        InsurancePackageDAO insuPackageDAO = new InsurancePackageDAO();
        List<InsurancePackage> insuPackage = insuPackageDAO.getAllInsurancePackage();
        request.setAttribute("insuPackage", insuPackage);
        
        InsurancePersonDAO insuPersonDAO = new InsurancePersonDAO();
        List<InsurancePerson> insuPerson = insuPersonDAO.getAllInsurancePerson();
        request.setAttribute("insuPerson", insuPerson);
        
        request.getRequestDispatcher("StaffHomepage.jsp").forward(request, response);
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
