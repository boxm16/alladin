/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Michail Sitmalidis
 */
public class ReceivingReport {

    private int receivingReportId;
    private String receivingDate;
    private int receivingReportNumber;
    private Customer customer;
    private ArrayList<Item> receivedItems;

    public void setReceivingReportId(int receivingReportId) {
        this.receivingReportId = receivingReportId;
    }

   

    public void setReceivingReportNumber(int receivingReportNumber) {
        this.receivingReportNumber = receivingReportNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setReceivedItems(ArrayList<Item> receivedItems) {
        this.receivedItems = receivedItems;
    }

    public int getReceivingReportId() {
        return receivingReportId;
    }

   

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Item> getReceivedItems() {
        return receivedItems;
    }

    public int getReceivingReportNumber() {
        return receivingReportNumber;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getReceivingDate() {
        return receivingDate;
    }

}
