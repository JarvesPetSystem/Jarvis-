package br.com.jarves.bancodedados;

import br.com.jarves.classes.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FornecedorDAO {
        
    
    public Fornecedor getFornecedor(Fornecedor fornecedor){
                
        ConexaoOracle co = new ConexaoOracle();
        Logradouro endereco = new Logradouro();
        try {
            
            Connection con = co.abreConexao();
            String sql = "SELECT f.id_fornecedor , te.ID_LOGRADOURO_FK idlog, initcap(f.nome_fornecedor)nome_fornecedor"+
                    " ,l.id_logradouro,l.nome_logradouro, l.cep_logradouro, "+
                    "b.nome_bairro, m.nome_municipio,e.nome_estado "+
                    "FROM tab_fornecedor c INNER JOIN tab_logradouro l "+
                    "ON f.id_logradouro in l.id_logradouro "+
                    "INNER JOIN  tab_bairro b ON l.id_bairro in b.id_bairro INNER JOIN tab_municipio m ON "+ 
                    "b.id_municipio in m.id_municipio INNER JOIN tab_estado e ON m.id_estado IN e.id_estado "+
                    "WHERE f.nome_fornecedor in ? or f.id_fornecedor in ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setInt(2, fornecedor.getIdFornecedor());
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);
            if(rs.next()){
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
                endereco.setIdLogradouro(rs.getInt("idlog"));
                System.out.println(rs.getInt("idlog"));
                endereco.setNomeRua(rs.getString("nome_logradouro"));
                endereco.setBairro(rs.getString("nome_bairro"));
                endereco.setCep(rs.getString("cep_logradouro"));
                endereco.setCidade(rs.getString("nome_municipio"));
                endereco.setEstado(rs.getString("nome_estado"));
                fornecedor.setIdEndereco(endereco);
            }else{
                fornecedor = null;
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            
        }
        //JOptionPane.showMessageDialog(null, user.getNomeUsuario());
        return fornecedor;
    }
    
    /**
     * Insere um cliente no banco de dados
     * @param fornecedor dados do cliente
     * @return Mensagem
     */
    public String insereFornecedor(Fornecedor fornecedor){
        String msg = "";
        ConexaoOracle co = new ConexaoOracle();
        
        try {
            
            Connection con = co.abreConexao();
            CallableStatement cs = con.prepareCall("{call insere_fornecedor(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, fornecedor.getNomeFornecedor());
            cs.setString(2, fornecedor.getCnpj());
            cs.setString(3, fornecedor.getIeFornecedor());
            cs.setString(4, fornecedor.getIdEndereco().getNumero());
            cs.setString(5, fornecedor.getIdEndereco().getComplemento());
            cs.setInt   (6, fornecedor.getIdEndereco().getIdLogradouro());
            cs.setString(7, fornecedor.getIdContato().getEmail());
            cs.setString(8, fornecedor.getIdContato().getTelefone());
            cs.setString(9, fornecedor.getIdContato().getCelular());
            cs.setString(10, fornecedor.getIdContato().getObs());
            cs.execute();
            cs.close();
            con.close();
            msg = "Fornecedor Cadastrado com Sucesso";
            
        } catch (SQLException ex) {
            msg = "Erro"+ex;
        }

        return msg;
    }
    /**
     * Método que pesquisa se o cliente já é cadastrado
     * @param cnpj cpf do cliente
     * @param nome nome do cliente
     * @return ArrayList de clientes 
     */
    public ArrayList<Fornecedor> pesquisarFornecedor(String cnpj,String nome){
       
        ArrayList<Fornecedor> lista = new ArrayList<>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_fornecedor,initcap(nome_fornecedor)nome,cnpj_fornecedor cnpj,ie_fornecedor ie," +
                         "dtcad_fornecedor dtcad,tl.id_logradouro idlog,initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, "+
                         "te.comp_endereco,tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato,initcap(tba.nome_bairro)bairro,"+
                         "initcap(tmu.nome_municipio)cidade,initcap(tes.nome_estado) estado FROM "+
                         "tab_fornecedor tf INNER JOIN tab_endereco te ON tf.id_fornecedor IN te.id_fornecedor_fk INNER JOIN tab_logradouro tl ON "+
                         "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN "+
                         "tab_contato tcon ON tf.id_fornecedor IN tcon.id_fornecedor_fk INNER JOIN tab_bairro tba ON "+
                         "tl.id_bairro IN tba.id_bairro INNER JOIN tab_municipio tmu ON "+
                         "tba.id_municipio IN tmu.id_municipio INNER JOIN tab_estado tes ON "+
                         "tmu.id_estado IN tes.id_estado WHERE tf.nome_fornecedor LIKE ? or tf.cnpj_fornecedor like ?";
            System.out.println(sql + cnpj + nome);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cnpj);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedor fornecedor =  new Fornecedor();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
                
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIeFornecedor(rs.getString("ie"));
                fornecedor.setDtCadFornecedor(rs.getDate("dtcad"));
                endereco.setIdLogradouro(rs.getInt("idlog"));
                System.out.println(rs.getInt("idlog"));
                endereco.setNomeRua(rs.getString("endereco"));
                endereco.setNumero(rs.getString("num"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setComplemento(rs.getString("comp_endereco"));
                endereco.setCep(rs.getString("cep"));
                contato.setEmail(rs.getString("email"));
                contato.setCelular(rs.getString("celu"));
                contato.setTelefone(rs.getString("tele"));
                contato.setObs(rs.getString("obs_contato"));
                fornecedor.setIdEndereco(endereco);
                fornecedor.setIdContato(contato);
                lista.add(fornecedor);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }
    /**
     * Método que lista todos os clientes já cadastrados
     * @return  ArrayList de clientes
     */
    public ArrayList<Fornecedor> listarFornecedor(){
       
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_fornecedor,initcap(nome_fornecedor)nome,cnpj_fornecedor cnpj,ie_fornecedor ie,"+
                         "dtcad_fornecedor dtcad,initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, te.comp_endereco,"+
                         "tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato "+
                         "FROM tab_fornecedor tf INNER JOIN tab_endereco te ON tf.id_fornecedor IN te.id_fornecedor_fk INNER JOIN tab_logradouro tl ON "+
                         "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN tab_contato tcon ON "+
                         "tf.id_fornecedor in tcon.id_fornecedor_fk ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedor fornecedor =  new Fornecedor();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
                
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIeFornecedor(rs.getString("ie"));
                fornecedor.setDtCadFornecedor(rs.getDate("dtcad"));
                endereco.setNomeRua(rs.getString("endereco"));
                endereco.setNumero(rs.getString("num"));
                endereco.setComplemento(rs.getString("comp_endereco"));
                endereco.setCep(rs.getString("cep"));
                contato.setEmail(rs.getString("email"));
                contato.setCelular(rs.getString("celu"));
                contato.setTelefone(rs.getString("tele"));
                contato.setObs(rs.getString("obs_contato"));
                fornecedor.setIdEndereco(endereco);
                fornecedor.setIdContato(contato);
                lista.add(fornecedor);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }
    
    public String atualizaFornecedor(Fornecedor fornecedor) {
        String msg = "";

        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            CallableStatement cs = con.prepareCall("{call altera_fornecedor(?,?,?,?,?,?,?,?,?,?,?)}");
            System.out.println(fornecedor.getIdFornecedor());
            
            cs.setInt   (1, fornecedor.getIdFornecedor());
            cs.setString(2, fornecedor.getNomeFornecedor());
            cs.setString(3, fornecedor.getCnpj());
            cs.setString(4, fornecedor.getIeFornecedor());
            cs.setString(5, fornecedor.getIdEndereco().getNumero());
            cs.setString(6, fornecedor.getIdEndereco().getComplemento());
            cs.setInt   (7, fornecedor.getIdEndereco().getIdLogradouro());
            cs.setString(8, fornecedor.getIdContato().getEmail());
            cs.setString(9, fornecedor.getIdContato().getTelefone());
            cs.setString(10, fornecedor.getIdContato().getCelular());
            cs.setString(11, fornecedor.getIdContato().getObs());
            cs.execute();
            cs.close();
            con.close();
            msg = "Fornecedor Alterado com Sucesso!";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return msg;

    }

}