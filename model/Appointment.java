/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */

public class Appointment {
    
    //Initializing the private attributes
    private int appointmentId;
    private String date;
    private String time;
    private Patient patient;
    private Doctor doctor;
    
    //Making default constructor
    public Appointment(){}
    
    //Making the constructor
    public Appointment(int appointmentId, String date, String time ,Patient patient, Doctor doctor){
        
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }
    
    //Implementing all the Getters and Setters

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
}
