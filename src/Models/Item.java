/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Michail Sitmalidis
 */
public class Item extends Product {

    private int ItemId;
    private int ItemCode;
    private Double length;
    private Double width;
    private String cleaning;
    private String storing;
    private String mending;
    private Double cleaningCharge;
    private Double storingCharge;
    private Double mendingCharge;
    private String note;

    private int receivingReportId;
    private int deliveryReportId;

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public void setItemCode(int ItemCode) {
        this.ItemCode = ItemCode;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }

    public void setStoring(String storing) {
        this.storing = storing;
    }

    public void setMending(String mending) {
        this.mending = mending;
    }

    public void setCleaningCharge(Double cleaningCharge) {
        this.cleaningCharge = cleaningCharge;
    }

    public void setStoringCharge(Double storingCharge) {
        this.storingCharge = storingCharge;
    }

    public void setMendingCharge(Double mendingCharge) {
        this.mendingCharge = mendingCharge;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setReceivingReportId(int receivingReportId) {
        this.receivingReportId = receivingReportId;
    }

    public void setDeliveryReportId(int deliveryReportId) {
        this.deliveryReportId = deliveryReportId;
    }

    public int getItemId() {
        return ItemId;
    }

    public int getItemCode() {
        return ItemCode;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public String getCleaning() {
        return cleaning;
    }

    public String getStoring() {
        return storing;
    }

    public String getMending() {
        return mending;
    }

    public Double getCleaningCharge() {
        return cleaningCharge;
    }

    public Double getStoringCharge() {
        return storingCharge;
    }

    public Double getMendingCharge() {
        return mendingCharge;
    }

    public String getNote() {
        return note;
    }

    public int getReceivingReportId() {
        return receivingReportId;
    }

    public int getDeliveryReportId() {
        return deliveryReportId;
    }

    
    
}
