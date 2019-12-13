/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.model.dao.ProdutoDAO;
import com.mycompany.model.entity.Produto;
import com.mycompany.model.entity.Venda;
import java.util.List;
import javax.inject.Inject;

@Controller
public class ProdutosController {

    @Inject
    ProdutoDAO dao;

    @Inject
    Validator validator;

    @Inject
    private Result result;

    @Inject
    Venda venda;

    public void form() {
    }

    public List<Produto> lista() {
        return dao.produtos();
    }

    public void salvar(Produto produto) {
        validator.validate(produto);
        validator.onErrorRedirectTo(this).form();
        
        if (produto.getId() == null) {
            dao.salvar(produto);
        } else {
            dao.update(produto);
        }
        result.redirectTo(this).lista();
    }

    public void editar(Long cod) {
        Produto produto = dao.buscar(cod);
        //faz a inclusão do obj pessoa na página form.jsp
        result.include(produto);
        //redireciona para form.jsp
        result.of(this).form();
    }

    public void excluir(Long id) {
        dao.remove(id);
        //redireciona para listar.jsp
        result.redirectTo(this).lista();
    }
}
