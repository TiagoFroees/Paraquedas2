/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDao;
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
import model.Usuario;

/**
 *
 * @author Tiago-PC
 */
@Named
@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioRest {

    @EJB
    UsuarioDao daoUsuario;

    @GET
    //@Path("buscarPorLoginSenha/{login}/{senha}")
    @Path("listarusuarios")
    //public List<Cliente> buscarClientes(@PathParam("login") String strLogin, @PathParam("senha") String strSenha) {
    public List<Usuario> buscarUsuarios() {
        return daoUsuario.getUsuarios();

    }

    @POST
    @Path("novousuario")
    public Response criarNovoUsuario(Usuario usuario) {
        try {

            daoUsuario.incluir(usuario);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

}
