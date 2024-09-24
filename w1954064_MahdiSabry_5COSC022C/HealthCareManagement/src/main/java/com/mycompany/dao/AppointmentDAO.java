/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Appointment;
import com.mycompany.model.Doctor;
import com.mycompany.model.Patient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahdi
 */
public class AppointmentDAO {

    private static final Logger logger = Logger.getLogger(AppointmentDAO.class.getName());
    static List<Appointment> appointments = new ArrayList<>();

    static {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        
        appointments.add(new Appointment(1, patientDAO.getPatientById(143), doctorDAO.getDoctorById(76), formattedDate));
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
    
    public Appointment getAppointmentById(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    public void addAppointments(Appointment appointment) {
        int newAppointmentId = getAppointmentId();
        appointment.setAppointmentId(newAppointmentId);
        appointments.add(appointment);
    }
    
    public void updateAppointment(Appointment updatedAppointment) {
        try {
            for (int i = 0; i < appointments.size(); i++) {
                Appointment appointment = appointments.get(i);
                if (appointment.getAppointmentId() == updatedAppointment.getAppointmentId()) {
                    appointments.set(i, updatedAppointment);
                    return;
                }
            }
        } catch (Exception e) {
            logger.log(Level.INFO, "Error occured{0}", e);
        }
    }

    public void deleteAppointment(int id) {
        try {
            appointments.removeIf(appointment -> appointment.getAppointmentId() == id);
        } catch (Exception e) {
            logger.log(Level.INFO, "Error occured{0}", e);
        }
    }

    private int getAppointmentId() {
        if (appointments.isEmpty()) {
            // Return a default value if there are no appointments
            return 1;
        }
        // Initialize maxUserId with a value lower than any possible userId
        int maxgetAppointmentId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum userId
        for (Appointment appointment : appointments) {
            int appointmentId = appointment.getAppointmentId();
            if (appointmentId > maxgetAppointmentId) {
                maxgetAppointmentId = appointmentId;
            }
        }

        // Increment the maximum userId to get the next available userId
        return maxgetAppointmentId + 1;
    }

}
