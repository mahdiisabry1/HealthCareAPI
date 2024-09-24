/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

import com.mycompany.dao.PatientDAO;
import com.mycompany.model.Patient;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mahdi
 */
@Path("/patients")
public class PatientResource {

    private PatientDAO patientdao = new PatientDAO();
    private static final Logger logger = Logger.getLogger(PatientResource.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        try {
            List<Patient> patients = patientdao.getAllPatients();
            return Response.ok(patients).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving patients: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{patientID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("patientID") int patientID) {
        try {
            Patient patient = patientdao.getPatientById(patientID);
            if (patient == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Patient with ID " + patientID + " not found").build();
            }
            return Response.ok(patient).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving patient: " + e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        try {
            patientdao.addPatient(patient);
            logger.info("Patient added");
            return Response.status(Response.Status.CREATED).entity("Patient added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding patient: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{patientID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientID") int patientID, Patient updatedPatient) {
        try {
            Patient existingPatient = patientdao.getPatientById(patientID);
            if (existingPatient == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Patient with ID " + patientID + " not found").build();
            }
            updatedPatient.setPatientID(patientID);
            patientdao.updatePatient(updatedPatient);
            return Response.ok().entity("Patient updated successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating patient: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{patientID}")
    public Response deletePatient(@PathParam("patientID") int patientID) {
        try {
            patientdao.deletePatient(patientID);
            return Response.ok().entity("Patient deleted successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting patient: " + e.getMessage()).build();
        }
    }
}
