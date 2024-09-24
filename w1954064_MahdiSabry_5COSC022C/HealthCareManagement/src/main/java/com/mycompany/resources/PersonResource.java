/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

/**
 *
 * @author Mahdi
 */

import com.mycompany.dao.PersonDAO;
import com.mycompany.model.Person;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    private PersonDAO personDAO = new PersonDAO();
    private static final Logger logger = Logger.getLogger(PersonResource.class.getName());


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        try {
            return personDAO.findAll();
        } catch (Exception e) {
            // Handle the exception
            throw new WebApplicationException("Error occurred while retrieving all persons.", e);
        }
    }

    @GET
    @Path("/{PersonID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("PersonID") int PersonID) {
        try {
            Person person = personDAO.getPersonById(PersonID);
            if (person != null) {
                return person;
            } else {
                throw new NotFoundException("Person with ID " + PersonID + " not found.");
            }
        } catch (Exception e) {
            // Handle the exception
            throw new WebApplicationException("Error occurred while retrieving person with ID " + PersonID, e);
        }
    }

    @PUT
    @Path("/{PersonID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("PersonID") int PersonID, Person updatedPerson) {
        try {
            Person existingPatient = personDAO.getPersonById(PersonID);

            if (existingPatient != null) {
                updatedPerson.setPersonID(PersonID);
                personDAO.updatePerson(updatedPerson);
            } else {
                throw new NotFoundException("Person with ID " + PersonID + " not found.");
            }
        } catch (Exception e) {
            // Handle the exception
            throw new WebApplicationException("Error occurred while updating person with ID " + PersonID, e);
        }
    }

    @DELETE
    @Path("/{PersonID}")
    public void deletePerson(@PathParam("PersonID") int PersonID) {
        try {
            personDAO.deletePerson(PersonID);
        } catch (Exception e) {
            // Handle the exception
            throw new WebApplicationException("Error occurred while deleting person with ID " + PersonID, e);
        }
    }
}