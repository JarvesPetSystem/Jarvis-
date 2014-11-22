package br.com.jarves.bancodedados;

import br.com.jarves.classes.Cliente;
import br.com.jarves.classes.Produtos;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

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
    public String insereCliente(Produtos produtos) {
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
            msg = "Proprietário Inserido com Sucesso";

        } catch (SQLException ex) {
            msg = "Erro" + ex;
        }

        return msg;
    }

    
}
