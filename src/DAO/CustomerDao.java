/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Customer;
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
public class CustomerDao {

    Connection connection;

    public CustomerDao() {
        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public void insertCustomer(Customer customer) {
        String insertCustomerQuery = "INSERT INTO alladin.customer "
                + "(first_name, last_name, street, district, floor, landline_phone, mobile_phone, postal_code, name_on_Bell, note) "
                + "VALUES ('" + customer.getFirstName() + "','" + customer.getLastName() + "', '"
                + customer.getStreet() + "','" + customer.getDistrict() + "', '"
                + customer.getFloor() + "', '" + customer.getLandlinePhone() + "', '"
                + customer.getMobilePhone() + "', '" + customer.getPostalCode() + "', '"
                + customer.getNameOnBell() + "', '" + customer.getNote() + "');";

        try (Statement statement = connection.createStatement()) {
            statement.execute(insertCustomerQuery);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Customer> listAllCustomers() {
        ArrayList<Customer> customers = new ArrayList();
        String customersQuery = "SELECT * FROM alladin.customer;";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(customersQuery);
            while(rs.next()) {
            Customer customer=new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customers;
    }

}
