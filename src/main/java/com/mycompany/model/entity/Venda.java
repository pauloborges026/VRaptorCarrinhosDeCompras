/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SessionScoped
@Table(name = "tb_venda")
@Named("venda")
@Entity
public class Venda implements Serializable{

    @Id
    @GeneratedValue
    private Long Id;
    
    private String dataVenda;
    
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_venda")
    private List<Item> itens=new ArrayList();

    
    public double total(){
        double soma=0;
        for(Item item :itens)
            soma = soma + item.total();
        return soma;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
}
