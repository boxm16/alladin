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

            Customer customer = new Customer();

            while (rs.next()) {
                customer = fillCustomerFromResultSet(rs);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customers;
    }

    public Customer getCustomerById(int customer_id) {
        Customer customer = null;
        String getCustomerByIdQuery = "SELECT * FROM alladin.customer WHERE customer_id=" + customer_id + "";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(getCustomerByIdQuery);
            while (rs.next()) {
                customer = fillCustomerFromResultSet(rs);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return customer;
    }

    private Customer fillCustomerFromResultSet(ResultSet rs) {
        Customer customer = new Customer();
        try {

            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setStreet(rs.getString("street"));
            customer.setDistrict(rs.getString("district"));
            customer.setLandlinePhone(rs.getString("landline_phone"));
            customer.setMobilePhone(rs.getString("mobile_phone"));
            customer.setFloor(rs.getString("floor"));
            customer.setPostalCode(rs.getString("postal_code"));
            customer.setNote(rs.getString("note"));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

}
