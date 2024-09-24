/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Doctor;
import com.mycompany.model.Person;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mahdi
 */
public class DoctorDAO extends PersonDAO{
    
    private static List<Doctor> doctors = new ArrayList<>();
    
    static{
        doctors.add(new Doctor(111, "5 rupees doctor", "+987654345", "43 Chennai India","Doctor", "5 ruppes",05));
        doctors.add(new Doctor(233, "Dr. Dolittle", "+943343242", "121 los angeles California","Doctor", "Veterinarian",76));
        people.add(new Person(111, "5 rupees doctor", "+987654345", "43 Chennai India", "Doctor"));
        people.add(new Person(233, "Dr. Dolittle", "+943343242", "121 los angeles California", "Doctor"));
    }
    
    public List<Doctor> getAllDoctors(){
        return doctors;
    }
    
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorID() == id) {
                return doctor;
            }
        }
        return null;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        super.addPerson(doctor);
    }

    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getDoctorID() == updatedDoctor.getDoctorID()) {
                doctors.set(i, updatedDoctor);
                return;
            }
        }
    }

    public void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getDoctorID() == id);
    }
    
}
