package br.com.jarves.bancodedados;

import br.com.jarves.classes.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Humberto
 */
public class CategoriaDAO {
    
    
    public String insereCategoria(Categoria categoria){
        String msg;
             
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "INSERT INTO tab_categoria (id_categoria,nome_categoria) VALUES (seq_id_categoria.nextval,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.execute();
            msg = "Categoria Registrada com Sucesso!";
        } catch (SQLException ex) {
            msg = "Erro ao Registar Categoria: "+ex;
        }
        return msg;
    }
    
    /**
     * Altera a Categoria de um Produto
     * @param categoria
     * @return Mensagem de sucesso ou erro na operação
     */
    public String alteraCategoria(Categoria categoria){
        String msg;
             
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "UPDATE tab_categoria SET nome_categoria = ? WHERE id_categoria in ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.execute();
            msg = "Categoria Alterada com Sucesso!";
        } catch (SQLException ex) {
            msg = "Erro ao Registar Categoria: "+ex;
        }
        return msg;
    }
    
    public ArrayList<Categoria> listarCategoria(){
        
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "SELECT id_categoria,initcap(nome_categoria) categoria FROM tab_categoria ORDER BY id_categoria";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("categoria"));
                
                lista.add(categoria);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex); 
        }
        
        return lista;
    }
    
}
