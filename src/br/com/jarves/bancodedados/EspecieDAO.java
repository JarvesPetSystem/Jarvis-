/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.bancodedados;

import br.com.jarves.classes.Especie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EspecieDAO {
  public ArrayList<Especie> listarEspecie(){
        ArrayList<Especie> lista = new ArrayList<Especie>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "Select id_especie,INITCAP(nome_especie)especie from tab_especie";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Especie especie = new Especie();
                especie.setIdEspecie(rs.getInt("id_especie"));
                especie.setEspecie(rs.getString("especie"));
                lista.add(especie);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
    }  
}
