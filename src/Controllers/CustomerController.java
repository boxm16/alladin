/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CustomerDao;
import Models.Customer;

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

}
