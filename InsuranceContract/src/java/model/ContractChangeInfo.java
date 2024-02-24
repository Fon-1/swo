/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maian
 */
public class ContractChangeInfo {
    
    private String contractID, customerID;
    private int packageID;
    private int insuranID, beneID;
    private String staffID;
    private String Status;
    private long sumAssured;
    private String effectiveDate, maturityDate, expiryDate;
    private int insuranceTime;
    private String premiumMode;
    private String contract_pdf;

    public ContractChangeInfo() {
    }

    public ContractChangeInfo(String contractID, String customerID, int packageID, int insuranID, int beneID, String staffID, String Status, long sumAssured, String effectiveDate, String maturityDate, String expiryDate, int insuranceTime, String premiumMode, String contract_pdf) {
        this.contractID = contractID;
        this.customerID = customerID;
        this.packageID = packageID;
        this.insuranID = insuranID;
        this.beneID = beneID;
        this.staffID = staffID;
        this.Status = Status;
        this.sumAssured = sumAssured;
        this.effectiveDate = effectiveDate;
        this.maturityDate = maturityDate;
        this.expiryDate = expiryDate;
        this.insuranceTime = insuranceTime;
        this.premiumMode = premiumMode;
        this.contract_pdf = contract_pdf;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getInsuranID() {
        return insuranID;
    }

    public void setInsuranID(int insuranID) {
        this.insuranID = insuranID;
    }

    public int getBeneID() {
        return beneID;
    }

    public void setBeneID(int beneID) {
        this.beneID = beneID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public long getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(long sumAssured) {
        this.sumAssured = sumAssured;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getInsuranceTime() {
        return insuranceTime;
    }

    public void setInsuranceTime(int insuranceTime) {
        this.insuranceTime = insuranceTime;
    }

    public String getPremiumMode() {
        return premiumMode;
    }

    public void setPremiumMode(String premiumMode) {
        this.premiumMode = premiumMode;
    }

    public String getContract_pdf() {
        return contract_pdf;
    }

    public void setContract_pdf(String contract_pdf) {
        this.contract_pdf = contract_pdf;
    }

}
