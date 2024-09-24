/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Mahdi
 */
public class Doctor extends Person {
    
    private int DoctorID;
    private String specialization;
    
    public Doctor(int personId, String name, String contactNumber, String address, String type,String specialization,int DoctorID) 
    {
        super(personId,name, contactNumber, address, "Doctor");
        this.specialization=specialization;
        this.DoctorID= DoctorID;
    }

    public Doctor() {
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "DoctorID='" + DoctorID + '\'' +
                ", name='" + getName() + '\'' +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}