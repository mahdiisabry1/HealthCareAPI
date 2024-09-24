/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.util.List;

/**
 *
 * @author Mahdi
 */
public class Patient extends Person {
    
    private int patientID;
    private List<String> medicalHistory;
    private String healthStatus;

    public Patient(int personId, String name, String contactNumber, String address,String type,int patientID, List<String> medicalHistory, String healthStatus) {
        super(personId, name, contactNumber, address, "Patient");
        this.patientID = patientID;
        this.medicalHistory = medicalHistory;
        this.healthStatus = healthStatus;

    }
    

    public Patient() {
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Patient : {"
                + "  PatientID='" + patientID + '\''
                + ", name='" + getName() + '\''
                + ", contactNumber='" + getContactNumber() + '\''
                + ", address='" + getAddress() + '\''
                + ", medicalHistory='" + medicalHistory + '\''
                + ", healthStatus='" + healthStatus + '\''
                + '}';
    }
}
