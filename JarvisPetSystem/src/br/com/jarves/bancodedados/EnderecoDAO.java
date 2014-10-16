
package br.com.jarves.bancodedados;
import br.com.jarves.classes.Logradouro;
import java.sql.*;
import javax.swing.JOptionPane;


public class EnderecoDAO {
    public Logradouro getEndereco(Logradouro logradouro){
        
        ConexaoOracle co = new ConexaoOracle();
        try {
            
            Connection con = ConexaoOracle.abreConexao();
            String sql = "SELECT tl.id_logradouro,initcap(tl.nome_logradouro) rua,initcap(tb.nome_bairro)bairro,initcap(tm.nome_municipio)municipio, " +
                        "INITCAP(te.nome_estado)estado FROM " +
                        "tab_logradouro tl INNER JOIN tab_bairro tb ON " +
                        "tl.id_bairro IN tb.id_bairro " +
                        "INNER JOIN tab_municipio tm ON " +
                        "tb.id_municipio IN tm.id_municipio " +
                        "INNER JOIN tab_estado te ON " +
                        "tm.id_estado IN te.id_estado " +
                        "WHERE tl.cep_logradouro in ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, logradouro.getCep());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                logradouro.setIdLogradouro(rs.getInt("id_logradouro"));
                logradouro.setNomeRua(rs.getString("rua"));
                logradouro.setBairro(rs.getString("bairro"));
                logradouro.setCidade(rs.getString("municipio"));
                logradouro.setEstado(rs.getString("estado"));
            }else logradouro = null;
            
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return logradouro;
    }
     public static ResultSet listarEnderecos(){
        ResultSet rs = null;
        ConexaoOracle co = new ConexaoOracle();
        try {
            
            Connection con = ConexaoOracle.abreConexao();
            String sql = "SELECT initcap(tl.nome_logradouro) endereço,initcap(tb.nome_bairro)bairro,tl.cep_logradouro cep,initcap(tm.nome_municipio)municipio FROM tab_logradouro tl INNER JOIN tab_bairro tb ON tl.id_bairro IN tb.id_bairro INNER JOIN tab_municipio tm ON tb.id_municipio IN tm.id_municipio ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            //co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return rs;
    }
      public static ResultSet pesquisarEnderecos(String rua){
        ResultSet rs = null;
        ConexaoOracle co = new ConexaoOracle();
        try {
            
            Connection con = ConexaoOracle.abreConexao();
            String sql = "SELECT initcap(tl.nome_logradouro) endereco,initcap(tb.nome_bairro)bairro,tl.cep_logradouro cep,initcap(tm.nome_municipio)municipio, upper(te.sigla_estado)estado FROM tab_logradouro tl INNER JOIN tab_bairro tb ON tl.id_bairro IN tb.id_bairro INNER JOIN tab_municipio tm ON tb.id_municipio IN tm.id_municipio INNER JOIN tab_estado te ON tm.id_estado IN te.id_estado where tl.nome_logradouro like ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, rua);
            rs = stmt.executeQuery();
            
            //co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return rs;
    }
}
