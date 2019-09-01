/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ProductDao;
import Models.Product;
import java.util.ArrayList;

/**
 *
 * @author Michail Sitmalidis
 */
public class ProductController {

    ProductDao productDao;

    public ProductController() {
        productDao = new ProductDao();
    }

    public ArrayList<Product> getProductsList() {
        ArrayList<Product> productsList = productDao.getProductsList();
        return productsList;
    }

}
