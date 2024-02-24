/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.Date;

/**
 *
 * @author Asus
 */
public class EventDetail {
    String eventID;
    String address;
    String hospitalName;
    String eventDate;
    String toDate;
    String fromDate;
    String injuryType;
    String diagnosis;

    public EventDetail() {
    }

    public EventDetail(String eventID, String address, String hospitalName, String eventDate, String toDate, String fromDate, String injuryType, String diagnosis) {
        this.eventID = eventID;
        this.address = address;
        this.hospitalName = hospitalName;
        this.eventDate = eventDate;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.injuryType = injuryType;
        this.diagnosis = diagnosis;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    
    
    
}
