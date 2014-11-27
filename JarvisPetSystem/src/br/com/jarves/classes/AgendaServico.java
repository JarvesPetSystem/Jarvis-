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
public class AgendaServico {
    private int idAgendaServico;
    private Date dataAgendaServico;
    private String horaAgendaServico;
    private String statusAgendaServico;
    private Animal animal;
    private Servico servico;
    private Cliente cliente;
    private Logradouro endereco;
    private Contato contato;

    /**
     * @return the idAgendaServico
     */
    public int getIdAgendaServico() {
        return idAgendaServico;
    }

    /**
     * @param idAgendaServico the idAgendaServico to set
     */
    public void setIdAgendaServico(int idAgendaServico) {
        this.idAgendaServico = idAgendaServico;
    }

    /**
     * @return the dataAgendaServico
     */
    public Date getDataAgendaServico() {
        return dataAgendaServico;
    }

    /**
     * @param dataAgendaServico the dataAgendaServico to set
     */
    public void setDataAgendaServico(Date dataAgendaServico) {
        this.dataAgendaServico = dataAgendaServico;
    }

    /**
     * @return the horaAgendaServico
     */
    public String getHoraAgendaServico() {
        return horaAgendaServico;
    }

    /**
     * @param horaAgendaServico the horaAgendaServico to set
     */
    public void setHoraAgendaServico(String horaAgendaServico) {
        this.horaAgendaServico = horaAgendaServico;
    }

    /**
     * @return the statusAgendaServico
     */
    public String getStatusAgendaServico() {
        return statusAgendaServico;
    }

    /**
     * @param statusAgendaServico the statusAgendaServico to set
     */
    public void setStatusAgendaServico(String statusAgendaServico) {
        this.statusAgendaServico = statusAgendaServico;
    }

    /**
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Logradouro getEndereco() {
        return endereco;
    }

    public void setEndereco(Logradouro endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

  
    
}
