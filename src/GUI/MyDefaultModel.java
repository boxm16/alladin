/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michail Sitmalidis
 */
public class MyDefaultModel extends DefaultTableModel {

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

}
