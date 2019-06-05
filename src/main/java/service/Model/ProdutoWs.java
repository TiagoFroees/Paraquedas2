/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import model.Categoria;
import model.Produto;

/**
 *
 * @author ewerton10
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

    
    public static List<ProdutoWs> toProdutoWs(List<Produto> produto) {
        List<ProdutoWs> csw = new ArrayList();

        for (Produto p : produto) {
            ProdutoWs cw;
            cw = new ProdutoWs();
                        
           
            cw.setNome(p.getNome());
            cw.setModelo(p.getModelo());
            cw.setCodProduto(p.getCodProduto());
            cw.setEstoque(p.getEstoque());

            csw.add(cw);
        }

        return csw;
    }

    public static Produto toProduto(ProdutoWs produtoWs) {
        Produto p = new Produto();
        p.setCodProduto(produtoWs.getCodProduto());
        p.setNome(produtoWs.getNome());
        p.setModelo(produtoWs.getModelo());
         
       
        
        return p;

    }
 
    }
