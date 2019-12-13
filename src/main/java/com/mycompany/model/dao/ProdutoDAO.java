/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.model.entity.Produto;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@Dependent
public class ProdutoDAO {
    @Inject
    EntityManager manager;
    
    public void salvar(Produto p){
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
    }
    
    public Produto buscar(Long id){
        Produto p = manager.find(Produto.class, id);
        return p;
    }
    
    public List<Produto> produtos(){
        Query query = manager.createQuery("from Produto");
        return query.getResultList();
    }    
        
    public void remove(Long id){
        manager.getTransaction().begin();
        Produto p = manager.find(Produto.class, id);
        manager.remove(p);
        manager.getTransaction().commit();
    }

    public void update(Produto produto){
        manager.getTransaction().begin();
        manager.merge(produto);
        manager.getTransaction().commit();
    }
}
