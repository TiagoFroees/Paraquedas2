/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ItemCompra;
import model.Venda;

/**
 *
 * @author Tiago-PC
 */
public class VendaDao {

    @PersistenceContext
    EntityManager em;

    public void incluir(Venda venda) {
        em.persist(venda);
    }

    public void alterar(Venda venda) {
        em.merge(venda);
    }

    public void excluir(Venda venda) {
        em.remove(em.merge(venda));
    }

    public List<ItemCompra> getItensVenda() {
        Query q = em.createQuery("Select  v from Compra  v ");
        return q.getResultList();
    }

}
