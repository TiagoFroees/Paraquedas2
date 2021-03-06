/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProdutoDao;
import dao.VendaDao;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    VendaDao VendaDao;

    @GET

    @Path("listarvenda")

    public List<Produto> buscarVendas() {
        return null;
        //return VendaDao.getItens(venda);
    
    }

    @POST
    @Path("novavenda")
    public Response criarNovaVenda(Venda venda) {
        try {

            VendaDao.gravar(venda, false);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
}
