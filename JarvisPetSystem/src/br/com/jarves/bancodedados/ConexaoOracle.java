package br.com.jarves.bancodedados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoOracle {
    public Connection abreConexao(){
        Connection con = null;
        try {
            //Carrega Driver JDBC
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            
            //Cria conexão com banco de dados
            String database = "jarves";
            String server= "127.0.0.1:1521";
            String username="jarves";
            String password="jarves";
            String url = "jdbc:oracle:thin:@"+server+":XE";
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver não encontrado "+ ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL "+ex.toString());;
        }
        return con;
    }
    public void fecharConexao(ResultSet rs,Statement stmt,Connection con){
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar comunicação com BD "+ ex.toString());
        }
        
    }
    
}
