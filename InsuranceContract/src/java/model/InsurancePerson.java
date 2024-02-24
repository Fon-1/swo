/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dell
 */
public class InsurancePerson {

    private int insuranID;
    private String fullName;
    private int gender;
    private String dob, cccd, nationality, maritalStatus, education, job,
            address, phoneNumber, email;

    public InsurancePerson() {
    }

    public InsurancePerson(int insuranID, String fullName, int gender, String dob, String cccd, String nationality, String maritalStatus, String education, String job, String address, String phoneNumber, String email) {
        this.insuranID = insuranID;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.cccd = cccd;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public InsurancePerson(String fullName, int gender, String dob, String cccd, String nationality, String maritalStatus, String education, String job, String address, String phoneNumber, String email) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.cccd = cccd;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.job = job;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getInsuranID() {
        return insuranID;
    }

    public void setInsuranID(int insuranID) {
        this.insuranID = insuranID;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

}
