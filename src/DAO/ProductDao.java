/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class ProductDao {

    Connection connection;

    public ProductDao() {
        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public ArrayList getProductsList() {
        ArrayList<Product> productsList = new ArrayList<>();
        String productsListQuery = "SELECT * FROM alladin.product";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(productsListQuery);
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_description(rs.getString("product_description"));
                product.setProduct_price(rs.getDouble("product_price"));
                productsList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return productsList;
    }

}
