/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.Appointment;
import com.company.model.Doctor;
import com.company.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Sahan Dharmarathna
 */
public class AppointmentDAO {
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(AppointmentDAO.class.getName());
    //Initializing the arraylist
    private static List<Appointment> ListOfappointments = new ArrayList<>();
    
    //Defining the details static block
    static{
        
        Patient patient01 = new Patient(1, "Kamal", "0716521830", "258/A Dope,Bentota", "Having Sugar", "Normal");
        Patient patient02 = new Patient(2, "Piyal", "0718989890", "238/B Colombo,Fort", "Having Pressure", "Good");
        Patient patient03 = new Patient(3, "Namal", "0775505500", "248/B Galle,Fort", "Having Fever", "Low");
    
        Doctor doctor01 = new Doctor(1, "Dr.Sahan", "0716521830", "20001/A", "Cardiologist", "DocTel: 000001");
        Doctor doctor02 = new Doctor(2, "Dr.Upeksha", "0714545454", "20002/B", "Neuralogist", "DocTel: 000002");
        Doctor doctor03 = new Doctor(3, "Dr.Dulari", "0715555555", "20003/C", "Electrophysiologist", "DocTel: 000003");
        
        ListOfappointments.add(new Appointment(1, "05/05", "10.00", patient01, doctor01));
        ListOfappointments.add(new Appointment(2, "06/06", "11.00", patient02, doctor02));
        ListOfappointments.add(new Appointment(3, "07/07", "12.00", patient03, doctor03));
 
    }
    
    
    //Create Operation
    public void createAppointment(Appointment appointment){
        ListOfappointments.add(appointment);
    }
    
    //Read Operation for all appointments.
    public List<Appointment> getAllAppointments(){
        return ListOfappointments;
    } 
    
    //Read Operation for each appiontment.
    public Appointment getAppointmentById(int appointId){
        for(Appointment appointment : ListOfappointments){
            if(appointment.getAppointmentId() == appointId){
                return appointment;
            }
        }
        return null;
    }
    
    //Update Operation
    public void updateAppointment(Appointment updatedAppoint){
        for(int i = 0; i < ListOfappointments.size(); i++){
            Appointment appointment = ListOfappointments.get(i);
            if(appointment.getAppointmentId() == updatedAppoint.getAppointmentId()){
                ListOfappointments.set(i, updatedAppoint);
                System.out.println("Appointment is updated: " + updatedAppoint);
                LOGGER.info("Appointment is updated.");
                return;
            }
        }
        
        LOGGER.severe("There is no appointment with this id to update: " + updatedAppoint.getAppointmentId());
        throw new RuntimeException("There is no appointment with this id to update: " + updatedAppoint.getAppointmentId());
    }
    
    //Delete Operations
    public void deleteAppointment(int appointId){
        ListOfappointments.removeIf(appointment -> appointment.getAppointmentId() == appointId);
        LOGGER.info("Appointment is deleted.");
    }
    
}
