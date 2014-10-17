package br.com.jarves.bancodedados;

import br.com.jarves.classes.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
        
    
    public Cliente getCliente(Cliente cliente){
                
        ConexaoOracle co = new ConexaoOracle();
        Logradouro endereco = new Logradouro();
        try {
            
            Connection con = ConexaoOracle.abreConexao();
            String sql = "SELECT c.id_cliente, initcap(c.nome_cliente)nome_cliente"+
                    " ,l.id_logradouro,l.nome_logradouro, l.cep_logradouro, "+
                    "b.nome_bairro, m.nome_municipio,e.nome_estado "+
                    "FROM tab_cliente c INNER JOIN tab_logradouro l "+
                    "ON c.id_logradouro in l.id_logradouro "+
                    "INNER JOIN  tab_bairro b ON l.id_bairro in b.id_bairro INNER JOIN tab_municipio m ON "+ 
                    "b.id_municipio in m.id_municipio INNER JOIN tab_estado e ON m.id_estado IN e.id_estado "+
                    "WHERE c.nome_cliente in ? or c.id_cliente in ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setInt(2, cliente.getIdCliente());
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);
            if(rs.next()){
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                endereco.setNomeRua(rs.getString("nome_logradouro"));
                endereco.setBairro(rs.getString("nome_bairro"));
                endereco.setCep(rs.getString("cep_logradouro"));
                endereco.setCidade(rs.getString("nome_municipio"));
                endereco.setEstado(rs.getString("nome_estado"));
                cliente.setEndereco(endereco);
            }else{
                cliente = null;
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            e.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null, user.getNomeUsuario());
        return cliente;
    }
    
    /**
     * Insere um cliente no banco de dados
     * @param cliente dados do cliente
     * @return Mensagem
     */
    public String insereCliente(Cliente cliente){
        String msg = null;
        ConexaoOracle co = new ConexaoOracle();
        
        try {
            
            Connection con = ConexaoOracle.abreConexao();
            CallableStatement cs = con.prepareCall("{call insere_cliente(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, cliente.getNomeCliente());
            cs.setString(2, cliente.getCpf());
            cs.setString(3, cliente.getRg());
            cs.setDate(4, (Date) cliente.getDtNasc());
            cs.setString(5, cliente.getSexo());
            cs.setString(6, cliente.getEndereco().getNumero());
            cs.setString(7, cliente.getEndereco().getComplemento());
            cs.setInt(8, cliente.getEndereco().getIdLogradouro());
            cs.setString(9, cliente.getContato().getEmail());
            cs.setString(10, cliente.getContato().getTelefone());
            cs.setString(11, cliente.getContato().getCelular());
            cs.setString(12, cliente.getContato().getObs());
            cs.execute();
            cs.close();
            con.close();
            msg = "Cliente Cadastrado com Sucesso";
            
        } catch (SQLException ex) {
            msg = "Erro"+ex;
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
            
        }

        return msg;
    }

}
