/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.model.entity.Item;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@Dependent
public class ItemDAO {
    @Inject
    EntityManager manager;
    
    public void salvar(Item i){
        manager.getTransaction().begin();
        manager.persist(i);
        manager.getTransaction().commit();
    }
    
    
}

