/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Sahan Dharmarathna
 */
public class PatientDAO extends PersonDAO{
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());

    //Initializing the arraylist
    private static List<Patient> patients = new ArrayList<>();
    
    //Defining the details static block
    static{
        patients.add(new Patient(1, "Kamal", "0716521830", "258/A Dope,Bentota", "Having Sugar", "Normal"));
        patients.add(new Patient(2, "Piyal", "0718989890", "238/A Colombo,Fort", "Having Pressure", "Good"));
        patients.add(new Patient(3, "Namal", "0775505500", "248/A Galle,Fort", "Having Fever", "Low"));
    
    }
    
    
    //Create Operation
    public void createPatient(Patient patient){
        patients.add(patient);
        super.createPerson(patient);
    }
    
    //Read Operation for all patients.
    public List<Patient> getAllPatients(){
        //return new ArrayList<>(patients);
        return patients;
    }
    
    
    //Read Operation for each patients.
    public Patient getPatientById(int id){
        for(Patient patient : patients){
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }
    
    //Update Operation
    public void updatePetient(Patient updatedPatient){
        for(int i = 0; i < patients.size(); i++){
            Patient patient =patients.get(i);
            if(patient.getId() == updatedPatient.getId()){
                patients.set(i, updatedPatient);
                System.out.println("Person is updated: " + updatedPatient);
                LOGGER.info("Patient is updated.");
                return;
            }
        }
        LOGGER.severe("There is no patient with this id to update: " + updatedPatient.getId());
        throw new RuntimeException("There is no patient with this id to update: " + updatedPatient.getId());
    }
    
    //Delete Operation
    public void deletePatient(int id){
        patients.removeIf(patient -> patient.getId() == id);
        LOGGER.info("Patient is deleted.");
    }

}
