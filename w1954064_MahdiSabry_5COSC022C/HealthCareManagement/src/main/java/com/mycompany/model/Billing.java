/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author DELL
 */
public class Billing {
    
    private Patient patient;
    private int billId;
    private double outStandingBalance;
    private double totalPayment;

    public Billing(Patient patient, int billId, double outStandingBalance, double totalPayment) {
        this.patient = patient;
        this.billId = billId;
        this.outStandingBalance = outStandingBalance;
        this.totalPayment = totalPayment;
    }
    
    public Billing(){}

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    public int getBillId() {
        return billId;
    }

    public void setBillId(int buildId) {
        this.billId = buildId;
    }

    public double getOutStandingBalance() {
        return outStandingBalance;
    }

    public void setOutStandingBalance(double outStandingBalance) {
        this.outStandingBalance = outStandingBalance;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
    
    
}
