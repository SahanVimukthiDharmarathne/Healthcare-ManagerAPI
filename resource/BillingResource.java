/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

import com.company.dao.BillingDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Billing;
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


@Path("/billResource")
public class BillingResource {
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingResource.class);
    
    //Making the object from BillingDAO class
    private BillingDAO billDAO = new BillingDAO();
    
    //Defining the @GET http method for getting all bills
    @GET
    @Path("/allBills")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBills() {
        return billDAO.getAllBills();
    }

    //Defining the @GET http method for getting a bill by ID
    @GET
    @Path("/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillById(@PathParam("billId") int billId) {
        
        Billing billObj = billDAO.getBillById(billId);
        if(billObj != null){
            LOGGER.info("Getting bill by Id: {}", billId);
            return billObj;
        }else{
            throw new ResourceNotFoundException("Bill with this Id: " + billId + " --> not found.");
        } 
    }

    //Defining the @POST http method for create a bill by ID
    @POST
    @Path("/create/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBill(Billing bill) {
        billDAO.createBill(bill);
    }
    
    //Defining the @PUT http method for updating a bill by existing ID
    @PUT
    @Path("/update/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBill(@PathParam("billId") int billId, Billing updatedBill) {
        LOGGER.info("Updating bill by ID: {}", billId);
        Billing existingBill = billDAO.getBillById(billId);

        if (existingBill != null) {
            updatedBill.setBillingId(billId);
            billDAO.updateBill(updatedBill);
        }else{
            throw new ResourceNotFoundException("A bill with Id: " + billId + " --> not found to update.");
        }
    }

    //Defining the @DELETE http method for remove a bill by existing ID
    @DELETE
    @Path("/delete/{billId}")
    public void deleteBill(@PathParam("billId") int billId) {
        billDAO.deleteBill(billId);
    }
    
    
}
