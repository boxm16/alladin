/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Michail Sitmalidis
 */
public class MyTable extends JTable {

    DefaultTableModel model;

    public MyTable(DefaultTableModel model) {

        this.model = model;

    }

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        //  Color row based on a cell value
        if (!isRowSelected(row)) {
            c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            String type = (String) getModel().getValueAt(modelRow, 0);
            boolean oop = (boolean) getModel().getValueAt(modelRow, 17);
            if (!"ready".equals(type)) {
                model.setValueAt(false, modelRow, 17);
                c.setBackground(Color.RED);
            }
            if (oop) {
                c.setBackground(Color.GREEN);
            }

        }
        if (isRowSelected(row)) {
            //   c.setBackground(getBackground());
            int modelRow = convertRowIndexToModel(row);
            String type = (String) getModel().getValueAt(modelRow, 0);
            boolean oop = (boolean) getModel().getValueAt(modelRow, 17);

            if (!"ready".equals(type)) {
                model.setValueAt(false, modelRow, 17);
                c.setBackground(Color.PINK);
            }
        }
        return c;
    }

 

}
