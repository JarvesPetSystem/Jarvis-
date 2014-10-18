package br.com.jarves.bancodedados;
import br.com.jarves.classes.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Humberto
 */
public class UsuarioDAO {
    public Usuario getUsuario(Usuario usuario){
        
        
        ConexaoOracle co = new ConexaoOracle();
        try {
            
            Connection con = co.abreConexao();
            String sql = "SELECT * FROM tab_usuario";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                usuario.setCodUsuario(rs.getInt("id_user"));
                usuario.setNomeUsuario(rs.getString("nome_user"));
                usuario.setSenhaUsuario(rs.getString("senha_user"));
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        //JOptionPane.showMessageDialog(null, user.getNomeUsuario());
        return usuario;
    }
}
