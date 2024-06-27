/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

import com.company.dao.DoctorDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Doctor;
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

@Path("/doctors")
public class DoctorResource {
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorResource.class);
    
    //Making the object from DoctorDAO class
    private DoctorDAO doctorDAO = new DoctorDAO();
    
    //Defining the @GET http method for getting all doctors
    @GET
    @Path("/allDoctors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    //Defining the @GET http method for getting a doctor by ID
    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") int doctorId) {
        
        Doctor doctorObj = doctorDAO.getDoctorById(doctorId);
        if(doctorObj != null){
            LOGGER.info("Getting doctor by Id: {}", doctorId);
            return doctorObj;
        }else{
            throw new ResourceNotFoundException("Doctor with this Id: " + doctorId + " --> not found.");
        }
    }
    
    //Defining the @POST http method for create a doctor by ID
    @POST
    @Path("/create/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDoctor(Doctor doctor) {
        doctorDAO.createDoctor(doctor);
    }

    //Defining the @PUT http method for updating a doctor by existing ID
    @PUT
    @Path("/update/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        
        LOGGER.info("Updating doctor by ID: {}", doctorId);
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);

        if (existingDoctor != null) {
            updatedDoctor.setId(doctorId);
            doctorDAO.updateDoctor(updatedDoctor);
        }else{
            throw new ResourceNotFoundException("A doctor with Id: " + doctorId + " --> not found to update.");
        }
    }
    
    //Defining the @DELETE http method for remove a doctor by existing ID
    @DELETE
    @Path("/delete/{doctorId}")
    public void deleteDoctor(@PathParam("doctorId") int doctorId) {
        doctorDAO.deleteDoctor(doctorId);
    }
    
}
