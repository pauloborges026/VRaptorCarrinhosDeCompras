/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import br.com.caelum.vraptor.Result;
import com.mycompany.controller.ClientesController;
import com.mycompany.model.entity.Cliente;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author paulo
 */
@Dependent
public class ClienteDAO {

    Result result;

    @Inject
    EntityManager manager;

    public void salvar(Cliente cliente) {

        manager.getTransaction().begin();
        //gravar um Cliente no banco
        manager.persist(cliente);
        manager.getTransaction().commit();

    }

    public Cliente buscar(long id) {
        manager.getTransaction().begin();
        Cliente cliente = manager.find(Cliente.class, id);
        return cliente;
    }

    public List<Cliente> clientes() {
        Query query = manager.createQuery("from Cliente");
        return query.getResultList();
    }

    public void remove(long id) {
        manager.getTransaction().begin();
        manager.remove(manager.find(Cliente.class, id));
        manager.getTransaction().commit();
    }

    public void update(Cliente cliente) {

        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();

    }

    public Cliente cliente(Cliente cliente) {
        try {

            TypedQuery<Cliente> query = manager.createQuery("select u from Cliente u where u.usuario like :user and u.senha like :passwd", Cliente.class);
            query.setParameter("user", cliente.getUsuario());
            query.setParameter("passwd", cliente.getSenha());
            return query.getSingleResult();
        } catch (NoResultException e) {
            result.redirectTo(ClientesController.class).form();
            return cliente;
        }

    }

    public boolean validarLogin(Cliente cliente) {

        TypedQuery<Cliente> query = manager.createQuery("select c from Cliente c where c.usuario like :user and c.senha like :passwd", Cliente.class);
        query.setParameter("user", cliente.getUsuario());
        query.setParameter("passwd", cliente.getSenha());
        return query.getResultList().size() > 0;

        // TypedQuery<Cliente> query = manager.createQuery("select c from Cliente c where c.usuario like :user and c.senha = :passwd", Cliente.class);
        //query.setParameter("user", cliente.getNome());
        //query.setParameter("passwd", cliente.getSenha());
        //return query.getResultList().size() > 0;
    }

}
