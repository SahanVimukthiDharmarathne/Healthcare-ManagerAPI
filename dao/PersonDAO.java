/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

import com.company.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Sahan Dharmarathna
 */
public class PersonDAO {
    //Defining logger
    private static final Logger LOGGER = Logger.getLogger(PersonDAO.class.getName());
    //Initializing the arraylist
    private static List<Person> persons = new ArrayList<>();
    
    //Defining the details static block
    static{
        persons.add(new Person(1, "isira", "Mobile: 0710000000", "Athurugiriya,Colombo"));
        persons.add(new Person(2, "pahan", "Mobile: 0714545454", "Alawwa,Kagalla"));
        persons.add(new Person(3, "nuwandi", "Mobile: 0713333333", "Anuradhapura,New Town"));

    }
    
    
    //Create Operation
    public void createPerson(Person person){
        persons.add(person);
    }
    
    //Read Operation for all persons.
    public List<Person> getAllPersons(){
        //return new ArrayList<>(persons);
        return persons;
    }
    
    //Read Operation for each person.
    public Person getPersonById(int id){
        for(Person person : persons){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }
    
    //Update Operation
    public void updatePerson(Person updatedPerson){
        for(int i = 0; i < persons.size(); i++){
            Person person =persons.get(i);
            if(person.getId() == updatedPerson.getId()){
                persons.set(i, updatedPerson);
                System.out.println("Person is updated: " + updatedPerson);
                LOGGER.info("Person is updated.");
                return;
            }
        }
        LOGGER.severe("There is no person with this id to update: " + updatedPerson.getId());
        throw new RuntimeException("There is no person with this id to update: " + updatedPerson.getId());
    }
    
    //Delete Operation
    public void deletePerson(int id){
        persons.removeIf(person -> person.getId() == id);
        LOGGER.info("Person is deleted.");
    }   
}
