/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */

public class MedicalRecord {
    
    //Initializing the private attributes
    private int medRecId;
    private String diagnoses;
    private String treatments;
    private Patient patient;
    
    //Making default constructor
    public MedicalRecord(){}
    
    //Making the constructor
    public MedicalRecord(int medRecId, String diagnoses, String treatments, Patient patient){
        this.medRecId = medRecId;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
        this.patient = patient;
    }
    
    //Implementing all the Getters and Setters

    public int getMedRecId() {
        return medRecId;
    }

    public void setMedRecId(int medRecId) {
        this.medRecId = medRecId;
    }
    
    
    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}
