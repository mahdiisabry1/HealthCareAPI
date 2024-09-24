/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Patient;
import com.mycompany.model.Prescription;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Mahdi
 */
public class PrescriptionDAO {

    private static List<Prescription> prescriptions = new ArrayList<>();
    
    static{
        Patient patient1 = new Patient(12, "Peter Parker", "+945678394", "14 main street NewYork","Patient", 143, Arrays.asList("Spidersense", "Lost his ability in spiderman 2"), "Stable");
        
        prescriptions.add(new Prescription(001, patient1, "MedicineX","2 Tablets","Before meals","2 weeks"));
    }
    
    public List<Prescription> getAllPrescriptions(){
        return prescriptions;
    }
    
    public Prescription getPrescriptionById(int prescriptionId){
        for (Prescription prescription : prescriptions) {
            if (prescription.getPriscriptionId()== prescriptionId) {
                return prescription;
            }
        }
        return null;
    }
    
    // Add prescription
    public void addPrescription(Prescription prescription){
        int newPrescriptionId = getPrescriptionId();
        prescription.setPriscriptionId(newPrescriptionId);
        prescriptions.add(prescription);
    }
    
    public void updatePrescription(Prescription updatedPrescription){
        for(int i = 0; i < prescriptions.size(); i++){
            Prescription prescription = prescriptions.get(i);
            if (prescription.getPriscriptionId() == updatedPrescription.getPriscriptionId()){
                prescriptions.set(i, updatedPrescription);
            }
        }
    }
    
    public void deletePrescription(int id){
        prescriptions.removeIf(prescription -> prescription.getPriscriptionId() == id);
    }

    private int getPrescriptionId() {
        if (prescriptions.isEmpty()) {
            // Return a default value if there are no appointments
            return 1;
        }
        // Initialize maxPrescriptionId with a value lower than any possible prescriptionId
        int maxPrescriptionId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum prescriptionId
        for (Prescription prescription : prescriptions) {
            int prescriptionId = prescription.getPriscriptionId();
            if (prescriptionId > maxPrescriptionId) {
                maxPrescriptionId = prescriptionId;
            }
        }

        // Increment the maximum prescriptionId to get the next available prescriptionId
        return maxPrescriptionId + 1; 
    }
}
