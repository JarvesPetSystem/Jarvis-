package br.com.jarves.classes;

import java.util.Date;


public class Fornecedor {
    private int idFornecedor;
    
    private String nomeFornecedor;
    private String cnpj;
    private String ieFornecedor;
    private Contato idContato;
    private Logradouro idEndereco;
    private Date dtCadFornecedor;

    /**
     * @return the idFornecedor
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the ieFornecedor
     */
    public String getIeFornecedor() {
        return ieFornecedor;
    }

    /**
     * @param ieFornecedor the ieFornecedor to set
     */
    public void setIeFornecedor(String ieFornecedor) {
        this.ieFornecedor = ieFornecedor;
    }

    /**
     * @return the idContato
     */
  

    /**
     * @return the idEndereco
     */
 

    /**
     * @return the dtCadFornecedor
     */
    public Date getDtCadFornecedor() {
        return dtCadFornecedor;
    }

    /**
     * @param dtCadFornecedor the dtCadFornecedor to set
     */
    public void setDtCadFornecedor(Date dtCadFornecedor) {
        this.dtCadFornecedor = dtCadFornecedor;
    }

    /**
     * @return the idEndereco
     */
    public Logradouro getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(Logradouro idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the idContato
     */
    public Contato getIdContato() {
        return idContato;
    }

    /**
     * @param idContato the idContato to set
     */
    public void setIdContato(Contato idContato) {
        this.idContato = idContato;
    }
    
}

