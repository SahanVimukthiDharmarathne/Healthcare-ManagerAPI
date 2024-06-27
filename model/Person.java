/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */
public class Person {
    
    //Initializing the private attributes
    private int id;
    private String personName;
    private String personContactInfo;
    private String personAddress;
    
    //Making default constructor
    public Person(){}
    
    //Making the constructor
    public Person(int id, String personName, String personContactInfo, String personAddress){
        this.id = id;
        this.personName = personName;
        this.personContactInfo = personContactInfo;
        this.personAddress = personAddress;
    }
    
    //Implementing all the Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonContactInfo() {
        return personContactInfo;
    }

    public void setPersonContactInfo(String personContactInfo) {
        this.personContactInfo = personContactInfo;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
    
    
    
}
