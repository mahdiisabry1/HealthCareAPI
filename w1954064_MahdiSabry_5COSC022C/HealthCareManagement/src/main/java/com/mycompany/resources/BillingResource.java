/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

import com.mycompany.dao.BillingDAO;
import com.mycompany.model.Billing;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Mahdi
 */

@Path("/medicalbills")
public class BillingResource {
    private static final Logger logger = Logger.getLogger(BillingResource.class.getName());
    private BillingDAO billingDAO = new BillingDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBillings() {
        try {
            logger.log(Level.INFO, "Getting all bills");
            return billingDAO.getAllBills();   // Return all bills
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in getting all the bills: " + e.getMessage(), e);
            // Throw WebApplicationException
            throw new WebApplicationException("Error in getting all the bills", e, 500);
        }
    }
    
    @GET
    @Path("/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingRecordByBillNo(@PathParam("billId") int billId) {
        try {
            return billingDAO.getBillById(billId);
        } catch (Exception e) {
            throw e;
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBill(Billing billing) {
        try {
            billingDAO.addBill(billing);
        } catch (Exception e) {
            throw new RuntimeException("Error adding billing", e);
        }
    }

    @PUT
    @Path("/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBill(@PathParam("billId") int billId, Billing updatedBill) {
        try {
            updatedBill.setBillId(billId); // Set the bill number from the path parameter
            billingDAO.updateBill(updatedBill);
        } catch (Exception e) {
            throw e;
        }
    }

    @DELETE
    @Path("/{billId}")
    public void deleteBilling(@PathParam("billId") int billId) {
        try {
            billingDAO.deleteBill(billId);
        } catch (Exception e) {
            throw e;
        }
    }
}
