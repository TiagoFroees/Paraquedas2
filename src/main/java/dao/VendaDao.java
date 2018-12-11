/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ItemVenda;
import model.Produto;
import model.Venda;

/**
 *
 * @author Tiago-PC
 */
public class VendaDao {

    @PersistenceContext
    EntityManager em;

    public void gravar(Venda object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void gravar(ItemVenda object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    @EJB
    ProdutoDao daoProduto;

    public void vender(Venda venda, Produto produto, Integer quantidade, BigDecimal valorVenda) {
        venda.atualizarTotal(quantidade, valorVenda);

        if (venda.getId() == null) {
            this.gravar(venda, false);
        }

        ItemVenda iv = new ItemVenda();
        iv.setVenda(venda);
        iv.setValorVenda(valorVenda);
        iv.setProduto(produto);
        iv.setQuantidade(quantidade);

        this.gravar(iv, false);

        produto.venderProduto(quantidade);
        daoProduto.gravar(produto, true);

    }

    public List<ItemVenda> getItens(Venda venda) {
        Query q = em.createQuery("select d from ItemVenda d where d.venda.id = :id");
        q.setParameter("id", venda.getId());
        return q.getResultList();
    }
}
