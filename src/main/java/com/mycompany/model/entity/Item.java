/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Table(name = "tb_item")
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;
    
    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
 
    private double qtd;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Produto getProduto() {
        return produto;
    }

    public double total() {
        return produto.getValor() * qtd;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
    
}
