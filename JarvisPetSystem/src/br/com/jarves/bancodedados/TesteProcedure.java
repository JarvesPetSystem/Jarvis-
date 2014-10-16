/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.bancodedados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class TesteProcedure {
    public static void tp(){
        ConexaoOracle co = new ConexaoOracle();
        try {
            
            Connection con = ConexaoOracle.abreConexao();
            CallableStatement cs = con.prepareCall("{call tes(?)}");
            cs.setInt(1, 16);
            cs.execute();
            cs.close();
            con.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }

}
}
