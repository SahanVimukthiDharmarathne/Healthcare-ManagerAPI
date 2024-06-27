/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

import com.company.dao.PatientDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Patient;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sahan Dharmarathna
 */

@Path("/patients")
public class PatientResource {
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientResource.class);
    
    //Making the object from PatientDAO class
    private PatientDAO patientDAO = new PatientDAO();
    
    //Defining the @GET http method for getting all patients
    @GET
    @Path("/allPatients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
    
    //Defining the @GET http method for getting a patient by ID
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("patientId") int patientId) {
        
        Patient patientObj = patientDAO.getPatientById(patientId);
        if(patientObj != null){
            LOGGER.info("Getting patient by Id: {}", patientId);
            return patientObj;
        }else{
            throw new ResourceNotFoundException("Patient with this Id: " + patientId + " --> not found.");
        } 
    }
    
    //Defining the @POST http method for create a patient by ID
    @POST
    @Path("/create/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPatient(Patient patient) {
        patientDAO.createPatient(patient);
    }
    
    //Defining the @PUT http method for updating a patient by existing ID
    @PUT
    @Path("/update/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePetient(@PathParam("patientId") int patientId, Patient updatedPatient) {
        
        LOGGER.info("Updating patient by ID: {}", patientId);
        Patient existingPatient = patientDAO.getPatientById(patientId);

        if (existingPatient != null) {
            updatedPatient.setId(patientId);
            patientDAO.updatePetient(updatedPatient);
        }else{
            throw new ResourceNotFoundException("A patient with Id: " + patientId + " --> not found to update.");
        }
    }
    
    //Defining the @DELETE http method for remove a patient by existing ID
    @DELETE
    @Path("/delete/{patientId}")
    public void deletePatient(@PathParam("patientId") int patientId) {
        patientDAO.deletePatient(patientId);
    }
}
