/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Compra;
import model.ItemCompra;
import model.Produto;

/**
 *
 * @author Tiago-PC
 */

@Stateless
public class CompraDao {

    @PersistenceContext
    EntityManager em;

    public void gravar(Compra object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void gravar(ItemCompra object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    @EJB
    ProdutoDao daoProduto;

    public void comprar(Compra compra, Produto produto, Integer quantidade, BigDecimal valorCompra) {
        compra.atualizarTotal(quantidade, valorCompra);

        if (compra.getId() == null) {
            this.gravar(compra, false);
        }
        
        
        ItemCompra ic = new ItemCompra();
        ic.setCompra(compra);
        ic.setValorCompra(valorCompra);
        ic.setProduto(produto);
        ic.setQuantidade(quantidade);

        this.gravar(ic, false);

        produto.comprarProduto(quantidade);
        daoProduto.gravar(produto, true);

    }

    public List<ItemCompra> getItens(Compra compra) {
        Query q = em.createQuery("select d from ItemCompra d where d.compra.id = :id");
        q.setParameter("id", compra.getId());
        return q.getResultList();        
    }
}
