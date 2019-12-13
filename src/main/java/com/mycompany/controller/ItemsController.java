/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Result;
import com.mycompany.model.dao.ItemDAO;
import com.mycompany.model.entity.Item;
import javax.inject.Inject;

public class ItemsController {
    @Inject
    ItemDAO idao;
    
    @Inject
    private Result result;
    
    public void form(){
        
    }
    
    public void salvar(Item item){
        
        idao.salvar(item);
        
        result.redirectTo(this).form();
    }
}
