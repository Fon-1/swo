/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BeneficiaryPersonDAO;
import dal.ContractDAO;
import dal.CustomerDAO;
import dal.DetailFeeDAO;
import dal.InsurancePackageDAO;
import dal.InsurancePersonDAO;
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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.BeneficiaryPerson;
import model.DetailFee;
import model.InsuranceContract;
import model.InsurancePackage;
import model.InsurancePerson;
import model.Staff;

/**
 *
 * @author maian
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

@WebServlet(name = "CreateContractServlet", urlPatterns = {"/createcontract"})
public class CreateContractServlet extends HttpServlet {

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
        Staff staff = (Staff) session.getAttribute("authcode");
        String action = request.getParameter("action");
        if (staff == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (action == null) {
            request.getRequestDispatcher("CreateInsurancePerson.jsp").forward(request, response);
        } else {
            InsurancePackageDAO insuPackageDAO = new InsurancePackageDAO();
            List<InsurancePackage> insuPackage = insuPackageDAO.getAllInsurancePackage();
            request.setAttribute("insuPackage", insuPackage);
            request.getRequestDispatcher("CreateContract.jsp").forward(request, response);
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
        InsurancePackageDAO insuPackageDAO = new InsurancePackageDAO();
        List<InsurancePackage> insuPackage = insuPackageDAO.getAllInsurancePackage();
        request.setAttribute("insuPackage", insuPackage);

        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("authcode");
        InsurancePersonDAO insuDAO = new InsurancePersonDAO();
        BeneficiaryPersonDAO beneDAO = new BeneficiaryPersonDAO();
        CustomerDAO cusDAO = new CustomerDAO();
        ContractDAO contractDAO = new ContractDAO();
        try {
            String contractID = request.getParameter("contractID");
            String customerID = request.getParameter("customerID");
            int packageID = Integer.parseInt(request.getParameter("packageID"));
            long sumAssured = formatCurrency(request.getParameter("sumAssured"));
            String status = request.getParameter("status");
            String effectiveDate = request.getParameter("effectiveDate");
            int insuranceTime = Integer.parseInt(request.getParameter("insuranceTime"));
            String maturityDate = calculateMaturityDate(effectiveDate, insuranceTime);
            String expiryDate = calculateExpiryDate(effectiveDate, insuranceTime);
            String premiumMode = request.getParameter("premiumMode");
            Part part = request.getPart("contract_pdf");
            String fileName = part.getSubmittedFileName();
            part.write("D:\\pdfs\\" + fileName);

            if (contractDAO.getContractByID(contractID) != null) {
                request.setAttribute("errorContractIDexist", "ID hợp đồng đã tồn tại!");
                request.getRequestDispatcher("CreateContract.jsp").forward(request, response);
            } else if (!checkContractID(contractID)) {
                request.setAttribute("errorContractIDformat", "ID hợp đồng phải có định dạng 3 chữ viết hoa và 3 số!");
                request.getRequestDispatcher("CreateContract.jsp").forward(request, response);
            }
            if (cusDAO.getCustomerByID(customerID) == null) {
                request.setAttribute("errorCustomerID", "ID khách hàng không tồn tại!");
                request.getRequestDispatcher("CreateContract.jsp").forward(request, response);
            }
            if (checkLimitDate(effectiveDate)) {
                request.setAttribute("errorEffectiveDate", "Ngày hiệu lực không hợp lệ!");
                request.getRequestDispatcher("CreateContract.jsp").forward(request, response);
            }

            InsurancePerson insuPerson = (InsurancePerson) session.getAttribute("insuPerson");
            insuDAO.createInsurancePerson(insuPerson);
            int insuranID = insuDAO.getNewInsurancePerson().getInsuranID();

            BeneficiaryPerson benePerson = (BeneficiaryPerson) session.getAttribute("benePerson");
            beneDAO.createBeneficiaryPerson(benePerson);
            int beneID = beneDAO.getNewBeneficiaryPerson().getBeneID();

            String staffID = staff.getStaffID();
            InsuranceContract contract = new InsuranceContract(contractID, customerID, packageID, insuranID, beneID, staffID, status, sumAssured, effectiveDate, maturityDate, expiryDate, insuranceTime, premiumMode, fileName);
            contractDAO.createContract(contract);

            DetailFeeDAO detailFeeDAO = new DetailFeeDAO();
            String premiumDueDate = calculatePaymentDueDate(effectiveDate, premiumMode);
            long premiumPayment = calculatePremiumPayment(sumAssured, premiumMode);
            DetailFee detailFee = new DetailFee(contractID, premiumDueDate, premiumPayment, "Chưa thanh toán");
            detailFeeDAO.insertDetailFee(detailFee);

            request.setAttribute("message", "success");
            request.getRequestDispatcher("staffHomepage").forward(request, response);
        } catch (NumberFormatException e) {
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

    private boolean checkContractID(String contractID) {
        String regex = "^[A-Z]{3}\\d{3}$";
        if (contractID.matches(regex)) {
            return true;
        }
        return false;
    }

    private boolean checkLimitDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Calendar now = Calendar.getInstance();
        try {
            Date date = dateFormat.parse(dateStr);
            if (date.after(now.getTime())) {
                return true;
            }
        } catch (ParseException e) {
        }
        return false;
    }

    private long formatCurrency(String sumAssured) {
        String numericValue = sumAssured.replaceAll("[^0-9]", "");
        try {
            return Long.parseLong(numericValue);
        } catch (NumberFormatException e) {
        }
        return -1;
    }

    private String calculateMaturityDate(String effectiveDateStr, int insuranceTime) {
        LocalDate effectiveDate = LocalDate.parse(effectiveDateStr);
        LocalDate maturityDate = effectiveDate.plus(Period.ofYears(insuranceTime));
        return maturityDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String calculateExpiryDate(String effectiveDateStr, int insuranceTime) {
        LocalDate effectiveDate = LocalDate.parse(effectiveDateStr);
        LocalDate expiryDate = effectiveDate.plus(Period.ofYears(insuranceTime));
        return expiryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String calculatePaymentDueDate(String effectiveDateStr, String premiumMode) {
        String paymentDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar effectiveDate = Calendar.getInstance();
            effectiveDate.setTime(sdf.parse(effectiveDateStr));
            switch (premiumMode) {
                case "Năm":
                    effectiveDate.add(Calendar.YEAR, 1);
                    break;
                case "Nửa năm":
                    effectiveDate.add(Calendar.MONTH, 6);
                    break;
                case "Quý":
                    effectiveDate.add(Calendar.MONTH, 3);
                    break;
                case "Tháng":
                    effectiveDate.add(Calendar.MONTH, 1);
                    break;
            }
            paymentDate = sdf.format(effectiveDate.getTime());
        } catch (ParseException e) {
        }
        return paymentDate;
    }

    private long calculatePremiumPayment(long sumAssured, String premiumMode) {
        switch (premiumMode) {
            case "Năm":
                return (long) ((0.0011 * sumAssured + 430) * 12);
            case "Nửa năm":
                return (long) ((0.0011 * sumAssured + 430) * 6);
            case "Quý":
                return (long) ((0.0011 * sumAssured + 430) * 4);
            case "Tháng":
                return (long) (0.0011 * sumAssured + 430);
        }
        return 0;
    }
}
