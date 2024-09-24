/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Mahdi
 */

public class PersonDAO {
    
    static List<Person> people = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(PersonDAO.class.getName());
    
    // Every single person
    public List<Person> findAll(){
        return people;
    }
    
    public Person getPersonById(int personID){
        for(Person person: people){
            if(person.getPersonID() == personID){
                return person;
            }
        }
        return null;
    }
    
    public void addPerson(Person person){
        people.add(person);
    }
    
   public void updatePerson(Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getPersonID() == updatedPerson.getPersonID()) {
                people.set(i, updatedPerson);
                System.out.println("Student updated: " + updatedPerson);
                return;
            }
        }
    }
    
    public void deletePerson(int id){
        people.removeIf(person -> person.getPersonID() == id);
    }

}