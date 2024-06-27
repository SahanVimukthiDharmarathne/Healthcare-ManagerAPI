/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.resource;

/**
 *
 * @author Sahan Dharmarathna
 */


import com.company.dao.PersonDAO;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Person;
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

@Path("/persons")
public class PersonResource{
    
    //Define the logger using logger factory
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);

    //Making the object from PersonDAO class
    private PersonDAO personDAO = new PersonDAO();
    
    //Defining the @GET http method for getting all persons
    @GET
    @Path("/allPersons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }
    
    //Defining the @GET http method for getting a person by ID
    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("personId") int personId) {
        
        Person personObj = personDAO.getPersonById(personId);
        if(personObj != null){
            LOGGER.info("Getting person by Id: {}", personId);
            return personObj;
        }else{
            throw new ResourceNotFoundException("Person with this Id: " + personId + " --> not found.");
        }    
    }
    
    //Defining the @POST http method for create a person by ID
    @POST
    @Path("/create/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(Person person) {
        personDAO.createPerson(person);
    }
    
    //Defining the @PUT http method for updating a person by existing ID
    @PUT
    @Path("/update/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("personId") int personId, Person updatedPerson) {
        
        LOGGER.info("Updating person by ID: {}", personId);
        Person existingPerson = personDAO.getPersonById(personId);

        if (existingPerson != null) {
            updatedPerson.setId(personId);
            personDAO.updatePerson(updatedPerson);
        } else {
            throw new ResourceNotFoundException("A person with Id: " + personId + " --> not found to update.");
        }
    }
    
    //Defining the @DELETE http method for remove a person by existing ID
    @DELETE
    @Path("/delete/{personId}")
    public void deletePerson(@PathParam("personId") int personId) {
        personDAO.deletePerson(personId);
    }
    
}