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
    double product_price;

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
    

}
