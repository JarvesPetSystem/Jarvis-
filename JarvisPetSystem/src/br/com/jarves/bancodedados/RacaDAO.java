
package br.com.jarves.bancodedados;

import br.com.jarves.classes.Especie;
import br.com.jarves.classes.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 * Mètodo para listar Raças
 * @author Humberto
 */
public class RacaDAO {
    public ArrayList<Raca> listarRacas(int idEspecie){
        ArrayList<Raca> lista = new ArrayList<Raca>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_raca,initcap(nome_raca)raca FROM tab_raca where id_especie_fk in ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idEspecie);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Raca raca = new Raca();
                raca.setIdRaca(rs.getInt("id_raca"));
                raca.setRaca(rs.getString("raca"));
                lista.add(raca);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
    }
}
