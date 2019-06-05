/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClienteDao;
import dao.ProdutoDao;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Cliente;

/**
 *
 * @author alagalante
 */
@Named
@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ClienteRes {

    @EJB
    ClienteDao daoCliente;

    @GET
    //@Path("buscarPorLoginSenha/{login}/{senha}")
    @Path("listarcliente")
    //public List<Cliente> buscarClientes(@PathParam("login") String strLogin, @PathParam("senha") String strSenha) {
    public List<Cliente> buscarClientes() {
        return daoCliente.getClientes();

    }

    @POST
    @Path("novoCliente")
    public Response criarNovoUsuarioComCliente(Cliente cliente) {
        try {
            
            daoCliente.incluir(cliente);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

}
