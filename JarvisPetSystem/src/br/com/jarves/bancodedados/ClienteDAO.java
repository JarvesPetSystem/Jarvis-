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

public class ClienteDAO {
        
    
    public Cliente getCliente(Cliente cliente){
                
        ConexaoOracle co = new ConexaoOracle();
        Logradouro endereco = new Logradouro();
        try {
            
            Connection con = co.abreConexao();
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
            
            Connection con = co.abreConexao();
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
        }

        return msg;
    }
    
    public ArrayList<Cliente> pesquisarCliente(String cpf,String nome){
       
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_cliente,initcap(nome_cliente)nome,cpf_cliente cpf,rg_cliente rg, dtnasc_cliente nasc,initcap(sexo_cliente)sexo,"+
                         "dtcad_cliente dtcad,initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, te.comp_endereco,"+
                         "tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato "+
                         "FROM tab_cliente tc INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON "+
                         "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN tab_contato tcon ON "+
                         "tc.id_cliente in tcon.id_cliente_fk WHERE tc.nome_cliente LIKE ? or tc.cpf_cliente like ?";
            System.out.println(sql + nome + cpf);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente =  new Cliente();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
                
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDtNasc(rs.getDate("nasc"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setDtCad(rs.getDate("dtcad"));
                endereco.setNomeRua(rs.getString("endereco"));
                endereco.setNumero(rs.getString("num"));
                endereco.setComplemento(rs.getString("comp_endereco"));
                endereco.setCep(rs.getString("cep"));
                contato.setEmail(rs.getString("email"));
                contato.setCelular(rs.getString("celu"));
                contato.setTelefone(rs.getString("tele"));
                contato.setObs(rs.getString("obs_contato"));
                cliente.setEndereco(endereco);
                cliente.setContato(contato);
                lista.add(cliente);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }
    public ArrayList<Cliente> listarCliente(){
       
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_cliente,initcap(nome_cliente)nome,cpf_cliente cpf,rg_cliente rg, dtnasc_cliente nasc,initcap(sexo_cliente)sexo,"+
                         "dtcad_cliente dtcad,initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, te.comp_endereco,"+
                         "tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato "+
                         "FROM tab_cliente tc INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON "+
                         "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN tab_contato tcon ON "+
                         "tc.id_cliente in tcon.id_cliente_fk ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente =  new Cliente();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
                
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDtNasc(rs.getDate("nasc"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setDtCad(rs.getDate("dtcad"));
                endereco.setNomeRua(rs.getString("endereco"));
                endereco.setNumero(rs.getString("num"));
                endereco.setComplemento(rs.getString("comp_endereco"));
                endereco.setCep(rs.getString("cep"));
                contato.setEmail(rs.getString("email"));
                contato.setCelular(rs.getString("celu"));
                contato.setTelefone(rs.getString("tele"));
                contato.setObs(rs.getString("obs_contato"));
                cliente.setEndereco(endereco);
                cliente.setContato(contato);
                lista.add(cliente);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }

}
