/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DataBaseInitialization;

/**
 *
 * @author Michail Sitmalidis
 */
public class InitializationController {

    //i`m not sure what good it does make, creating this class, i could initialize database wrigth from the button click listener, just playing by the rules- mvc-(controller
    DataBaseInitialization dbInitialization = new DataBaseInitialization();

    public void initializeDataBase() {
        if (!dbInitialization.checkDBExist()) {
            System.out.println("----Database 'alladain' does not exist.----");
        
            dbInitialization.createDB();

        } else {
            System.out.println("----Database 'alladain' already exists.----");
        }
    }
}
