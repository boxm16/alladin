/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ItemDao;
import Models.Item;
import Models.ReceivingReport;
import java.util.ArrayList;

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

    public void insertItemsDimensions(ArrayList<Item> itemsList) {
    
    
    itemDao.insertItemsDimesnions(itemsList);
    
    }

    public ArrayList<Item> getCustomerItems(int customer_id) {
   ArrayList<Item> itemList=new ArrayList();
   
   itemList=itemDao.getItemList(customer_id);
   
   return itemList; 
    }

}
