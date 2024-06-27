/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.Billing;
import com.company.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Sahan Dharmarathna
 */
public class BillingDAO {
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(BillingDAO.class.getName());
    //Initializing the arraylist
    private static List<Billing> bills = new ArrayList<>();
    
    //Defining the details static block
    static{
        
        Patient patient01 = new Patient(1, "Kamal", "0716521830", "258/A Dope,Bentota", "Having Sugar", "Normal");
        Patient patient02 = new Patient(2, "Piyal", "0718989890", "238/B Colombo,Fort", "Having Pressure", "Good");
        Patient patient03 = new Patient(3, "Namal", "0775505500", "248/B Galle,Fort", "Having Fever", "Low");
    
        bills.add(new Billing(1, "Invoice 01", 5000, "Paid", patient01));
        bills.add(new Billing(2, "Invoice 02", 2500, "Not Paid", patient02));
        bills.add(new Billing(3, "Invoice 03", 7500, "Not Paid", patient03));
    
    }
    
    //Create Operation
    public void createBill(Billing bill){
        bills.add(bill);
    }
    
    
    //Read Operation for all prescriptions.
    public List<Billing> getAllBills(){
        return bills;
    }
    
    
    //Read Operation for each prescriptions.
    public Billing getBillById(int billId){
        for(Billing bill : bills){
            if(bill.getBillingId() == billId){
                return bill;
            }
        }
        return null;
    }
    
    
    //Update Operation
    public void updateBill(Billing updatedBill){
        for(int i = 0; i < bills.size(); i++){
            Billing bill = bills.get(i);
            if(bill.getBillingId() == updatedBill.getBillingId()){
                bills.set(i, updatedBill);
                System.out.println("Prescripton is updated: " + updatedBill);
                LOGGER.info("Bill is updated.");
                return;
            }
        }
        
        LOGGER.severe("There is no bill with this id to update: " + updatedBill.getBillingId());
        throw new RuntimeException("There is no bill with this id to update: " + updatedBill.getBillingId());
    }
    
    
    //Delete Operation
    public void deleteBill(int billId){
        bills.removeIf(bill -> bill.getBillingId() == billId);
        LOGGER.info("Bill is deleted.");
    }
}
