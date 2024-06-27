/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

import com.company.dao.PrescriptionDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Prescription;
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

@Path("/prescriptions")
public class PrescriptionResource {
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionResource.class);
    
    //Making the object from PrescriptionDAO class
    private PrescriptionDAO prescriptDAO = new PrescriptionDAO();
    
    //Defining the @GET http method for getting all prescripts
    @GET
    @Path("/allPrescripts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptDAO.getAllPrescriptions();
    }

    //Defining the @GET http method for getting a prescription by ID
    @GET
    @Path("/{prescriptId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptId") int prescriptId) {
        
        Prescription presObj = prescriptDAO.getPrescriptionById(prescriptId);
        if(presObj != null){
            LOGGER.info("Getting prescription by Id: {}", prescriptId);
            return presObj;
        }else{
            throw new ResourceNotFoundException("Prescription with this Id: " + prescriptId + " --> not found.");
        } 
    }

    //Defining the @POST http method for create a prescription by ID
    @POST
    @Path("/create/{prescriptId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrescription(Prescription prescription) {
        prescriptDAO.createPrescription(prescription);
    }
    
    //Defining the @PUT http method for updating a prescription by existing ID
    @PUT
    @Path("/update/{prescriptId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePrescription(@PathParam("prescriptId") int prescriptId, Prescription updatedPrescript) {
        LOGGER.info("Updating prescription by ID: {}", prescriptId);
        Prescription existingPrescript = prescriptDAO.getPrescriptionById(prescriptId);

        if (existingPrescript != null) {
            updatedPrescript.setPrescriptId(prescriptId);
            prescriptDAO.updatePrescription(updatedPrescript);
        }else{
            throw new ResourceNotFoundException("A prescription with Id: " + prescriptId + " --> not found to update.");
        }
    }

    //Defining the @DELETE http method for remove a prescription by existing ID
    @DELETE
    @Path("/delete/{prescriptId}")
    public void deletePrescription(@PathParam("prescriptId") int prescriptId) {
        prescriptDAO.deletePrescription(prescriptId);
    }
    
    
}
