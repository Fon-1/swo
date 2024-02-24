/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maian
 */
public class DetailFee {

    private int detailFeeID;
    private String contractID;
    private String paymentDueDate;
    private long premiumPayment;
    private String status;

    public DetailFee() {
    }

    public DetailFee(int detailFeeID, String contractID, String paymentDueDate, long premiumPayment, String status) {
        this.detailFeeID = detailFeeID;
        this.contractID = contractID;
        this.paymentDueDate = paymentDueDate;
        this.premiumPayment = premiumPayment;
        this.status = status;
    }

    public DetailFee(String contractID, String paymentDueDate, long premiumPayment, String status) {
        this.contractID = contractID;
        this.paymentDueDate = paymentDueDate;
        this.premiumPayment = premiumPayment;
        this.status = status;
    }

    public int getDetailFeeID() {
        return detailFeeID;
    }

    public void setDetailFeeID(int detailFeeID) {
        this.detailFeeID = detailFeeID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public long getPremiumPayment() {
        return premiumPayment;
    }

    public void setPremiumPayment(long premiumPayment) {
        this.premiumPayment = premiumPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
