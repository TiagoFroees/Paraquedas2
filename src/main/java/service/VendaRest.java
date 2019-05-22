/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProdutoDao;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.ItemVenda;
import model.Produto;
import model.Venda;

/**
 *
 * @author Tiago-PC
 */
@Named
@Path("venda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class VendaRest {
   
    @EJB
    ProdutoDao VendaDao;
    
    
    @GET
    
    @Path("listarvenda")
    
    public List<Produto> buscarVendas(){
        return VendaDao.getProdutos();
        
      
        
    } 
}

