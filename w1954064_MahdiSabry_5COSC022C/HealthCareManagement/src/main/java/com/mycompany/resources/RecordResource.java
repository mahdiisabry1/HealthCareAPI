/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

import com.mycompany.dao.RecordDAO;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.mycompany.model.Record;
import java.util.logging.Level;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mahdi
 */
@Path("/medrecords")
public class RecordResource {

    private static final Logger logger = Logger.getLogger(RecordResource.class.getName());
    private RecordDAO recordDAO = new RecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRecords() {
        try {
            logger.info("Getting All medical records");
            List<Record> records = recordDAO.getAllRecords();
            return Response.ok(records).build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in getting records: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error in getting all the medical records: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{recordID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecordById(@PathParam("recordID") int recordID) {
        try {
            logger.log(Level.INFO, "Getting medical record for id number {0}", recordID);
            Record record = recordDAO.getRecordById(recordID);
            if (record == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Record with ID " + recordID + " not found").build();
            }
            return Response.ok(record).build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in getting the medical record by ID: " + recordID + ", " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error in getting the medical record by ID: " + e.getMessage()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRecord(Record record) {
        try {
            recordDAO.addRecord(record);
            logger.info("Record created successfully");
            return Response.status(Response.Status.CREATED).entity("Record created successfully").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding medical record: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding medical record: " + e.getMessage()).build();
        }
    }
    
    @PUT
    @Path("/{recordID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecord(Record updatedRecord, @PathParam("recordID") int recordID) {
        try {
            // Set the patient ID in the updated record
            updatedRecord.getPatient().setPatientID(recordID);
            // Call the DAO method to update the medical record
            recordDAO.updateRecord(updatedRecord);
            logger.info("Record updated successfully");
            return Response.ok().entity("Record updated successfully").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error updating medical record: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating medical record: " + e.getMessage()).build();
        } 
    }

    @DELETE
    @Path("/{recordID}")
    public Response deleteMedicalRecord(@PathParam("recordID") int recordID) {
        try {
            recordDAO.deleteRecord(recordID);
            return Response.ok().entity("Record deleted successfully").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting medical record: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting medical record: " + e.getMessage()).build();
        } 
    }
}
