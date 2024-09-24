/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Mahdi
 */
public class Appointment {
    
    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String dateAndTime;
    
    public Appointment(int appointmentId, Patient patient, Doctor doctor, String dateAndTime) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateAndTime = dateAndTime;
    }
    
    public Appointment(){
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    
        @Override
    public String toString() {
        return "Appointment:{" +
                "id='" + appointmentId + '\'' +
                ", patinet='" + (patient !=null ? patient.toString() : "null" ) + '\'' +
                ", Doctor='" + (doctor !=null ? doctor.toString() : "null" ) + '\'' +
                ", date = '" + dateAndTime + '\'' +
                '}';

    }

}
