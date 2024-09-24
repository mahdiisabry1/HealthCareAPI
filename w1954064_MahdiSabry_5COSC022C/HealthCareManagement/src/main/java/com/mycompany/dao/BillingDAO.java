/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Billing;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahdi
 */
public class BillingDAO {

    private static final Logger logger = Logger.getLogger(BillingDAO.class.getName());
    // List to store Billing objects
    private static List<Billing> billings = new ArrayList<>();

    static {
        // Create PersonDAO object
        PatientDAO patientDAO = new PatientDAO();

        billings.add(new Billing(patientDAO.getPatientById(143), 001, 10000, 50000));
    }

    // Method to get all Bills
    public List<Billing> getAllBills() {
        logger.log(Level.INFO, "Getting all the bills");
        return billings;   // Return the list of bills
    }

    // Method to get a Bill data using Bill No
    public Billing getBillById(int id) {

        // Iterate through the bill list
        logger.log(Level.INFO, "Getting a bill by ID: " + id);
        for (Billing billing : billings) {
            if (billing.getBillId() == id) {
                return billing;    // return the relevant bill
            }
        }
        logger.log(Level.WARNING, "Bill is not found with ID: " + id);
        return null;

    }

    // Method to add a new Bill
    public void addBill(Billing billing) {
        int newBillNo = getNewBillNo(); // Assuming you have a method to get the next bill number
        billing.setBillId(newBillNo);
        billings.add(billing);   // add a new bill
        logger.log(Level.INFO, "Added a new bill: " + billing);

    }

    // Method to update an existing Bill
    public void updateBill(Billing updatedBilling) {

        // Iterate through the bill list
        for (int i = 0; i < billings.size(); i++) {
            Billing billing = billings.get(i);
            if (billing.getBillId() == updatedBilling.getBillId()) {
                billings.set(i, updatedBilling);  //update the bill
                logger.log(Level.INFO, "Updated the bill: " + updatedBilling);
                return;
            }
        }
        logger.log(Level.WARNING, "Bill is not found to update: " + updatedBilling.getBillId());
    }

    // Method to delete a Bill
    public void deleteBill(int id) {
        billings.removeIf(billing -> billing.getBillId() == id);
        logger.log(Level.INFO, "Deleted the bill with ID: " + id);
    }

    private int getNewBillNo() {
        if (billings.isEmpty()) {
            // Return a default value if there are no appointments
            return 1;
        }
        // Initialize maxBillNo with a value lower than any possible bill number
        int maxBillNo = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum bill number
        for (Billing billing : billings) {
            int billNo = billing.getBillId();
            if (billNo > maxBillNo) {
                maxBillNo = billNo;
            }
        }

        // Increment the maximum bill number to get the next available bill number
        return maxBillNo + 1;
    }

}
