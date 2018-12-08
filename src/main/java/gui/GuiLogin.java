/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Usuario;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiLogin")
@SessionScoped
public class GuiLogin implements Serializable {

    private Usuario usuario = new Usuario();

    public String doEfetuarLogin() {
        if ("admin".equals(usuario.getLogin())
                && "123".equals(usuario.getSenha())) {

            /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
            return "principal";
        }

        //Caso erre o login ou senha fica na mesma tela.
        return null;
    }

    public GuiLogin() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
