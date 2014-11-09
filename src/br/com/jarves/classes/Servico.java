/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.classes;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Servico {
 private int idServico;   
    
 private String nomeServico;
 private double precoServico;
 private String descrServico;
 private Date dtCadServico;
    

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }


    public String getDescrServico() {
        return descrServico;
    }

    public void setDescrServico(String descrServico) {
        this.descrServico = descrServico;
    }

    public Date getDtCadServico() {
        return dtCadServico;
    }

    public void setDtCadServico(Date dtCadServico) {
        this.dtCadServico = dtCadServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(double precoServico) {
        this.precoServico = precoServico;
    }
    
}
