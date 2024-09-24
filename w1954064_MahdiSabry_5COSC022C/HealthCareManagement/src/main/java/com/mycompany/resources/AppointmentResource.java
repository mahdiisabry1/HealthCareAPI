/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

import com.mycompany.dao.AppointmentDAO;
import com.mycompany.model.Appointment;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mahdi
 */
@Path("/appointments")
public class AppointmentResource {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointments(Appointment appointment) {
        appointmentDAO.addAppointments(appointment);
    }

    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        // Retrieve the appointment by ID from your DAO or service layer
        Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);

        // Check if the appointment exists
        if (appointment == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Appointment" + appointmentId).build();
        }
        // Return the response
        return Response.ok().entity(appointment).build();
    }

    // Method to update an existing Appointment
    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        try {
            Appointment existingAppointment = appointmentDAO.getAppointmentById(appointmentId);
            if (existingAppointment == null) {
                throw new NotFoundException("Appointment not found with ID: " + appointmentId);
            }
            updatedAppointment.setAppointmentId(appointmentId);
            appointmentDAO.updateAppointment(updatedAppointment);   // update the appointment
            // Return the success response
            return Response.status(Response.Status.OK).entity("Appointment updated successfully").build();
        } catch (Exception e) {
            // Throw WebApplicationException
            throw new WebApplicationException("Error in updating the appointment", e, 500);
        }
    }

    // Method to delete an Appointment
    @DELETE
    @Path("/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        try {    // Delete the appointment
            appointmentDAO.deleteAppointment(appointmentId);    
            // Return the success response
            return Response.status(Response.Status.OK).entity("Appointment deleted successfully").build();
        } catch (Exception e) {
            // Throw WebApplicationException
            throw new WebApplicationException("Error in deleting the appointment with ID", e, 500);
        }
    }
}
