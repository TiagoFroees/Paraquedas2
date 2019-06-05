/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import model.Categoria;
import model.Produto;

/**
 *
 * @author Tiago-PC
 */
public class ProdutoWs {

    private String nome;
    private String modelo;
    private Integer codProduto;
    private Integer estoque = 0;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static List<ProdutoWs> toProdutoWs(List<Produto> produtos) {
        List<ProdutoWs> psw = new ArrayList();

        for (Produto p : produtos) {
            ProdutoWs pw = new ProdutoWs();
            pw.setNome(p.getNome());
            pw.setCategoria(p.getCategoria());
            pw.setModelo(p.getModelo());
            pw.setCodProduto(p.getCodProduto());
       

            psw.add(pw);
        }

        return psw;
    }
    
        public static Produto toProduto(ProdutoWs produtoWs) {
        Produto p = new Produto();
        p.setCodProduto(produtoWs.getCodProduto());
        p.setCategoria(produtoWs.getCategoria());
        p.setModelo(produtoWs.getModelo());
        p.setNome(produtoWs.getNome());
       
        
        return p;
        
      
 
        
        }  

}
