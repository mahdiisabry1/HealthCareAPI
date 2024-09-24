/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;


import com.mycompany.model.Record;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahdi
 */
public class RecordDAO {
    
    private static final Logger logger = Logger.getLogger(RecordDAO.class.getName());
    private static List<Record> records = new ArrayList<>();
    
    static{
        PatientDAO patientDAO = new PatientDAO();
        
        records.add(new Record(1,patientDAO.getPatientById(143), Arrays.asList("Spidersense", "Lost his ability in spiderman 2"), Arrays.asList("Sleep 8 hours", "StressX tablet")));
        
    }
    public List<Record> getAllRecords(){
        logger.info("Getting Every Single medical records");
        return records;
    }
    
    public Record getRecordById(int id){
        logger.info("Get medical record by id");
        for(Record record : records){
            if (record.getRecordID() == id){
                return record;
            }
        }
        return null;
    }
    
    public void addRecord(Record record){
        records.add(record);
        logger.info("Added record successfully");
    }
    
    public void updateRecord(Record updatedRecord){
        for(int i = 0; i < records.size();i++){
            Record record = records.get(i);
            if(record.getRecordID() == updatedRecord.getRecordID()){
                records.set(i, updatedRecord);
                logger.info("Updated record");
                return;
            }
        }
        logger.info("Record not found");
    }
    
    public void deleteRecord(int id){
        records.removeIf(record -> record.getRecordID() == id);
        logger.info("Deleted the medical record");
    }
    
}
