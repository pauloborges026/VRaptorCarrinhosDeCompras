/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.model.dao.ClienteDAO;
import com.mycompany.model.entity.Cliente;
import java.util.List;
import javax.inject.Inject;

/**
 * String
 *
 * @author paulo
 */
@Controller
public class ClientesController {

    @Inject
    ClienteDAO dao;

    @Inject
    Validator validator;

    public void form() {
    }  
    

    public List<Cliente> lista() {
        return dao.clientes();
    }

    public void salvar(Cliente cliente, Result result) {
        validator.validate(cliente);
        validator.onErrorRedirectTo(this).form();

        //Long id = cliente.getId();
        if (cliente.getId() == null) {
            dao.salvar(cliente);
        } else {
            dao.update(cliente);
        }
        result.redirectTo(this).lista();

    }

    public void excluir(Long id, Result result) {
        dao.remove(id);
        result.of(this).lista();
    }

    public void alterar(Long id, Result result) {
        Cliente cliente = dao.buscar(id);
        result.include(cliente);
        result.of(this).form();
    }

}
