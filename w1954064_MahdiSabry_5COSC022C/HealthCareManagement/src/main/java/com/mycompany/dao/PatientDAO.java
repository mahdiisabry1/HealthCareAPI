/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Patient;
import com.mycompany.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public class PatientDAO extends PersonDAO{

    private static List<Patient> patients = new ArrayList<>();

    static {
        patients.add(new Patient(12, "Peter Parker", "+945678394", "14 main street NewYork","Patient", 143, Arrays.asList("Spidersense", "Lost his ability in spiderman 2"), "Stable"));
        people.add(new Person(12, "Peter Parker", "+945678394", "14 main street NewYork", "Patient"));
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getPatientID() == id) {
                return patient;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        int newUserId = getNextUserId();
        patient.setPatientID(newUserId);
        patients.add(patient);
        super.addPerson(patient);
    }

    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getPatientID() == updatedPatient.getPatientID()) {
                patients.set(i, updatedPatient);
                System.out.println("Student updated: " + updatedPatient);
                return;
            }
        }
    }
    
    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getPatientID() == id);
    }

    private int getNextUserId() {
        // Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum userId
        for (Patient patient : patients) {
            int userId = patient.getPatientID();
            if (userId > maxUserId) {
                maxUserId = userId;
            }
        }
        // Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}
