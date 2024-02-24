/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author DUong
 */
public class ContractDetails {
    private String contractID;
    private String packageName;
    private String insurancePersonFullName;
    private String beneficiaryPersonFullName;
    private String customerFullName;
    private String staffFullName;
    private String staffPhoneNumber;
    private long sumAssured;
    private Date effectiveDate;
    private Date maturityDate;
    private Date expiryDate;
    private String premiumMode;

    public ContractDetails() {
    }

    public ContractDetails(String contractID, String packageName, String insurancePersonFullName, String beneficiaryPersonFullName, String customerFullName, String staffFullName, String staffPhoneNumber, long sumAssured, Date effectiveDate, Date maturityDate, Date expiryDate, String premiumMode) {
        this.contractID = contractID;
        this.packageName = packageName;
        this.insurancePersonFullName = insurancePersonFullName;
        this.beneficiaryPersonFullName = beneficiaryPersonFullName;
        this.customerFullName = customerFullName;
        this.staffFullName = staffFullName;
        this.staffPhoneNumber = staffPhoneNumber;
        this.sumAssured = sumAssured;
        this.effectiveDate = effectiveDate;
        this.maturityDate = maturityDate;
        this.expiryDate = expiryDate;
        this.premiumMode = premiumMode;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getInsurancePersonFullName() {
        return insurancePersonFullName;
    }

    public void setInsurancePersonFullName(String insurancePersonFullName) {
        this.insurancePersonFullName = insurancePersonFullName;
    }

    public String getBeneficiaryPersonFullName() {
        return beneficiaryPersonFullName;
    }

    public void setBeneficiaryPersonFullName(String beneficiaryPersonFullName) {
        this.beneficiaryPersonFullName = beneficiaryPersonFullName;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getStaffFullName() {
        return staffFullName;
    }

    public void setStaffFullName(String staffFullName) {
        this.staffFullName = staffFullName;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public long getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(long sumAssured) {
        this.sumAssured = sumAssured;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPremiumMode() {
        return premiumMode;
    }

    public void setPremiumMode(String premiumMode) {
        this.premiumMode = premiumMode;
    }
}