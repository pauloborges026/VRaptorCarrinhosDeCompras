/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.model.entity.Venda;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Dependent
public class VendaDAO {

    @Inject
    EntityManager manager;

    public void deletar(Long id) {

        Venda venda = manager.find(Venda.class, id);

        manager.getTransaction().begin();
        try {

            manager.remove(venda);
        } catch (IllegalArgumentException ex) {
            System.out.println("E impossivel remover");
        }
        manager.getTransaction().commit();

    }

    public void atualizar(Venda venda) {
        venda = manager.find(Venda.class, venda.getId());

        manager.getTransaction().begin();
        manager.merge(venda);
        manager.getTransaction().commit();

    }

    public void salvar(Venda v) {
        manager.getTransaction().begin();
        manager.persist(v);
        manager.getTransaction().commit();
    }

    public List<Venda> vendas() {
        Query query = manager.createQuery("from Venda");
        return query.getResultList();
    }
    
      public List<Venda> vendasPorCliente(Long id) {
        Query query = manager.createQuery("select v from Venda v where v.cliente.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }  


}
