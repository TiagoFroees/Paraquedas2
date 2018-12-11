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
import java.math.BigDecimal;
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
    private BigDecimal valorCompra;

    public GuiCompra() {
    }
    
    private String iniciar(){
        
        compra = new Compra();

        lstFornecedores = daoFornecedor.getFornecedores();
        lstProdutos = daoProduto.getProdutos();

        compraCriada = false;

        return "CadCompra";
    }

    private Fornecedor getFornecedorSelecionado() {
        for (Fornecedor f : lstFornecedores) {
            if (f.toString().equals(nomeFornecedor)) {
                return f;
            }
        }
        return null;
    }

    private Produto getProdutoSelecionado() {
        for (Produto p : lstProdutos) {
            if (p.toString().equals(nomeProduto)) {
                return p;
            }
        }

        return null;
    }

    public String adicionarProduto() {
        compra.setFornecedor(getFornecedorSelecionado());
        daoCompra.comprar(compra, getProdutoSelecionado(), quantidade, valorCompra);
        lstItensCompra = daoCompra.getItens(compra);
        compraCriada = true;
        return null;
    }

    public List<Produto> getLstProdutos() {
        return lstProdutos;
    }

    public void setLstProdutos(List<Produto> lstProdutos) {
        this.lstProdutos = lstProdutos;
    }

    public List<Fornecedor> getLstFornecedores() {
        return lstFornecedores;
    }

    public void setLstFornecedores(List<Fornecedor> lstFornecedores) {
        this.lstFornecedores = lstFornecedores;
    }

    public List<ItemCompra> getLstItensCompra() {
        return lstItensCompra;
    }

    public void setLstItensCompra(List<ItemCompra> lstItensCompra) {
        this.lstItensCompra = lstItensCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Boolean getCompraCriada() {
        return compraCriada;
    }

    public void setCompraCriada(Boolean compraCriada) {
        this.compraCriada = compraCriada;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }



}
