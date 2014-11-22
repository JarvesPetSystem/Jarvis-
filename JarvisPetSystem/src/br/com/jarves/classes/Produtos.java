package br.com.jarves.classes;

/**
 *
 * @author Humberto
 */
public class Produtos {
    
    private int idProduto;
    private String eanProduto;
    private String descricao;
    private String unidade;
    private Double quantidade;
    private Categoria categoria;
    private PrecoProduto precoProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getEanProduto() {
        return eanProduto;
    }

    public void setEanProduto(String eanProduto) {
        this.eanProduto = eanProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public PrecoProduto getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(PrecoProduto precoProduto) {
        this.precoProduto = precoProduto;
    }
    
}
