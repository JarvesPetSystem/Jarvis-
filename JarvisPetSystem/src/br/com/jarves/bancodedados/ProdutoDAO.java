package br.com.jarves.bancodedados;


import br.com.jarves.classes.Categoria;
import br.com.jarves.classes.PrecoProduto;
import br.com.jarves.classes.Produtos;
import java.sql.CallableStatement;
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
public class ProdutoDAO {
    
    /**
     * Insere um produto
     * @param produtos
     * @return mensagem de sucesso ou insucesso
     */
    public String insereProdutos(Produtos produtos) {
        String msg;
        ConexaoOracle co = new ConexaoOracle();

        try {

            Connection con = co.abreConexao();
            CallableStatement cs = con.prepareCall("{call insere_produto(?,?,?,?,?,?,?,?)}");
            cs.setString(1, produtos.getEanProduto());
            cs.setString(2,produtos.getDescricao());
            cs.setString(3, produtos.getUnidade());
            cs.setString(4, produtos.getCategoria().getNomeCategoria());
            cs.setBigDecimal(5, produtos.getPrecoProduto().getPrecoCompra());
            cs.setBigDecimal(6, produtos.getPrecoProduto().getPrecoVenda());
            cs.setBigDecimal(7, produtos.getPrecoProduto().getLucro());
            cs.setBigDecimal(8, produtos.getPrecoProduto().getImposto());
            cs.execute();
            cs.close();
            con.close();
            msg = "Produto Gravado com Sucesso!";

        } catch (SQLException ex) {
            msg = "Erro: " + ex;
        }

        return msg;
    }
    public String alteraProdutos(Produtos produtos) {
        String msg;
        ConexaoOracle co = new ConexaoOracle();

        try {

            Connection con = co.abreConexao();
            CallableStatement cs = con.prepareCall("{call altera_produto(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, produtos.getIdProduto());
            cs.setString(2, produtos.getEanProduto());
            cs.setString(3,produtos.getDescricao());
            cs.setString(4, produtos.getUnidade());
            cs.setString(5, produtos.getCategoria().getNomeCategoria());
            cs.setBigDecimal(6, produtos.getPrecoProduto().getPrecoCompra());
            cs.setBigDecimal(7, produtos.getPrecoProduto().getPrecoVenda());
            cs.setBigDecimal(8, produtos.getPrecoProduto().getLucro());
            cs.setBigDecimal(9, produtos.getPrecoProduto().getImposto());
            cs.execute();
            cs.close();
            con.close();
            msg = "Produto Gravado com Sucesso!";

        } catch (SQLException ex) {
            msg = "Erro: " + ex;
        }

        return msg;
    }
    
    
    public ArrayList<Produtos> listarProdutos(){
        
        ArrayList<Produtos> lista = new ArrayList<>();
        ConexaoOracle co = new ConexaoOracle();
        try{
            Connection con = co.abreConexao();
            String sql = "SELECT tprod.id_produto id_prod,tprod.ean_produto ean,initcap(tprod.desc_produto)descricao,tprod.un_produto, " +
                        "tpreprod.preco_compra compra,tpreprod.preco_venda venda, tpreprod.imposto imposto, tpreprod.lucro lucro,tcat.nome_categoria " +
                        "FROM tab_produto tprod INNER JOIN tab_preco_produto tpreprod ON  " +
                        "tprod.id_produto IN tpreprod.id_produto_fk INNER JOIN tab_categoria tcat ON " +
                        "tprod.id_categoria_fk in tcat.id_categoria WHERE dt_fim_preco IS NULL ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Produtos produtos = new Produtos();
               PrecoProduto preco = new PrecoProduto();
               Categoria categoria = new Categoria();
               
               categoria.setNomeCategoria(rs.getString("nome_categoria"));
               
               preco.setPrecoCompra(rs.getBigDecimal("compra"));
               preco.setPrecoVenda(rs.getBigDecimal("venda"));
               preco.setImposto(rs.getBigDecimal("imposto"));
               preco.setLucro(rs.getBigDecimal("lucro"));
               
               produtos.setIdProduto(rs.getInt("id_prod"));
               produtos.setEanProduto(rs.getString("ean"));
               produtos.setDescricao(rs.getString("descricao"));
               produtos.setUnidade(rs.getString("un_produto"));
               produtos.setCategoria(categoria);
               produtos.setPrecoProduto(preco);
               lista.add(produtos);
            }
        }catch(Exception ex){
        }
        
        return  lista;
    }
    /**
     * Busca de produtos por codigo do produto
     * @param produto
     * @return 
     */
    public Produtos getProdutos(Produtos produto){
        
        
        ConexaoOracle co = new ConexaoOracle();
        try{
            Connection con = co.abreConexao();
            String sql = "SELECT tprod.id_produto id_prod,tprod.ean_produto ean,initcap(tprod.desc_produto)descricao,tprod.un_produto, " +
                        "tpreprod.preco_compra compra,tpreprod.preco_venda venda, tpreprod.imposto imposto, tpreprod.lucro lucro,initcap(tcat.nome_categoria) categoria " +
                        "FROM tab_produto tprod INNER JOIN tab_preco_produto tpreprod ON  " +
                        "tprod.id_produto IN tpreprod.id_produto_fk INNER JOIN tab_categoria tcat ON " +
                        "tprod.id_categoria_fk in tcat.id_categoria WHERE tprod.ean_produto IN ? AND dt_fim_preco IS NULL";
            System.out.println(sql + "\n" + produto.getEanProduto());
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getEanProduto());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
               
               PrecoProduto preco = new PrecoProduto();
               Categoria categoria = new Categoria();
               
               categoria.setNomeCategoria(rs.getString("categoria"));
               
               preco.setPrecoCompra(rs.getBigDecimal("compra"));
               preco.setPrecoVenda(rs.getBigDecimal("venda"));
               preco.setImposto(rs.getBigDecimal("imposto"));
               preco.setLucro(rs.getBigDecimal("lucro"));
               
               produto.setIdProduto(rs.getInt("id_prod"));
               produto.setEanProduto(rs.getString("ean"));
               produto.setDescricao(rs.getString("descricao"));
               produto.setUnidade(rs.getString("un_produto"));
               produto.setCategoria(categoria);
               produto.setPrecoProduto(preco);
               System.out.println(produto.getCategoria().getNomeCategoria());
            }
            else{
                produto.setDescricao("");
                
            }
                    
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
       
        return  produto;
    }
    
    
}
