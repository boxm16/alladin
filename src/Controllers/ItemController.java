/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ItemDao;
import Models.ReceivingReport;

/**
 *
 * @author Michail Sitmalidis
 */
public class ItemController {

    ItemDao itemDao;

    public ItemController() {
        itemDao = new ItemDao();
    }

    public void insertReceivingReport(ReceivingReport receivingReport) {

        itemDao.insertReceivingReport(receivingReport);

    }

}
