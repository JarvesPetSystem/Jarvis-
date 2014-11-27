/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.bancodedados;


import br.com.jarves.classes.Categoria;
import br.com.jarves.classes.Estoque;
import br.com.jarves.classes.PrecoProduto;
import br.com.jarves.classes.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class EstoqueDAO {
    
     public String insereEstoque(Estoque estoque){
        String msg;
             
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "INSERT INTO tab_estoque (id_estoque,id_produto_fk,cor_estoque,col_estoque,lin_estoque,qtde_prod_estoque)"
                    + " VALUES (seq_id_produto.nextval,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, estoque.getProdutos().getIdProduto());
            stmt.setString(2, estoque.getCorEstoque());
            stmt.setString(3, estoque.getColEstoque());
            stmt.setString(4, estoque.getLinEstoque());
            stmt.setInt(5, estoque.getQtdeEstoque());
            
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, estoque.getProdutos().getEanProduto()+"\n"+estoque.getProdutos().getIdProduto());
            msg = "Produto Registrado no Estoque com Sucesso!";
        } catch (Exception ex) {
            msg = "Erro ao Registar Produto no Estoque: "+ex;
        }
        return msg;
    }
     public String alteraEstoque(Estoque estoque){
        String msg;
             
        try {
            ConexaoOracle co = new ConexaoOracle();
            Connection con = co.abreConexao();
            String sql = "UPDATE tab_estoque SET cor_estoque = ?, col_estoque = ?, lin_estoque = ?, qtde_prod_estoque = ? WHERE id_estoque in ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, estoque.getCorEstoque());
            stmt.setString(2, estoque.getColEstoque());
            stmt.setString(3, estoque.getLinEstoque());
            stmt.setInt(4, estoque.getQtdeEstoque());
            stmt.setInt(5, estoque.getIdEstoque());
            stmt.execute();
            msg = "Estoque Alterado com Sucesso!";
        } catch (SQLException ex) {
            msg = "Erro ao Registrar Servico: "+ex;
        }
        return msg;
        
        
    }
    
     
     public Estoque getProdutos(Produtos produto){
        
        Estoque estoque = new Estoque();
        ConexaoOracle co = new ConexaoOracle();
        try{
            Connection con = co.abreConexao();
            String sql = "SELECT id_estoque id_es,id_produto_fk id_prod,cor_estoque cor_es,col_estoque col_es,lin_estoque lin_es, " +
                        "qtde_prod_estoque qtde ,initcap(desc_produto)descricao FROM tab_estoque tes INNER JOIN tab_produto tpro ON " +
                        "tes.id_produto_fk IN tpro.id_produto WHERE tpro.ean_produto IN ?";
            System.out.println(sql + "\n" + produto.getEanProduto());
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getEanProduto());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                            
               produto.setIdProduto(rs.getInt("id_prod"));
               produto.setDescricao(rs.getString("descricao"));
               
               estoque.setIdEstoque(rs.getInt("id_es"));
               estoque.setCorEstoque(rs.getString("cor_es"));
               estoque.setColEstoque(rs.getString("col_es"));
               estoque.setLinEstoque(rs.getString("lin_es"));
               estoque.setQtdeEstoque(rs.getInt("qtde"));
               estoque.setProdutos(produto);
               
            }
            
            co.fecharConexao(rs, stmt, con);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
       
        return  estoque;
    }
     
}
