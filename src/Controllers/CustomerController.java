/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CustomerDao;
import Models.Customer;
import Models.Item;
import java.util.ArrayList;

/**
 *
 * @author Michail Sitmalidis
 */
public class CustomerController {

    CustomerDao customerDao;

    public CustomerController() {
        customerDao = new CustomerDao();
    }

    public void addNewCustomer(Customer customer) {
        customerDao.insertCustomer(customer);
    }

    public ArrayList<Customer> populateCustomersTable() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers = customerDao.listAllCustomers();
        return customers;

    }

    public Customer getCustomerById(int customer_id) {
        Customer customer = customerDao.getCustomerById(customer_id);

        return customer;
    }


}
