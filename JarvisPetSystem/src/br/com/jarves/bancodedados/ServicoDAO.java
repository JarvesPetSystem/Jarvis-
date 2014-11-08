/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.bancodedados;

import br.com.jarves.classes.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel
 */
public class ServicoDAO {
    
    
     public String insereServico(Servico servico){
        String msg;
             
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "INSERT INTO tab_servico (id_servico,nome_servico,descr_servico,preco_servico,dtcad_servico) VALUES (seq_id_servico.nextval,?,?,?,SYSDATE)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, servico.getNomeServico());
            stmt.setString(2, servico.getDescrServico());
            stmt.setDouble(3, servico.getPrecoServico());
            
            
            stmt.execute();
            msg = "Servico Registrado com Sucesso!";
        } catch (SQLException ex) {
            msg = "Erro ao Registar Servico: "+ex;
        }
        return msg;
    }
    public String alteraServico(Servico servico){
        String msg;
             
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "UPDATE tab_servico SET nome_servico = ?, descr_servico = ?, preco_servico = ? WHERE id_servico in ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, servico.getNomeServico());
            stmt.setString(2, servico.getDescrServico());
            stmt.setDouble(3, servico.getPrecoServico());
            stmt.setInt(4, servico.getIdServico());
            stmt.execute();
            msg = "Servico Alterado com Sucesso!";
        } catch (SQLException ex) {
            msg = "Erro ao Registrar Servico: "+ex;
        }
        return msg;
        
        
    }public ArrayList<Servico> listarServico(){
        
        ArrayList<Servico> lista = new ArrayList<>();
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "SELECT id_servico,initcap(nome_servico) servico, descr_servico descr, preco_servico preco FROM tab_servico ORDER BY id_servico";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Servico servico = new Servico();
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setNomeServico(rs.getString("servico"));
                servico.setDescrServico(rs.getString("descr"));
                servico.setPrecoServico(rs.getDouble("preco"));
                lista.add(servico);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex); 
        }
        
        return lista;
    }
}