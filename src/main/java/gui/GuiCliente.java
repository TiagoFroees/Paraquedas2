/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ClienteDao;
import model.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiCliente")
@SessionScoped
public class GuiCliente implements Serializable {

    private List<Cliente> clientes;
    private Cliente cliente;
    private Boolean incluindo;

    @EJB
    ClienteDao daocliente;

    /**
     * Creates a new instance of GuiCliente
     */
    public GuiCliente() {
    }

    public String iniciarListaClientes() {
        clientes = daocliente.getClientes();
        return "LstClientes";

    }

    public String novoCliente() {
        cliente = new Cliente();
        incluindo = true;
        return "CadClientes";

    }

    public String gravarCliente() {
        if (incluindo) {
            daocliente.incluir(cliente);
        } else {
            daocliente.alterar(cliente);
        }
        clientes = daocliente.getClientes();
        return "LstClientes";
    }

    public String excluirCliente(Cliente cliente) {
        try {
            daocliente.excluir(cliente);
            clientes = daocliente.getClientes();
            System.out.println("excluido com sucesso!");
            
        } catch (RuntimeException e) {
            System.out.println("erro ao excluir "+e);
        }
        return "LstClientes";
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getIncluindo() {
        return incluindo;
    }

    public void setIncluindo(Boolean incluindo) {
        this.incluindo = incluindo;
    }

}
