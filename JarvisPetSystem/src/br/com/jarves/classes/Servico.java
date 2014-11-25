/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.classes;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Servico {
 private int idServico;   
    
 private String nomeServico;
 private BigDecimal precoServico;
 private String descrServico;
 private Date dtCadServico;
 private Cliente cliente;
 private Animal animal;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public BigDecimal getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(BigDecimal precoServico) {
        this.precoServico = precoServico;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}