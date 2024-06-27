/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

/**
 *
 * @author Sahan Dharmarathna
 */
public class Billing {
    
    //Initializing the private attributes
    private int billingId;
    private String invoice;
    private double payment;
    private String ifPaid;
    private Patient patient;
    
    //Making default constructor
    public Billing(){}

    //Making the constructor
    public Billing(int billingId, String invoice, double payment, String ifPaid, Patient patient) {
        this.billingId = billingId;
        this.invoice = invoice;
        this.payment = payment;
        this.ifPaid = ifPaid;
        this.patient = patient;
    }
    
    //Implementing all the Getters and Setters

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getIfPaid() {
        return ifPaid;
    }

    public void setIfPaid(String ifPaid) {
        this.ifPaid = ifPaid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
