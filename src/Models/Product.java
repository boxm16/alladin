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
public class Product {

    int product_id;
    String product_description;
    double cleaning_price;
    double storing_price;
    double mending_price;

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public void setCleaning_price(double cleaning_price) {
        this.cleaning_price = cleaning_price;
    }

    public void setStoring_price(double storing_price) {
        this.storing_price = storing_price;
    }

    public void setMending_price(double mending_price) {
        this.mending_price = mending_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_description() {
        return product_description;
    }

    public double getCleaning_price() {
        return cleaning_price;
    }

    public double getStoring_price() {
        return storing_price;
    }

    public double getMending_price() {
        return mending_price;
    }
    

}
