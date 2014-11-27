/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.bancodedados;

import br.com.jarves.classes.AgendaServico;
import br.com.jarves.classes.Animal;
import br.com.jarves.classes.Cliente;
import br.com.jarves.classes.Contato;
import br.com.jarves.classes.Logradouro;
import br.com.jarves.classes.Servico;
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
public class AgendaServicoDAO {
    
     public AgendaServico getAgendaServico(AgendaServico agendaservico) {

        ConexaoOracle co = new ConexaoOracle();
        Animal animal = new Animal();
        Servico servico = new Servico();
        try {

            Connection con = co.abreConexao();
            String sql = "SELECT a.id_agenda_servico"
                    + ",ani.id_animal"
                    + ",s.id_servico"
                    + ",a.hora_agenda_servico"
                    + ",a.data_agenda_servico"
                    + ",a.status_agenda_servico"
                    + "FROM tab_agenda_servico a INNER JOIN tab_animal ani "
                    + "ON a.id_animal_fk in ani.id_animal "
                    + "INNER JOIN  tab_servico s ON a.id_servico_fk in s.id_servico "
                    + "WHERE  a.id_agenda_servico in ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, agendaservico.getServico().getNomeServico());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                agendaservico.setIdAgendaServico(rs.getInt("id_agenda_servico"));
                animal.setIdAnimal(rs.getInt("id_animal"));
                servico.setIdServico(rs.getInt("id_servico"));
                agendaservico.setHoraAgendaServico(rs.getString("hora_agenda_servico"));
                agendaservico.setDataAgendaServico(rs.getDate("data_agenda_servico"));
                agendaservico.setStatusAgendaServico(rs.getString("status_agenda_servico"));
                
                agendaservico = null;
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            e.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null, user.getNomeUsuario());
        return agendaservico;
    }
     
     
     
     
     
     
     public String insereAgendaServico(AgendaServico agendaservico) {
        String msg;
        ConexaoOracle co = new ConexaoOracle();
        

        try {

            try (Connection con = co.abreConexao()) {
                CallableStatement cs = con.prepareCall("{call insere_agendamento_servico(?,?,?,?,?)}");
                
                cs.setInt(1,agendaservico.getAnimal().getIdAnimal());
                cs.setString(2,agendaservico.getServico().getNomeServico());
                cs.setString(3, agendaservico.getHoraAgendaServico());
                cs.setDate(4, (Date) agendaservico.getDataAgendaServico());
                cs.setString(5, agendaservico.getStatusAgendaServico());
                cs.execute();
                cs.close();
            }
            msg = "Agendamento Efetuado com Sucesso";

        } catch (SQLException ex) {
            msg = "Erro" + ex;
        }

        return msg;
    }
     
