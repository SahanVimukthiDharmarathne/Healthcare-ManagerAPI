/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Sahan Dharmarathna
 */
public class DoctorDAO extends PersonDAO{
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(DoctorDAO.class.getName());

    //Initializing the arraylist
    private static List<Doctor> doctors = new ArrayList<>();
    
    //Defining the details static block
    static{
        doctors.add(new Doctor(1, "Dr.Sahan", "Mobile: 0716521830", "Dope,Bentota", "Cardiologist", "DocTel: 000001"));
        doctors.add(new Doctor(2, "Dr.Upeksha", "Mobile: 0714545454", "Dope,Gallagewatta", "Neurologist", "DocTel: 000002"));
        doctors.add(new Doctor(3, "Dr.Dulari", "Mobile: 0715555555", "Dope,Arachchimulla", "Electrophysiologist", "DocTel: 000003")); 
    }
    
    //Create Operation
    public void createDoctor(Doctor doctor){
        doctors.add(doctor);
        super.createPerson(doctor);
    }
    
    //Read Operation for all doctors.
    public List<Doctor> getAllDoctors(){
        return doctors;
    }
    
    //Read Operation for each doctor.
    public Doctor getDoctorById(int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() == id){
                return doctor;
            }
        }
        return null;
    }
    
    //Update Operation
    public void updateDoctor(Doctor updatedDoctor){
        for(int i = 0; i < doctors.size(); i++){
            Doctor doctor = doctors.get(i);
            if(doctor.getId() == updatedDoctor.getId()){
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor is updated: " + updatedDoctor);
                LOGGER.info("Doctor is updated.");
                return;
            }
        }
        
        LOGGER.severe("There is no doctor with this id to update: " + updatedDoctor.getId());
        throw new RuntimeException("There is no doctor with this id to update: " + updatedDoctor.getId());
    }
    
    public void deleteDoctor(int id){
        doctors.removeIf(doctor -> doctor.getId() == id);
        LOGGER.info("Doctor is deleted.");
    }
    
}
