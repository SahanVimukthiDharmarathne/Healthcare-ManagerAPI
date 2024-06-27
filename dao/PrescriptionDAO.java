/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.Patient;
import com.company.model.Prescription;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Sahan Dharmarathna
 */
public class PrescriptionDAO {
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(PrescriptionDAO.class.getName());
    //Initializing the arraylist
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    //Defining the details static block
    static{
        Patient patient01 = new Patient(1, "Kamal", "0716521830", "258/A Dope,Bentota", "Having Sugar", "Normal");
        Patient patient02 = new Patient(2, "Piyal", "0718989890", "238/B Colombo,Fort", "Having Pressure", "Good");
        Patient patient03 = new Patient(3, "Namal", "0775505500", "248/B Galle,Fort", "Having Fever", "Low");
    
        
        prescriptions.add(new Prescription(1, "100mg", "After meals three times a day", 5, patient01));
        prescriptions.add(new Prescription(2, "250mg", "Before meals two times a day", 3, patient02));
        prescriptions.add(new Prescription(3, "550mg", "Before meals four times a day", 10, patient03));
    
    }
    
    
    //Create Operation
    public void createPrescription(Prescription prescript){
        prescriptions.add(prescript);
    }
    
    //Read Operation for all prescriptions.
    public List<Prescription> getAllPrescriptions(){
        return prescriptions;
    }
    
    //Read Operation for each prescription.
    public Prescription getPrescriptionById(int prescriptId){
        for(Prescription prescript : prescriptions){
            if(prescript.getPrescriptId() == prescriptId){
                return prescript;
            }
        }
        return null;
    }
    
    //Update Operation
    public void updatePrescription(Prescription updatedPrescript){
        for(int i = 0; i < prescriptions.size(); i++){
            Prescription prescript = prescriptions.get(i);
            if(prescript.getPrescriptId() == updatedPrescript.getPrescriptId()){
                prescriptions.set(i, updatedPrescript);
                System.out.println("Prescripton is updated: " + updatedPrescript);
                LOGGER.info("Prescription is updated.");
                return;
            }
        }
        LOGGER.severe("There is no prescription with this id to update: " + updatedPrescript.getPrescriptId());
        throw new RuntimeException("There is no prescription with this id to update: " + updatedPrescript.getPrescriptId());
    }
    
    //Delete Operation
    public void deletePrescription(int prescriptId){
        prescriptions.removeIf(prescription -> prescription.getPrescriptId() == prescriptId);
        LOGGER.info("Prescription is deleted.");
    }

}
