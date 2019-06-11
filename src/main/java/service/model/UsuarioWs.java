/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.model;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Tiago-PC
 */
public class UsuarioWs {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static List<UsuarioWs> toUsuarioWs(List<Usuario> usuarios) {
        List<UsuarioWs> usw = new ArrayList();

        for (Usuario u : usuarios) {
            UsuarioWs uw = new UsuarioWs();
            uw.setLogin(u.getLogin());
            uw.setSenha(u.getSenha());

            usw.add(uw);
        }

        return usw;
    }

    public static Usuario toUsuario(UsuarioWs usuarioWs) {

        Usuario u = new Usuario();

        u.setLogin(usuarioWs.getLogin());
        u.setSenha(usuarioWs.getSenha());
       

        return u;

    }

}
