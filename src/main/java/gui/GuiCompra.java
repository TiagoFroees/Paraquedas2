/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.CompraDao;
import dao.FornecedorDao;
import dao.ProdutoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Compra;
import model.Fornecedor;
import model.ItemCompra;
import model.Produto;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiCompra")
@SessionScoped
public class GuiCompra implements Serializable {

    @EJB
    CompraDao daoCompra;
    @EJB
    FornecedorDao daoFornecedor;
    @EJB
    ProdutoDao daoProduto;

    private List<Produto> lstProdutos;
    private List<Fornecedor> lstFornecedores;
    private List<ItemCompra> lstItensCompra;

    private Compra compra;

    private Boolean compraCriada;

    private String nomeProduto;
    private String nomeFornecedor;
    
    private Integer quantidade;
    private Float valorCompra;

    public GuiCompra() {

    }

    private String iniciar() {
        compra = new Compra();

        lstFornecedores = daoFornecedor.getFornecedores();
        lstProdutos = daoProduto.getProdutos();

        compraCriada = false;

        return "CadCompra";
    }

}
