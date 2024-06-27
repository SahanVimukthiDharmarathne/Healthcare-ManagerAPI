/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

import com.company.dao.AppointmentDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Appointment;
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

@Path("/appointments")
public class AppointmentResource {
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentResource.class);
    
    //Making the object from AppointmentDAO class
    private AppointmentDAO appointDAO = new AppointmentDAO();
    
    //Defining the @GET http method for getting all appointments
    @GET
    @Path("/allAppointments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointDAO.getAllAppointments();
    }

    //Defining the @GET http method for getting an appointment by ID
    @GET
    @Path("/{appointId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointId") int appointId) {
        
        Appointment appointObj = appointDAO.getAppointmentById(appointId);
        if(appointObj != null){
            LOGGER.info("Getting appointment by Id: {}", appointId);
            return appointObj;
        }else{
            throw new ResourceNotFoundException("Appointment with this Id: " + appointId + " --> not found.");
        }
         
    }

    //Defining the @POST http method for create an appointment by ID
    @POST
    @Path("/create/{appointId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAppointment(Appointment appointment) {
        appointDAO.createAppointment(appointment);
    }
    
    //Defining the @PUT http method for updating an appointment by existing ID
    @PUT
    @Path("/update/{appointId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAppointment(@PathParam("appointId") int appointId, Appointment updatedAppoint) {
        LOGGER.info("Updating appointment by ID: {}", appointId);
        Appointment existingAppoint = appointDAO.getAppointmentById(appointId);

        if (existingAppoint != null) {
            updatedAppoint.setAppointmentId(appointId);
            appointDAO.updateAppointment(updatedAppoint);
        }else{
            throw new ResourceNotFoundException("An appointment with Id: " + appointId + " --> not found to update.");
        }
    }

    //Defining the @DELETE http method for remove an appointment by existing ID
    @DELETE
    @Path("/delete/{appointId}")
    public void deleteAppointment(@PathParam("appointId") int appointId) {
        appointDAO.deleteAppointment(appointId);
    }
    
}

