/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ClienteDao;
import dao.ProdutoDao;
import dao.VendaDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Cliente;
import model.ItemVenda;
import model.Produto;
import model.Venda;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiVenda")
@SessionScoped
public class GuiVenda implements Serializable {

    @EJB
    VendaDao daoVenda;
    @EJB
    ClienteDao daoCliente;
    @EJB
    ProdutoDao daoProduto;

    private List<Produto> lstProdutos;
    private List<Cliente> lstClientes;
    private List<ItemVenda> lstItensVenda;

    private Venda venda;

    private Boolean vendaCriada;

    private String nomeProduto;
    private String nomeCliente;

    private Float valorVenda;
    private Integer quantidade;

    public GuiVenda() {
    }

    private String iniciar() {
        venda = new Venda();

        lstClientes = daoCliente.getClientes();
        lstProdutos = daoProduto.getProdutos();

        vendaCriada = false;

        return "CadVenda";
    }

}
