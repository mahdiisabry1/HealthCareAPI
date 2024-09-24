/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Mahdi
 */
public class Prescription {
    
    private int priscriptionId;
    private Patient patient;
    private String medication;
    private String dosage;
    private String instructions;
    private String duration;

    public Prescription(int priscriptionId, Patient patient, String medication, String dosage, String instructions, String duration) {
        this.priscriptionId = priscriptionId;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }
    
    public Prescription(){}

    
    public int getPriscriptionId() {
        return priscriptionId;
    }

    public void setPriscriptionId(int priscriptionId) {
        this.priscriptionId = priscriptionId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
