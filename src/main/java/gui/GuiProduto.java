/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProdutoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import model.Categoria;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiProduto")
@SessionScoped
public class GuiProduto implements Serializable {

    private List<Produto> produtos;
    private Produto produto;
    private Boolean incluindo;
    private List<Categoria> categorias;

    @EJB
    ProdutoDao daoproduto;

    /**
     * Creates a new instance of GuiProduto
     */
    public GuiProduto() {
    }

    public String iniciarListaProdutos() {
        produtos = daoproduto.getProdutos();
        categorias = new ArrayList();
        categorias.addAll(Arrays.asList(Categoria.values()));
        return "LstProdutos";

    }

    public String novoProduto() {
        produto = new Produto();
        incluindo = true;
        return "CadProdutos";

    }

    public String gravarProduto() {
        if (incluindo == true) {
            daoproduto.incluir(produto);
            System.out.println("Produto criado!");
        } else {
            daoproduto.alterar(produto);
            System.out.println("Produto editado!");
        }
        produto = new Produto();

        produtos = daoproduto.getProdutos();
        return "LstProdutos";
    }

    public String alterarProduto(Produto prod) {
        produto = prod;
        incluindo = false;
        return "CadProdutos";
    }

    public String excluirProduto(Produto produto) {
        try {
            daoproduto.excluir(produto);
            produtos = daoproduto.getProdutos();
            System.out.println("Produto excluido com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro ao excluir produto " + e);
        }
        return "LstProdutos";
    }

    public List<Produto> getProdutos() {
        if (produto == null) {
            produto = new Produto();
        }
        return produtos;

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Boolean getIncluindo() {
        return incluindo;
    }

    public void setIncluindo(Boolean incluindo) {
        this.incluindo = incluindo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
