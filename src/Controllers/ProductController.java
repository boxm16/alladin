/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ProductDao;
import Models.Product;
import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap<Integer, Product> getProductsMap() {
        HashMap<Integer, Product> productsMap = new HashMap<>();
        ArrayList<Product> productsList = productDao.getProductsList();

        for (Product product : productsList) {
            productsMap.put(product.getProduct_id(), product);
        }

        return productsMap;
    }

}
