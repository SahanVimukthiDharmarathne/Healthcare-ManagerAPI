/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.MedicalRecord;
import com.company.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Sahan Dharmarathna
 */
public class MedicalRecordDAO {
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(MedicalRecordDAO.class.getName());

    //Initializing the arraylist
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    //Defining the details static block
    static{
        Patient patient01 = new Patient(1, "Kamal", "0716521830", "258/A Dope,Bentota", "Having Sugar", "Normal");
        Patient patient02 = new Patient(2, "Piyal", "0718989890", "238/B Colombo,Fort", "Having Pressure", "Good");
        Patient patient03 = new Patient(3, "Namal", "0775505500", "248/B Galle,Fort", "Having Fever", "Low");
    
        medicalRecords.add(new MedicalRecord(1, "Having Sugar", "Getting sugar pills", patient01));
        medicalRecords.add(new MedicalRecord(2, "Having Pressure", "Getting pressure pills", patient02));
        medicalRecords.add(new MedicalRecord(3, "Having Fever", "Getting fever pills", patient03));
    
    }
    
    
    //Create Operation
    public void createMedicalRecord(MedicalRecord medRec){
        medicalRecords.add(medRec);
    }
    
    //Read Operation for all medical records.
    public List<MedicalRecord> getAllMedicalRecords(){
        return medicalRecords;
    }
    
    //Read Operation for each medical record.
    public MedicalRecord getMedicalRecordById(int medRecordId){
        for(MedicalRecord medRec : medicalRecords){
            if(medRec.getMedRecId() == medRecordId){
               return medRec;
            }
        }
        return null;
    }
    
    //Update Operation
    public void updateMedicalRecord(MedicalRecord updatedMedRec){
        for(int i = 0; i < medicalRecords.size(); i++){
            MedicalRecord medRec = medicalRecords.get(i);
            if(medRec.getMedRecId() == updatedMedRec.getMedRecId()){
                medicalRecords.set(i, updatedMedRec);
                System.out.println("Medical record updated: " + updatedMedRec);
                LOGGER.info("MedicalRecord is updated.");
                return;
            }
        }
        
        LOGGER.severe("There is no medical record with this id to update: " + updatedMedRec.getMedRecId());
        throw new RuntimeException("There is no medical record with this id to update: " + updatedMedRec.getMedRecId());
    }
    
    public void deleteMedicalRecord(int medRecordId){
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getMedRecId() == medRecordId);
        LOGGER.info("Medical record is deleted.");
    }
    
}
