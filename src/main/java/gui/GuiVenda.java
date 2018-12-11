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
import java.math.BigDecimal;
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

    private Integer quantidade;
    private BigDecimal valorVenda;

    public GuiVenda() {
    }

    public String iniciar() {
        venda = new Venda();

        lstClientes = daoCliente.getClientes();
        lstProdutos = daoProduto.getProdutos();

        vendaCriada = false;

        return "CadVenda";
    }

    private Cliente getClienteSelecionado() {
        for (Cliente c : lstClientes) {
            if (c.toString().equals(nomeCliente)) {
                return c;
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
        venda.setCliente(getClienteSelecionado());
        daoVenda.vender(venda, getProdutoSelecionado(), quantidade, valorVenda);
        lstItensVenda = daoVenda.getItens(venda);
        vendaCriada = true;

        return null;
    }

    public List<Produto> getLstProdutos() {
        return lstProdutos;
    }

    public void setLstProdutos(List<Produto> lstProdutos) {
        this.lstProdutos = lstProdutos;
    }

    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public List<ItemVenda> getLstItensVenda() {
        return lstItensVenda;
    }

    public void setLstItensVenda(List<ItemVenda> lstItensVenda) {
        this.lstItensVenda = lstItensVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Boolean getVendaCriada() {
        return vendaCriada;
    }

    public void setVendaCriada(Boolean vendaCriada) {
        this.vendaCriada = vendaCriada;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

}
