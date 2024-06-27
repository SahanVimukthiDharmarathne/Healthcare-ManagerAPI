/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */
public class Doctor extends Person{
    
    //Initializing the private attributes
    private String docSpecialization;
    private String docContactDetails;
    
    //Making default constructor
    public Doctor(){
        super(0, " ", " ", " ");
        this.docSpecialization = " ";
        this.docContactDetails = " ";
    }
    
    //Making the constructor
    public Doctor(int id, String personName, String personContactInfo, String personAddress,String docSpecialization, String docContactDetails){
        super(id, personName, personContactInfo, personAddress);
        this.docSpecialization = docSpecialization;
        this.docContactDetails = docContactDetails;
    }
    
    //Implementing all the Getters and Setters

    public String getDocSpecialization() {
        return docSpecialization;
    }

    public void setDocSpecialization(String docSpecialization) {
        this.docSpecialization = docSpecialization;
    }

    public String getDocContactDetails() {
        return docContactDetails;
    }

    public void setDocContactDetails(String docContactDetails) {
        this.docContactDetails = docContactDetails;
    }
    
}
