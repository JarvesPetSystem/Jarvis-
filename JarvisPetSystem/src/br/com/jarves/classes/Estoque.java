/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.classes;



/**
 *
 * @author Gabriel
 */
public class Estoque {
    
    private int idEstoque;
    private String corEstoque;
    private String ColEstoque;
    private String linEstoque;
    private int qtdeEstoque;
    private Produtos produtos;

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getCorEstoque() {
        return corEstoque;
    }

    public void setCorEstoque(String corEstoque) {
        this.corEstoque = corEstoque;
    }

    public String getColEstoque() {
        return ColEstoque;
    }

    public void setColEstoque(String ColEstoque) {
        this.ColEstoque = ColEstoque;
    }

    public String getLinEstoque() {
        return linEstoque;
    }

    public void setLinEstoque(String linEstoque) {
        this.linEstoque = linEstoque;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produto) {
        this.produtos = produto;
    }

  
}
