/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

import com.company.dao.MedicalRecordDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.MedicalRecord;
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


@Path("/medRecords")
public class MedicalRecordResource {
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordResource.class);
    
    //Making the object from MedicalRecordDAO class
    private MedicalRecordDAO medRecordDAO = new MedicalRecordDAO();
    
    //Defining the @GET http method for getting all medical records
    @GET
    @Path("/allMedRecords")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() {
        return medRecordDAO.getAllMedicalRecords();
    }

    //Defining the @GET http method for getting a medical record by ID
    @GET
    @Path("/{medRecId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordById(@PathParam("medRecId") int medRecId) {
        
        MedicalRecord medRecObj = medRecordDAO.getMedicalRecordById(medRecId);
        if(medRecObj != null){
            LOGGER.info("Getting medical record by Id: {}", medRecId);
            return medRecObj;
        }else{
            throw new ResourceNotFoundException("Medical record with this Id: " + medRecId + " --> not found.");
        }
    }
    
    //Defining the @POST http method for create a medical record by ID
    @POST
    @Path("/create/{medRecId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMedicalRecord(MedicalRecord newMedRec) {
        medRecordDAO.createMedicalRecord(newMedRec);
    }

    //Defining the @PUT http method for updating a medical record by existing ID    
    @PUT
    @Path("/update/{medRecId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMedicalRecord(@PathParam("medRecId") int medRecId, MedicalRecord updatedMedRec) {
        LOGGER.info("Updating medical record by ID: {}", medRecId);
        MedicalRecord existingMedRec = medRecordDAO.getMedicalRecordById(medRecId);

        if (existingMedRec != null) {
            updatedMedRec.setMedRecId(medRecId);
            medRecordDAO.updateMedicalRecord(updatedMedRec);
        }else{
            throw new ResourceNotFoundException("A medical record with Id: " + medRecId + " --> not found to update.");
        }
    }
    
    //Defining the @DELETE http method for remove a medical record by existing ID
    @DELETE
    @Path("/delete/{medRecId}")
    public void deleteMedicalRecord(@PathParam("medRecId") int medRecId) {
        medRecordDAO.deleteMedicalRecord(medRecId);
    }
    
}
