/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Michail Sitmalidis
 */
public class MyDefaultModel extends DefaultTableModel {

    Map<Integer, Boolean> etidableCellsMap = new HashMap();

//overrideing for all the columns except 17 to be uneditable, and all the rows that are not 'ready' also uneditable 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 17) {
            return etidableCellsMap.get(rowIndex);
        } else {
            return false;
        }
    }


    public void addRow(Object[] rowData, boolean status) {
        addRow(convertToVector(rowData));
        etidableCellsMap.put(getRowCount() - 1, status);
    }

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }
}
