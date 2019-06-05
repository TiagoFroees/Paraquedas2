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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Cliente;
import model.Produto;

/**
 *
 * @author Tiago-PC
 */
@Named
@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoRest {

    @EJB
    ProdutoDao daoProduto;

    @GET
    @Path("listarproduto")
    public List<Produto> buscarProdutos() {
        return daoProduto.getProdutos();

    }

    @POST
    @Path("novoProduto")
    public Response criarNovoProduto(Produto produto) {
        try {
            daoProduto.incluir(produto);
           //Produto.toCliente(cliente)
            
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
}
