/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */
public class Patient extends Person{
    
    //Initializing the private attributes
    private String patientMedHistory;
    private String patientHealthStatus;
    
    //Making default constructor
    public Patient(){
        super(0, " ", " ", " ");
        this.patientMedHistory = " ";
        this.patientHealthStatus = " ";
    }
    
    //Making the constructor
    public Patient(int id, String personName, String personContactInfo, String personAddress, String patientMedHistory, String patientHealthStatus){
        super(id, personName, personContactInfo, personAddress);
        this.patientMedHistory = patientMedHistory;
        this.patientHealthStatus = patientHealthStatus;
    }
    
    //Implementing all the Getters and Setters

    public String getPatientMedHistory() {
        return patientMedHistory;
    }

    public void setPatientMedHistory(String patientMedHistory) {
        this.patientMedHistory = patientMedHistory;
    }

    public String getPatientHealthStatus() {
        return patientHealthStatus;
    }

    public void setPatientHealthStatus(String patientHealthStatus) {
        this.patientHealthStatus = patientHealthStatus;
    }
    
}
