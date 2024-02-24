/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class Customer {
  
    private String customerID;
    private String password, fullName;
    private int gender;
    private String dob, CCCD, nationality, maritalStatus, education, job,
            address, phoneNumber, email;
    private String code;
 
    public String issuedPlace ,issuedDate, expiredDate, status;
  
 
    public Customer() {
    }

    public Customer(String customerID, String password, String fullName,
                    String CCCD, int gender, String dob, String nationality,
                    String issuedDate, String expiredDate, String issuedPlace,
                    String maritalStatus, String education, String job,
                    String address, String phoneNumber, String email ) {//,String code
        this.customerID = customerID;
        this.password = password;
        this.fullName = fullName;
        this.CCCD = CCCD;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.issuedPlace = issuedPlace;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //this.code = code;
    }

    public Customer(String customerID, String password) {
        this.customerID = customerID;
        this.password = password;
    }

    public Customer(String customerID, String code, String email, String password) {
        this.customerID = customerID;
        this.code = code;
        this.email = email;
        this.password = password;
    }

    public Customer(String customerID, String password, String fullName, int gender, String dob, String CCCD, String nationality, String MaritialStatus, String education, String job, String address, String phoneNumber, String email) {
        this.customerID = customerID;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.CCCD = CCCD;
        this.nationality = nationality;
        this.maritalStatus = MaritialStatus;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

        public Customer(String customerID, String fullName,
                    String CCCD, int gender, String dob, String nationality,
                    String issuedDate, String expiredDate, String issuedPlace,
                    String maritalStatus, String education, String job,
                    String address, String phoneNumber, String email ) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.CCCD = CCCD;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.issuedPlace = issuedPlace;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //this.code = code;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIssuedPlace() {
        return issuedPlace;
    }

    public void setIssuedPlace(String issuedPlace) {
        this.issuedPlace = issuedPlace;
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
    
}
