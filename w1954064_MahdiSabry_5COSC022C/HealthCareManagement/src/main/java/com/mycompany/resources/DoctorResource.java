/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

import com.mycompany.dao.DoctorDAO;
import com.mycompany.model.Doctor;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mahdi
 */
@Path("/doctors")
public class DoctorResource {
    private DoctorDAO doctorDao = new DoctorDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = doctorDao.getAllDoctors();
            return Response.ok(doctors).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving doctors: " + e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/{DoctorID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("DoctorID") int DoctorID) {
        try {
            Doctor doctor = doctorDao.getDoctorById(DoctorID);
            if (doctor == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Doctor with ID " + DoctorID + " not found").build();
            }
            return Response.ok(doctor).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving doctor: " + e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        try {
            doctorDao.addDoctor(doctor);
            return Response.status(Response.Status.CREATED).entity("Doctor added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding doctor: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{DoctorID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("DoctorID") int DoctorID, Doctor updatedDoctor) {
        try {
            Doctor existingDoctor = doctorDao.getDoctorById(DoctorID);
            if (existingDoctor == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Doctor with ID " + DoctorID + " not found").build();
            }
            updatedDoctor.setDoctorID(DoctorID);
            doctorDao.updateDoctor(updatedDoctor);
            return Response.ok().entity("Doctor updated successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating doctor: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{DoctorID}")
    public Response deleteDoctor(@PathParam("DoctorID") int DoctorID) {
        try {
            doctorDao.deleteDoctor(DoctorID);
            return Response.ok().entity("Doctor deleted successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting doctor: " + e.getMessage()).build();
        }
    }
}
    
