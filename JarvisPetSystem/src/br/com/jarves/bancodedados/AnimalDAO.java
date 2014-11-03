package br.com.jarves.bancodedados;

import br.com.jarves.classes.Animal;
import br.com.jarves.classes.Cliente;
import br.com.jarves.classes.Raca;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Humberto
 */
public class AnimalDAO {
    /**
     * Método para cadastro de animais
     * @param animal
     * @return Mensagem de exito ou erro no método
     */
    public String insereAnimal(Animal animal){
        String msg, resul;
        ConexaoOracle co = new ConexaoOracle();
        resul="erro";
        try {
            
            Connection con = co.abreConexao();
            String sql ="INSERT INTO tab_animal (id_animal,id_cliente_fk,id_raca_fk,peso_animal,dtnasc_animal,sexo_animal,"+
                        "status_animal,obs_animal,nome_animal)VALUES " +
                        "(seq_id_animal.nextval,(SELECT id_cliente FROM tab_cliente WHERE cpf_cliente IN ?),?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, animal.getCliente().getCpf());
            stmt.setInt(2, animal.getRaca().getIdRaca());
            stmt.setDouble(3, animal.getPeso());
            stmt.setDate(4, (Date) animal.getDtNasc());
            stmt.setString(5, animal.getSexo());
            stmt.setString(6, animal.getStatus());
            stmt.setString(7, animal.getObs());
            stmt.setString(8, animal.getNome());
            stmt.execute();
            stmt.close();
            stmt.close();
            
            String sqlcon = "SELECT max(id_animal)maxid from tab_animal";
            PreparedStatement pstm = con.prepareStatement(sqlcon);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
               resul =  rs.getString("maxid");
            }
            msg = "Cliente Registrado com Sucesso!" + "\nRGA: "+ resul;
        } catch (SQLException ex) {
            msg = "Erro"+ex;
        }

        return msg;
    }
    
    /**
     * Método para alteração de animais
     * @param animal
     * @return Mensagem de sucesso ou não na operação
     */
    public String alteraAnimal(Animal animal){
    
        
        ConexaoOracle co = new ConexaoOracle();
        String msg;
        try {
            
            Connection con = co.abreConexao();
            String sql ="UPDATE tab_animal SET id_cliente_fk = (SELECT id_cliente FROM tab_cliente WHERE cpf_cliente IN ?), id_raca_fk = ?, peso_animal = ?,"+
                        "dtnasc_animal = ?, sexo_animal = ?, status_animal = ?,"+
                        "obs_animal = ?, nome_animal = ? where id_animal in ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, animal.getCliente().getCpf());
            stmt.setInt(2, animal.getRaca().getIdRaca());
            stmt.setDouble(3, animal.getPeso());
            stmt.setDate(4, (Date) animal.getDtNasc());
            stmt.setString(5, animal.getSexo());
            stmt.setString(6, animal.getStatus());
            stmt.setString(7, animal.getObs());
            stmt.setString(8, animal.getNome());
            stmt.setInt(9, animal.getIdAnimal());
            stmt.execute();
            stmt.close();
            stmt.close();
            msg = "Cliente Alterado com Sucesso";
            
        } catch (SQLException ex) {
            msg = "Erro"+ex;
        }

        return msg;
    }
    
    /**
     * Método para listar todos os animais
     * @return 
     */
    public ArrayList<Animal> listarAnimal(){
       
        ArrayList<Animal> lista = new ArrayList<>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_animal,initcap(nome_animal)nome,ta.peso_animal,ta.dtnasc_animal dtnasc,initcap(tr.nome_raca) raca,initcap(ta.sexo_animal)sexo, " +
                         "initcap(ta.status_animal)status,ta.obs_animal obs,initcap(tc.nome_cliente)nomecli,ta.id_cliente_fk FROM " +
                         "tab_animal ta INNER JOIN tab_cliente tc ON " +
                         "ta.id_cliente_fk IN tc.id_cliente INNER JOIN " +
                         "tab_raca tr on ta.id_raca_fk in tr.id_raca ORDER BY ta.id_animal";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente =  new Cliente();
                Animal animal = new Animal();
                Raca raca = new Raca();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setNome(rs.getString("nome"));
                animal.setPeso(rs.getDouble("peso_animal"));
                animal.setDtNasc(rs.getDate("dtnasc"));
                animal.setSexo(rs.getString("sexo"));
                animal.setStatus(rs.getString("status"));
                animal.setObs(rs.getString("obs"));
                
                cliente.setNomeCliente(rs.getString("nomecli"));
                cliente.setIdCliente(rs.getInt("id_cliente_fk"));
                animal.setCliente(cliente);
                
                raca.setRaca(rs.getString("raca"));
                animal.setRaca(raca);
                
                lista.add(animal);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }
    
    /**
     * Método de Filtro de Animais
     * @param animal
     * @return Todos animais filtrados
     */
    public ArrayList<Animal>filtrarAnimal(String cpf,String id){
        
        ArrayList<Animal> lista = new ArrayList<>();
        ConexaoOracle co = new ConexaoOracle();
        
        try{
            Connection con = co.abreConexao();
            String sql = "SELECT initcap(tc.nome_cliente)cliente,ta.id_animal,initcap(ta.nome_animal)nome,initcap(tr.nome_raca)raca, " +
                         "ta.dtnasc_animal dtnasc, ta.peso_animal,initcap(ta.sexo_animal) sexo,initcap(ta.status_animal)status,ta.obs_animal obs " +
                         "FROM tab_animal ta INNER JOIN tab_cliente tc ON " +
                         "ta.id_cliente_fk IN tc.id_cliente INNER JOIN tab_raca tr ON " +
                         "ta.id_raca_fk IN tr.id_raca WHERE tc.cpf_cliente LIKE ? OR ta.id_animal LIKE ? ORDER BY ta.id_animal";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                Raca raca = new Raca();
                Animal animal = new Animal();
                
                cliente.setNomeCliente(rs.getString("cliente"));
                raca.setRaca(rs.getString("raca"));
                
                animal.setCliente(cliente);
                animal.setRaca(raca);
                animal.setNome(rs.getString("nome"));
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setPeso(rs.getDouble("peso_animal"));
                animal.setDtNasc(rs.getDate("dtnasc"));
                animal.setSexo(rs.getString("sexo"));
                animal.setStatus(rs.getString("status"));
                animal.setObs(rs.getString("obs"));
                lista.add(animal);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }
        
        
        return lista;
    }
}
