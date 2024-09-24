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
public class Record {
    
    private int recordID;
    private Patient patient;
    private List<String> diagnoses;
    private List<String> treatment;

    public Record(int recordID, Patient patient, List<String> diagnoses, List<String> treatment) {
        this.recordID = recordID;
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatment = treatment;
    }
    
    public Record(){}

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<String> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<String> treatment) {
        this.treatment = treatment;
    }
 
}
