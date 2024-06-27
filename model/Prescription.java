/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */
public class Prescription {
    
    //Initializing the private attributes
    private int prescriptId;
    private String dosage;
    private String medInfo;
    private int durationInDays;
    private Patient patient;
    
    //Making default constructor
    public Prescription(){}
    
    //Making the constructor
    public Prescription(int prescriptId, String dosage, String medInfo, int durationInDays, Patient patient){
        this.prescriptId = prescriptId;
        this.dosage = dosage;
        this.medInfo = medInfo;
        this.durationInDays = durationInDays;
        this.patient = patient;
    }

    //Implementing all the Getters and Setters
    public int getPrescriptId() {
        return prescriptId;
    }

    public void setPrescriptId(int prescriptId) {
        this.prescriptId = prescriptId;
    }
    
    
    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedInfo() {
        return medInfo;
    }

    public void setMedInfo(String medInfo) {
        this.medInfo = medInfo;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}
