/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class RequestChangeInfo {

    private int requestID;
    private String customerID, fullName, CCCD_imgFront, CCCD_imgBack, CCCD;
    private int gender;
    private String dob, nationality, issuedDate, expiredDate, issuedPlace,
            marital_img, education_img, maritalStatus, education, job, address,
            phoneNumber, email, timeCreate, status;

    public RequestChangeInfo() {
    }

    public RequestChangeInfo(int requestID, String customerID, String fullName,
            String CCCD_imgFront, String CCCD_imgBack, String CCCD, int gender,
            String dob, String nationality, String issuedDate, String expiredDate,
            String issuedPlace, String marital_img, String maritalStatus,
            String education_img, String education, String job, String address,
            String phoneNumber, String email, String timeCreate, String status) {
        this.requestID = requestID;
        this.customerID = customerID;
        this.fullName = fullName;
        this.CCCD_imgFront = CCCD_imgFront;
        this.CCCD_imgBack = CCCD_imgBack;
        this.CCCD = CCCD;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.issuedPlace = issuedPlace;
        this.marital_img = marital_img;
        this.maritalStatus = maritalStatus;
        this.education_img = education_img;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.timeCreate = timeCreate;
        this.status = status;
    }

    public RequestChangeInfo(String customerID, String fullName, String CCCD_imgFront,
            String CCCD_imgBack, String CCCD, int gender, String dob, String nationality,
            String issuedDate, String expiredDate, String issuedPlace, String marital_img,
            String maritalStatus, String education_img, String education, String job,
            String address, String phoneNumber, String email, String timeCreate, String status) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.CCCD_imgFront = CCCD_imgFront;
        this.CCCD_imgBack = CCCD_imgBack;
        this.CCCD = CCCD;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.issuedPlace = issuedPlace;
        this.marital_img = marital_img;
        this.maritalStatus = maritalStatus;
        this.education_img = education_img;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.timeCreate = timeCreate;
        this.status = status;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCCCD_imgFront() {
        return CCCD_imgFront;
    }

    public void setCCCD_imgFront(String CCCD_imgFront) {
        this.CCCD_imgFront = CCCD_imgFront;
    }

    public String getCCCD_imgBack() {
        return CCCD_imgBack;
    }

    public void setCCCD_imgBack(String CCCD_imgBack) {
        this.CCCD_imgBack = CCCD_imgBack;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getIssuedPlace() {
        return issuedPlace;
    }

    public void setIssuedPlace(String issuedPlace) {
        this.issuedPlace = issuedPlace;
    }

    public String getMarital_img() {
        return marital_img;
    }

    public void setMarital_img(String marital_img) {
        this.marital_img = marital_img;
    }

    public String getEducation_img() {
        return education_img;
    }

    public void setEducation_img(String education_img) {
        this.education_img = education_img;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
