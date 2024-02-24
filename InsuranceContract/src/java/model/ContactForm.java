/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author DUong
 */
public class ContactForm {
    int guestID;
    String fullName;
    String email;
    String phoneNumber;
    String supportContent;
    Timestamp submissionTime;
    String status;
    Timestamp responseTime;

    public ContactForm() {
    }

    public ContactForm(int guestID, String fullName, String email, String phoneNumber, String supportContent, Timestamp submissionTime, String status, Timestamp responseTime) {
        this.guestID = guestID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.supportContent = supportContent;
        this.submissionTime = submissionTime;
        this.status = status;
        this.responseTime = responseTime;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSupportContent() {
        return supportContent;
    }

    public void setSupportContent(String supportContent) {
        this.supportContent = supportContent;
    }

    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Timestamp responseTime) {
        this.responseTime = responseTime;
    }

    
}