     public ArrayList<AgendaServico> listarAgendaServico(){
        
        ArrayList<AgendaServico> lista = new ArrayList<>();
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "SELECT id_agenda_servico, FROM tab_agenda_servico ORDER BY id_agenda_servico";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                AgendaServico agendaservico = new AgendaServico();
                agendaservico.setIdAgendaServico(rs.getInt("id_agenda_servico"));
              
               
                
                lista.add(agendaservico);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex); 
        }
        
        return lista;
    }
     
     
     public ArrayList<AgendaServico> RecebeData(String data){
         
         ArrayList<AgendaServico> lista2 = new ArrayList<>();
        
         
          try {
              ConexaoOracle co = new ConexaoOracle();

            Connection con = co.abreConexao();
                String sql = " SELECT id_agenda_servico,data_agenda_servico DATA,hora_agenda_servico HORA, status_agenda_servico STATUS,"
                    + " ta.nome_animal nome_animal,ta.id_animal id_animal,initcap(ts.nome_servico) nome_servico, tc.nome_cliente proprietario, tc.cpf_cliente cpf"
                    + " FROM tab_agenda_servico tas INNER JOIN tab_animal ta ON tas.id_animal_fk IN ta.id_animal INNER JOIN tab_servico ts ON "
                    + " tas.id_servico_fk IN ts.id_servico INNER JOIN tab_cliente tc ON ta.id_cliente_fk in tc.id_cliente"
                    + " where tas.data_agenda_servico LIKE ? ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Animal animal = new Animal();
                Servico servico = new Servico();
                Cliente cliente = new Cliente();
                
                
                 AgendaServico agendaservico = new AgendaServico();
                 agendaservico.setIdAgendaServico(rs.getInt("id_agenda_servico"));
                 agendaservico.setDataAgendaServico(rs.getDate("DATA"));
                 agendaservico.setHoraAgendaServico(rs.getString("HORA"));
                 agendaservico.setStatusAgendaServico(rs.getString("STATUS"));
                 animal.setNome(rs.getString("nome_animal"));
                 animal.setIdAnimal(rs.getInt("id_animal"));
                 servico.setNomeServico(rs.getString("nome_servico"));
                 cliente.setNomeCliente(rs.getString("PROPRIETARIO"));
                 agendaservico.setAnimal(animal);
                 agendaservico.setServico(servico);
                 agendaservico.setCliente(cliente);
                 
                lista2.add(agendaservico);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);

        } 
        //JOptionPane.showMessageDialog(null, user.getNomeUsuario());
        return lista2;
     }
     
   public String alteraAgendaServico(AgendaServico agendaservico){
    
        
        ConexaoOracle co = new ConexaoOracle();
        String msg;
        try {
            
            Connection con = co.abreConexao();
            String sql ="UPDATE tab_agenda_servico SET  id_servico_fk = (select id_servico from tab_servico where nome_servico in ?), hora_agenda_servico = ?, data_agenda_servico = ?," +
                        "  status_agenda_servico = ? " +
                        "   WHERE id_agenda_servico IN ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, agendaservico.getServico().getNomeServico());
            stmt.setString(2, agendaservico.getHoraAgendaServico());
            stmt.setDate(3,(Date) agendaservico.getDataAgendaServico());
            stmt.setString(4, agendaservico.getStatusAgendaServico());
            stmt.setInt(5, agendaservico.getIdAgendaServico());
            stmt.execute();
            stmt.close();
            stmt.close();
            msg = "Cliente Alterado com Sucesso";
            
        } catch (SQLException ex) {
            msg = "Erro"+ex;
        }

        return msg;
    }
   
   
   public ArrayList<AgendaServico> pesquisarAgenda(String cpf, String rga) {

        ArrayList<AgendaServico> lista = new ArrayList<AgendaServico>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = " SELECT id_agenda_servico,data_agenda_servico DATA,hora_agenda_servico HORA, status_agenda_servico STATUS,"
                    + " ta.nome_animal nome_animal,ta.id_animal id_animal,initcap(ts.nome_servico) nome_servico, tc.nome_cliente proprietario, tc.cpf_cliente cpf,"
                    + " initcap(tl.nome_logradouro) endereco,tl.cep_logradouro cep,te.nr_endereco num, te.comp_endereco comp_endereco,"
                    + "tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato obs_contato"
                    + " FROM tab_agenda_servico tas INNER JOIN tab_animal ta ON tas.id_animal_fk IN ta.id_animal INNER JOIN tab_servico ts ON "
                    + " tas.id_servico_fk IN ts.id_servico INNER JOIN tab_cliente tc ON ta.id_cliente_fk in tc.id_cliente INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON "
                    + "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN tab_contato tcon ON "
                    + "tc.id_cliente in tcon.id_cliente_fk"
                    + " where tc.cpf_cliente LIKE ? or ta.id_animal like ? ";
            System.out.println(sql + cpf + rga);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, rga);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                Animal animal = new Animal();
                Servico servico = new Servico();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
               
                

                 AgendaServico agendaservico = new AgendaServico();
                 agendaservico.setIdAgendaServico(rs.getInt("id_agenda_servico"));
                 agendaservico.setDataAgendaServico(rs.getDate("DATA"));
                 agendaservico.setHoraAgendaServico(rs.getString("HORA"));
                 agendaservico.setStatusAgendaServico(rs.getString("STATUS"));
                 animal.setNome(rs.getString("nome_animal"));
                 animal.setIdAnimal(rs.getInt("id_animal"));
                 servico.setNomeServico(rs.getString("nome_servico"));
                 cliente.setNomeCliente(rs.getString("PROPRIETARIO"));
                 cliente.setCpf(rs.getString("cpf"));
                 endereco.setNomeRua(rs.getString("endereco"));
                 endereco.setCep(rs.getString("cep"));
                 endereco.setNumero(rs.getString("num"));
                 endereco.setComplemento(rs.getString("comp_endereco"));
                 
                 contato.setEmail(rs.getString("email"));
                 contato.setCelular(rs.getString("celu"));
                 contato.setTelefone(rs.getString("tele"));
                 contato.setObs(rs.getString("obs_contato"));
                 
                 agendaservico.setAnimal(animal);
                 agendaservico.setServico(servico);
                 agendaservico.setCliente(cliente);
                 agendaservico.setEndereco(endereco);
                 agendaservico.setContato(contato);
                 
                 lista.add(agendaservico);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

        return lista;

    }

   
   
   public ArrayList<AgendaServico> listarAgenda() {

        ArrayList<AgendaServico> lista = new ArrayList<AgendaServico>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = " SELECT id_agenda_servico,data_agenda_servico DATA,hora_agenda_servico HORA, status_agenda_servico STATUS,"
                    + " ta.nome_animal nome_animal,ta.id_animal id_animal,initcap(ts.nome_servico) nome_servico, tc.nome_cliente proprietario, "
                    + " tc.cpf_cliente cpf , initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, te.comp_endereco,"
                    + "tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato"
                    + " FROM tab_agenda_servico tas INNER JOIN tab_animal ta ON tas.id_animal_fk IN ta.id_animal INNER JOIN tab_servico ts ON "
                    + " tas.id_servico_fk IN ts.id_servico INNER JOIN tab_cliente tc ON ta.id_cliente_fk in tc.id_cliente INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON "
                    + "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN tab_contato tcon ON "
                    + "tc.id_cliente in tcon.id_cliente_fk ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                Animal animal = new Animal();
                Servico servico = new Servico();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
               
                

                 AgendaServico agendaservico = new AgendaServico();
                 agendaservico.setIdAgendaServico(rs.getInt("id_agenda_servico"));
                 agendaservico.setDataAgendaServico(rs.getDate("DATA"));
                 agendaservico.setHoraAgendaServico(rs.getString("HORA"));
                 agendaservico.setStatusAgendaServico(rs.getString("STATUS"));
                 animal.setNome(rs.getString("nome_animal"));
                 animal.setIdAnimal(rs.getInt("id_animal"));
                 servico.setNomeServico(rs.getString("nome_servico"));
                 cliente.setNomeCliente(rs.getString("PROPRIETARIO"));
                 cliente.setCpf(rs.getString("cpf"));
                 endereco.setNomeRua(rs.getString("endereco"));
                 endereco.setNumero(rs.getString("num"));
                 endereco.setComplemento(rs.getString("comp_endereco"));
                 endereco.setCep(rs.getString("cep"));
                 contato.setEmail(rs.getString("email"));
                 contato.setCelular(rs.getString("celu"));
                 contato.setTelefone(rs.getString("tele"));
                 contato.setObs(rs.getString("obs_contato"));
                 
                 agendaservico.setAnimal(animal);
                 agendaservico.setServico(servico);
                 agendaservico.setCliente(cliente);
                 agendaservico.setEndereco(endereco);
                 agendaservico.setContato(contato);
                 
                 lista.add(agendaservico);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

        return lista;

    }
    
}
