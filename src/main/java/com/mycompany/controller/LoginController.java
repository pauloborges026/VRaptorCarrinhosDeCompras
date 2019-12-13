/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.mycompany.model.dao.ClienteDAO;
import com.mycompany.model.entity.Cliente;
import com.mycompany.model.entity.ClienteLogado;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    @Inject
    ClienteDAO dao;
    
    @Inject
    Result result;
    
    @Inject
    private HttpSession session;
    
    @Inject
    ClienteLogado clienteLogado;
    

    public void form(){
        
    }

    public void validar(Cliente cliente){
        if(dao.validarLogin(cliente)){
            Cliente logado = dao.cliente(cliente);
            clienteLogado.setCliente(logado);
            result.redirectTo(VendasController.class).form();
        }else{
                        result.redirectTo(this).form();

        }
    }
    
    
}
