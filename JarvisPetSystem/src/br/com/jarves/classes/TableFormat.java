/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.classes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Humberto
 */
public class TableFormat extends DefaultTableCellHeaderRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int colum) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, colum);
        
        if(row %2 == 0){
            setBackground(Color.decode("#AFEEEE"));
        }else{
            setBackground(null);
        }
        
        if(isSelected){
            setBackground(Color.gray);
        }
        table.getColumnModel().getColumn(0).setMaxWidth(450);
        table.getColumnModel().getColumn(1).setMaxWidth(350);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(180);
        
        
        return this;
    }
    
    
}
