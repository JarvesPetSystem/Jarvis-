/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
        
        setFont(new Font("Arial",Font.BOLD,12));
        setHorizontalAlignment(LEFT);
        
        if(row %2 == 0){
            setBackground(null);
        }else{
            setBackground(Color.decode("#6495ED"));
            setForeground(Color.white);
        }
        
        if(isSelected){
            setBackground(Color.decode("#6A5ACD"));
            setForeground(Color.white);
            setFont(new Font("Arial",Font.BOLD,14));
            
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        /*table.getColumnModel().getColumn(1).setMaxWidth(350);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(180);*/
      
        
        return this;
    }
    
    
}
