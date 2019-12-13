/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.model.dao.ClienteDAO;
import com.mycompany.model.dao.ProdutoDAO;
import com.mycompany.model.dao.VendaDAO;
import com.mycompany.model.entity.Cliente;
import com.mycompany.model.entity.ClienteLogado;
import com.mycompany.model.entity.Item;
import com.mycompany.model.entity.Produto;
import com.mycompany.model.entity.Venda;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
public class VendasController {

    @Inject
    ProdutoDAO pdao;

    @Inject
    VendaDAO dao;

    @Inject
    Validator validator;

    @Inject
    HttpSession log;
    
    @Inject 
    private ClienteDAO clienteDAO;

    @Inject
    private Venda venda;
    
    @Inject
    ClienteLogado clientelogado;
     

    @Inject
    private Result result;

    public void form() {
        result.include("produtos", pdao.produtos());
    }

    public void add(Item item) {
        Produto p = pdao.buscar(item.getProduto().getId());
        item.setProduto(p);
        venda.getItens().add(item);
        result.redirectTo(this).form();
    }

    public void logout() {
        log.invalidate();
        result.redirectTo(this).form();
    }

    public void salvar() {
        validator.addIf(venda.getItens().isEmpty(), new I18nMessage("itens", "vazio"));
        validator.onErrorRedirectTo(this).form();
        Venda v = new Venda();
        v.setDataVenda("11/12/2019");
        v.setItens(venda.getItens());
        
       //Cliente c = new Cliente();
        //c.setNome("Silva");
        //c.setSenha("123");
        //c.setUsuario("silva");
        //clienteDAO.salvar(c);
        
        //v.setCliente(c);
        v.setCliente(clientelogado.getCliente());
        
        dao.salvar(v);
        result.redirectTo(this).form();
    }

    public List<Venda> lista() {
        return dao.vendas();
    
        
            
    }

}
