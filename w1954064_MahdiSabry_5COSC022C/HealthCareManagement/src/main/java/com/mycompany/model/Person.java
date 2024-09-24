/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Mahdi
 */
public class Person {
    
    private int PersonID;
    private String name;
    private String contactNumber;
    private String address;
    private String type;
   
    public Person(int PersonID, String name, String contactNumber, String address, String type) {
        this.PersonID=PersonID;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.type = type;
    }

    public Person() {
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public String toString() {
        return "Person:{" +
                "personID='" + PersonID + '\'' +
                ", name='" + name + '\'' +
                ", contactNumber=" + contactNumber +
                ", address='" + address + '\'' +
                ", type = '" + type + '\'' +
                '}';

    }
}


