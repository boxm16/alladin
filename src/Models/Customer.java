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
public class Customer {

    int customer_id;
    String firstName;
    String lastName;
    String street;
    String district;
    String floor;
    String landlinePhone;
    String mobilePhone;
    String postalCode;
    String nameOnBell;
    String note;

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setNameOnBell(String nameOnBell) {
        this.nameOnBell = nameOnBell;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getFloor() {
        return floor;
    }

    public String getLandlinePhone() {
        return landlinePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getNameOnBell() {
        return nameOnBell;
    }

    public String getNote() {
        return note;
    }

}
