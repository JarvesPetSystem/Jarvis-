/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.bancodedados;

import br.com.jarves.classes.*;
import java.sql.Connection;
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
            stmt.setBigDecimal(3, servico.getPrecoServico());
            
            
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
            stmt.setBigDecimal(3, servico.getPrecoServico());
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
                servico.setPrecoServico(rs.getBigDecimal("preco"));
                lista.add(servico);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex); 
        }
        
        return lista;
    }
    
    public Servico getServico(int codServico){
        Servico servico = new Servico();
        
         try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "SELECT tcli.id_cliente,ts.id_servico,initcap(ts.nome_servico)servico,ts.preco_servico preco,initcap(tcli.nome_cliente) ncli,initcap(tani.nome_animal)nanimal FROM tab_agenda_servico taserv INNER JOIN tab_servico ts ON taserv.id_servico_fk IN ts.id_servico INNER JOIN tab_animal tani ON " +
                         "taserv.id_animal_fk in tani.id_animal INNER JOIN tab_cliente tcli ON tani.id_cliente_fk IN tcli.id_cliente where id_agenda_servico in ?  AND status_pagto IS NULL and taserv.status_agenda_servico <> 'cancelado'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codServico);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Animal animal = new Animal();
                Cliente cliente = new Cliente();
                
                animal.setNome(rs.getString("nanimal"));
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("ncli"));
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setNomeServico(rs.getString("servico"));
                servico.setPrecoServico(rs.getBigDecimal("preco"));
                servico.setAnimal(animal);
                servico.setCliente(cliente);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex); 
        }
        
        
        
        return servico;
    
    }
    
    
    
    
    
    
    
    
}